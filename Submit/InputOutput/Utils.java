import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Utils {
    // a. Đọc nội dung file
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // b. Ghi nội dung vào file (xóa nội dung cũ)
    public static void writeContentToFile(String path, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // c. Ghi bổ sung nội dung vào cuối file
    public static void appendContentToFile(String path, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // d. Tìm kiếm file theo tên trong thư mục (đệ quy)
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) return null;
        File[] files = folder.listFiles();
        if (files == null) return null;
        for (File file : files) {
            if (file.isDirectory()) {
                File found = findFileByName(file.getAbsolutePath(), fileName);
                if (found != null) return found;
            } else if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }
}
