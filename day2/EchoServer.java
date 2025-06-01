import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on the port " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client Connected");
            System.out.println("client waiting for message if no message client will close the connection");
            clientSocket.close();
            System.out.println("Client connection closed");

        }catch (IOException e){
            System.err.println("Error occured in the server:");
            e.printStackTrace();

        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                    System.out.println("Server is closed.");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
            }
        }
    }

