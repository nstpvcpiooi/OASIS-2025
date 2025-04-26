import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Week8Task2 {
    /** nullPointerEx. */
    public void nullPointerEx() throws NullPointerException {
        String result = null;
        String[] s = result.split(" ");
    }

    /** nullPointerExTest. */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
            return "Exception not found";
        } catch (NullPointerException e) {
            return "Lỗi Null Pointer";
        }
    }

    /** arrayIndexOutOfBoundsEx. */
    public void arrayIndexOutOfBoundsEx() throws ArrayIndexOutOfBoundsException {
        int[] a = new int[5];
        a[10] = 1;
    }

    /** arrayIndexOutOfBoundsExTest. */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
            return "Exception not found";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Lỗi Array Index Out of Bounds";
        }
    }

    /** arithmeticEx. */
    public void arithmeticEx() {
        int a = 0;
        int b = 5 / a;
    }

    /** arithmeticExTest. */
    public String arithmeticExTest() {
        try {
            arithmeticEx();
            return "Exception not found";
        } catch (ArithmeticException e) {
            return "Lỗi Arithmetic";
        }
    }

    /** fileNotFoundEx. */
    public void fileNotFoundEx() throws FileNotFoundException {
        FileReader fileReader = new FileReader("filenotfound.txt");
    }

    /** fileNotFoundExTest. */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
            return "Exception not found";
        } catch (FileNotFoundException e) {
            return "Lỗi File Not Found";
        }
    }

    /** ioEx. */
    public void ioEx() throws IOException {
        FileWriter fileWriter = new FileWriter("ioexceptionfile.txt");
        fileWriter.write("Sample text");
        fileWriter.close();
        fileWriter.write("This will cause an IOException");
    }

    /** ioExTest. */
    public String ioExTest() {
        try {
            ioEx();
            return "Exception not found";
        } catch (IOException e) {
            return "Lỗi IO";
        }
    }
}
