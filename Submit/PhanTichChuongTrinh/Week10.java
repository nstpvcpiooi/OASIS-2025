import java.util.ArrayList;
import java.util.List;

public class Week10 {
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
        line = line.trim();
        String[] words = line.split(" ");
        packageName = words[words.length - 1].replace(";", "");
    }

    /**
     * Process imported libraries from a line of code.
     *
     * @param line The line of code containing import information.
     */
    private void processImports(String line) {
        line = line.trim();
        String[] words = line.split(" ");
        importedLibraries.add(words[words.length - 1].replace(";", ""));
    }

    /**
     * Process class name from a line of code.
     *
     * @param line The line of code containing class information.
     */
    private void processClass(String line) {
        int start = line.indexOf("class ") + 6;
        int end = line.indexOf(" ", start);
        if (end < 0) {
            return;
        }
        String name = line.substring(start, end).trim();
        String[] splits = name.split("<");
        classNames.add(packageName + "." + splits[0]);
    }

    /**
     * Fix the library or class name if necessary.
     *
     * @param str The library or class name to fix.
     * @return The fixed library or class name.
     */
    private String fixLibrary(String str) {
        for (String lib : importedLibraries) {
            if (lib.endsWith("." + str)) {
                return lib;
            }
        }
        for (String c : classNames) {
            if (c.endsWith(str)) {
                return c;
            }
        }
        if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z' && str.length() > 1) {
            return "java.lang." + str;
        }
        return str;
    }

    /**
     * Process method parameters from a string.
     *
     * @param str The string containing method parameters.
     * @return The processed method parameters.
     */
    private String processMethodParams(String str) {
        if (str.contains("...")) {
            return fixLibrary(str.replace("...", ""));
        }
        if (str.contains("[]")) {
            int i = str.indexOf("[]");
            return fixLibrary(str.replace("[]", "")) + str.substring(i);
        }
        if (str.contains("<")) {
            int i = str.indexOf("<");
            StringBuilder fixedParamStr = new StringBuilder(fixLibrary(str.substring(0, i)) + "<");
            String[] params = str.substring(i + 1, str.length() - 1).split(", ");
            for (int j = 0; j < params.length; j++) {
                if (j != 0) {
                    fixedParamStr = new StringBuilder(fixedParamStr.toString().concat(", "));
                }
                if (params[j].startsWith("?")) {
                    fixedParamStr = new StringBuilder(fixedParamStr.toString().concat(params[j]));
                } else {
                    fixedParamStr.append(fixLibrary(params[j]));
                }
            }
            return fixedParamStr.toString().concat(">");
        } else {
            return fixLibrary(str);
        }
    }

    /**
     * Process static method signatures from a line of code.
     *
     * @param line The line of code containing static method information.
     */
    private void processStaticMethod(String line) {
        if (line.contains("=")) {
            return;
        }
        int opi = line.indexOf("(");
        int cpi = line.indexOf(")", opi + 1);
        if (cpi == -1 || opi == -1) {
            return;
        }
        String name = line.substring(line.substring(0, opi).lastIndexOf(" ") + 1, opi);
        if (cpi - opi == 1) {
            staticMethodSignatures.add(name.concat("()"));
            return;
        }
        String signature = name + "(";
        String params = line.substring(opi + 1, cpi);
        String[] paramList = params.split(", ");
        for (int i = 0; i < paramList.length; i++) {
            if (i != 0) {
                signature = signature.concat(",");
            }
            String paramPart = paramList[i].substring(0, paramList[i].lastIndexOf(" "));
            String paramstr = paramPart.replace("final", "").trim();
            String param = processMethodParams(paramstr);
            signature = signature.concat(param);
        }
        signature = signature.concat(")");
        staticMethodSignatures.add(signature);
    }

    /**
     * Preprocess the file content to remove unnecessary lines.
     *
     * @param fileContent The content of the file to preprocess.
     * @return The preprocessed content of the file.
     */
    private StringBuilder preProcess(String fileContent) {
        StringBuilder result = new StringBuilder(fileContent);
        int opi = result.indexOf("(");
        while (opi != -1) {
            int cpi = result.indexOf(")", opi);
            if (cpi == -1 || opi == -1) {
                return result;
            }
            for (int i = cpi; i > opi; i--) {
                if (result.charAt(i) == '\n') {
                    result.deleteCharAt(i);
                }
            }
            opi = result.indexOf("(", opi + 2);
        }
        return result;
    }

    /**
     * Extract lines from the file content, removing comments and unnecessary characters.
     *
     * @param fileContent The content of the file to extract lines from.
     * @return An array of lines extracted from the file content.
     */
    private String[] extractLines(String fileContent) {
        StringBuilder preProcessed = preProcess(fileContent);

        int lci = preProcessed.indexOf("//");
        while (lci != -1) {
            int nli = preProcessed.indexOf("\n", lci);
            if (nli == -1) {
                preProcessed.delete(lci, preProcessed.length());
                break;
            }
            preProcessed.delete(lci, nli);
            lci = preProcessed.indexOf("//");
        }
        // Xử lý comment khối
        int bci = preProcessed.indexOf("/*");
        while (bci != -1) {
            int bcei = preProcessed.indexOf("*/", bci);
            if (bcei == -1) {
                break;
            }
            preProcessed.delete(bci, bcei + 3);
            bci = preProcessed.indexOf("/*");
        }

        String cleanedContent = preProcessed.toString();

        return cleanedContent.replace("{", "{\n").split("\n");
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
            if (line.startsWith("import")) {
                processImports(line);
            } else if (line.startsWith("package")) {
                processPackage(line);
            } else if (line.contains("class")) {
                processClass(line);
            } else if (line.contains("static")) {
                linesWithStaticMethods.add(line);
            } else if (line.contains("enum")) {
                processClass(line.replace("enum", "class"));
            } else if (line.contains("interface")) {
                processClass(line.replace("interface", "class"));
            }
        }
        for (String method : linesWithStaticMethods) {
            processStaticMethod(method);
        }
        return staticMethodSignatures;
    }


}
