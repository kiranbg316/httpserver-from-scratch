
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StaticFileHandler {
    private Socket clientSocket;

    public StaticFileHandler(String clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void handle(String requestedFile) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedOutputStream out = new BufferedOutputStream(clientSocket.getOutputStream());
            String requestLine = in.readLine();
            System.out.println("request: " + requestLine);
            String fileName = requestLine.split("")[1];
            if (fileName.equals("/")) {
                fileName = "/index.html";
            }
            String filePath = "day4/public" + fileName;
            File file = new File(filePath);

            if (file.exists() && !file.isDirectory()) {
                String contentType = Files.probeContentType(Paths.get(filePath));
                byte[] fileContent = Files.readAllBytes(Paths.get(filePath));

                String responseHeader = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: " + contentType + "\r\n" +
                        "Content-Length: " + fileContent.length + "\r\n" +
                        "\r\n";
                out.write(responseHeader.getBytes());
                out.write(fileContent);

            } else {
                String response = "HTTP/1.1 404 Not Found\r\n" +
                        "Content-Type: text/plain\r\n" +
                        "Content-Length: 13\r\n" +

            "\r\n" + "404 Not Found";
                out.write(response.getBytes());
            }
            out.flush();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();


        }


    }

}

