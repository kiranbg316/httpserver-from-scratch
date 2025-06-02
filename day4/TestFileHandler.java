//public class TestFileHandler {
//    public static void main(String[] args) {
//        String rootDirectory = "C:/Users/Kiran/Desktop/http-server-scratch/day4/public";  // adjust path if needed
//        String requestedFile = "/index.html";  // change to test different files
//
//        StaticFileHandler handler = new StaticFileHandler(rootDirectory);
//        String response = handler.handle(requestedFile);
//        System.out.println(response);
//    }
//}
import java.io.*;

public class TestFileHandler {
    public static void main(String[] args) {
        String rootDirectory = "C:/Users/Kiran/Desktop/http-server-scratch/day4/public"; // adjust as needed
        String requestedFile = "/index.html";  // Or any file in the public directory

        StaticFileHandler handler = new StaticFileHandler(rootDirectory);

        try {
            // Capture the output into a byte stream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            handler.handle(requestedFile, outputStream);

            // Convert the byte stream to a string and print
            String response = outputStream.toString("UTF-8");
            System.out.println(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
