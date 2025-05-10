import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * A class to analyze Java source code and extract function signatures.
 * This class processes Java files to identify package declarations,
 * imports, class definitions, and static method signatures.
 */
public class Week10 {
    private static final String PACKAGE_KEYWORD = "package";
    private static final String IMPORT_KEYWORD = "import";
    private static final String CLASS_KEYWORD = "class";
    private static final String STATIC_KEYWORD = "static";
    private static final String ENUM_KEYWORD = "enum";
    private static final String INTERFACE_KEYWORD = "interface";
    private static final String JAVA_LANG_PACKAGE = "java.lang.";
    private static final String SEMICOLON = ";";
    private static final String SPACE = " ";
    private static final String COMMA = ",";
    private static final String OPEN_PAREN = "(";
    private static final String CLOSE_PAREN = ")";
    private static final String OPEN_BRACKET = "<";
    private static final String CLOSE_BRACKET = ">";
    private static final String ARRAY_BRACKETS = "[]";
    private static final String VARARGS = "...";
    private static final String EQUALS = "=";
    private static final String WILDCARD = "?";
    private static final String FINAL_KEYWORD = "final";

    private String packageName;
    private final ArrayList<String> importedLibraries = new ArrayList<>();
    private final ArrayList<String> classNames = new ArrayList<>();
    private final ArrayList<String> staticMethodSignatures = new ArrayList<>();
    private final ArrayList<String> linesWithStaticMethods = new ArrayList<>();

    /**
     * Process package information from a line of code.
     *
     * @param line The line of code containing package information.
     */
    private void processPackage(String line) {
        String[] words = line.trim().split(SPACE);
        packageName = words[words.length - 1].replace(SEMICOLON, "");
    }

    /**
     * Process imported libraries from a line of code.
     *
     * @param line The line of code containing import information.
     */
    private void processImports(String line) {
        String[] words = line.trim().split(SPACE);
        importedLibraries.add(words[words.length - 1].replace(SEMICOLON, ""));
    }

    /**
     * Process class name from a line of code.
     *
     * @param line The line of code containing class information.
     */
    private void processClass(String line) {
        int startIndex = line.indexOf(CLASS_KEYWORD + SPACE) + CLASS_KEYWORD.length() + 1;
        int endIndex = line.indexOf(SPACE, startIndex);
        if (endIndex < 0) {
            System.out.println("Error: No class name found in line: " + line);
            return;
        }

        String className = line.substring(startIndex, endIndex).trim();
        String[] genericParts = className.split(OPEN_BRACKET);
        classNames.add(packageName + "." + genericParts[0]);
    }

    /**
     * Resolve the full qualified name of a library or class.
     *
     * @param name The short name to resolve.
     * @return The fully qualified name.
     */
    private String resolveFullName(String name) {
        // Check imported libraries
        for (String lib : importedLibraries) {
            if (lib.endsWith("." + name)) {
                return lib;
            }
        }

        // Check defined classes
        for (String className : classNames) {
            if (className.endsWith(name)) {
                return className;
            }
        }

        // Check if it's a Java built-in class
        if (Character.isUpperCase(name.charAt(0)) && name.length() > 1) {
            return JAVA_LANG_PACKAGE + name;
        }

        return name;
    }

    /**
     * Process method parameters, handling arrays, varargs, and generics.
     *
     * @param param The parameter string to process.
     * @return The processed parameter string.
     */
    private String processMethodParams(String param) {
        if (param.contains(VARARGS)) {
            return resolveFullName(param.replace(VARARGS, ""));
        }

        if (param.contains(ARRAY_BRACKETS)) {
            int bracketIndex = param.indexOf(ARRAY_BRACKETS);
            return resolveFullName(param.replace(ARRAY_BRACKETS, "")) + ARRAY_BRACKETS;
        }

        if (param.contains(OPEN_BRACKET)) {
            return processGenericParameter(param);
        }

        return resolveFullName(param);
    }

    /**
     * Process generic type parameters.
     *
     * @param param The generic parameter string.
     * @return The processed generic parameter string.
     */
    private String processGenericParameter(String param) {
        int bracketIndex = param.indexOf(OPEN_BRACKET);
        StringBuilder result = new StringBuilder(
            resolveFullName(param.substring(0, bracketIndex)) + OPEN_BRACKET);
        
        String[] typeParams = param.substring(
            bracketIndex + 1, param.length() - 1).split(COMMA + SPACE);
        for (int i = 0; i < typeParams.length; i++) {
            if (i > 0) {
                result.append(COMMA + SPACE);
            }
            if (typeParams[i].startsWith(WILDCARD)) {
                result.append(typeParams[i]);
            } else {
                result.append(resolveFullName(typeParams[i]));
            }
        }
        
        return result.append(CLOSE_BRACKET).toString();
    }

