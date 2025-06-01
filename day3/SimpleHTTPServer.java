import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class SimpleHTTPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("HTTP server started on port 8080. waiting for client ...");
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

// Read and print client request lines until empty line
            String line;
            while (!(line = in.readLine()).isEmpty()) {
                System.out.println(line);
            }

// Prepare simple HTML response
            String responseBody = "<html><body><h1>Hello from SimpleHTTPServer</h1></body></html>";

// Write HTTP response headers and body
            out.write("HTTP/1.1 200 OK\r\n");
            out.write("Content-Type: text/html\r\n");
            out.write("Content-Length: " + responseBody.length() + "\r\n");
            out.write("\r\n"); // empty line between headers and body
            out.write(responseBody);

            out.flush();
            clientSocket.close();
            System.out.println("connection closed.server stopped.");

            System.out.println("client connected!");
            clientSocket.close();
            serverSocket.close();
            System.out.println("connection closed.server stopped.");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
