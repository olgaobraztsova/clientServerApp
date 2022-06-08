import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {

        int port = 8089;

        try (ServerSocket serverSocket = new ServerSocket(port); // запускаем сервер
             Socket clientSocket = serverSocket.accept(); // ждем подключения
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

            System.out.println("New connection accepted");

            // считываем поток
            String name = in.readLine();

            // отправляем ответ
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
