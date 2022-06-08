import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientApp {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 8089;

        try (Socket socket = new Socket(host, port); // ждем подключения
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

            out.println("Petya");
            System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