    /**
     * Process static method signatures from a line of code.
     *
     * @param line The line of code containing static method information.
     */
    private void processStaticMethod(String line) {
        if (line.contains(EQUALS)) {
            System.out.println("Error: Line contains equals sign: " + line);
            return;
        }

        int openParenIndex = line.indexOf(OPEN_PAREN);
        int closeParenIndex = line.indexOf(CLOSE_PAREN, openParenIndex);
        if (closeParenIndex == -1 || openParenIndex == -1) {
            System.out.println("Error: No parentheses found in line: " + line);
            return;
        }

        String methodName = line.substring(
            line.substring(0, openParenIndex).lastIndexOf(SPACE) + 1, openParenIndex);
        
        if (closeParenIndex - openParenIndex == 1) {
            staticMethodSignatures.add(methodName + "()");
            return;
        }

        String signature = buildMethodSignature(
            methodName, line.substring(openParenIndex + 1, closeParenIndex));
        staticMethodSignatures.add(signature);
    }

    /**
     * Build a complete method signature from method name and parameters.
     *
     * @param methodName The name of the method.
     * @param params The parameter string.
     * @return The complete method signature.
     */
    private String buildMethodSignature(String methodName, String params) {
        StringBuilder signature = new StringBuilder(methodName + OPEN_PAREN);
        String[] paramList = params.split(COMMA + SPACE);
        
        for (int i = 0; i < paramList.length; i++) {
            if (i > 0) {
                signature.append(COMMA);
            }
            String paramType = paramList[i].substring(0, paramList[i].lastIndexOf(SPACE))
                    .replace(FINAL_KEYWORD, "").trim();
            signature.append(processMethodParams(paramType));
        }
        
        return signature.append(CLOSE_PAREN).toString();
    }

    /**
     * Preprocess the file content to remove unnecessary line breaks.
     *
     * @param fileContent The content of the file to preprocess.
     * @return The preprocessed content.
     */
    private StringBuilder preProcess(String fileContent) {
        StringBuilder result = new StringBuilder(fileContent);
        int openParenIndex = result.indexOf(OPEN_PAREN);
        
        while (openParenIndex != -1) {
            int closeParenIndex = result.indexOf(CLOSE_PAREN, openParenIndex);
            if (closeParenIndex == -1) {
                System.out.println("Error: No closing parenthesis found.");
                break;
            }
            
            for (int i = closeParenIndex; i > openParenIndex; i--) {
                if (result.charAt(i) == '\n') {
                    result.deleteCharAt(i);
                }
            }
            openParenIndex = result.indexOf(OPEN_PAREN, openParenIndex + 2);
        }
        
        return result;
    }

    /**
     * Extract and clean lines from the file content.
     *
     * @param fileContent The content of the file to process.
     * @return An array of cleaned lines.
     */
    private String[] extractLines(String fileContent) {
        StringBuilder processed = preProcess(fileContent);
        
        // Remove single-line comments
        processed = removeSingleLineComments(processed);
        
        // Remove block comments
        processed = removeBlockComments(processed);
        
        return processed.toString().replace("{", "{\n").split("\n");
    }

    /**
     * Remove single-line comments from the content.
     *
     * @param content The content to process
     * @return The content without single-line comments
     */
    private StringBuilder removeSingleLineComments(StringBuilder content) {
        int commentIndex = content.indexOf("//");
        while (commentIndex != -1) {
            int newlineIndex = content.indexOf("\n", commentIndex);
            if (newlineIndex == -1) {
                content.delete(commentIndex, content.length());
                break;
            }
            content.delete(commentIndex, newlineIndex);
            commentIndex = content.indexOf("//");
        }
        return content;
    }

    /**
     * Remove block comments from the content.
     *
     * @param content The content to process.
     * @return The content without block comments.
     */
    private StringBuilder removeBlockComments(StringBuilder content) {
        int startIndex = content.indexOf("/*");
        while (startIndex != -1) {
            int endIndex = content.indexOf("*/", startIndex);
            if (endIndex == -1) {
                System.out.println("Error: No closing block comment found.");
                break;
            }
            content.delete(startIndex, endIndex + 2);
            startIndex = content.indexOf("/*");
        }
        return content;
    }

    /**
     * Get all function signatures from the given file content.
     *
     * @param fileContent The content of the file to process.
     * @return A list of function signatures.
     */
    public List<String> getAllFunctions(String fileContent) {
        String[] lines = extractLines(fileContent);
        
        for (String line : lines) {
            if (line.startsWith(IMPORT_KEYWORD)) {
                processImports(line);
            } else if (line.startsWith(PACKAGE_KEYWORD)) {
                processPackage(line);
            } else if (line.contains(CLASS_KEYWORD)) {
                processClass(line);
            } else if (line.contains(STATIC_KEYWORD)) {
                linesWithStaticMethods.add(line);
            } else if (line.contains(ENUM_KEYWORD)) {
                processClass(line.replace(ENUM_KEYWORD, CLASS_KEYWORD));
            } else if (line.contains(INTERFACE_KEYWORD)) {
                processClass(line.replace(INTERFACE_KEYWORD, CLASS_KEYWORD));
            }
        }

        for (String method : linesWithStaticMethods) {
            processStaticMethod(method);
        }
        
        return staticMethodSignatures;
    }
}
