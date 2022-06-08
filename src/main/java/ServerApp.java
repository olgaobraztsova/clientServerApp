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

            // запрашиваем имя клиента
            out.println("Write your name");

            // считываем поток и запоминаем имя
            String name = in.readLine();

            // уточняем возраст и записываем ответ
            out.println(String.format("%s, are you a child? (yes/no)", name));
            String resp = in.readLine();

            // если клиент ребенок, то приглашаем на игровую площадку
            if (resp.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                // если клиент взрослый, то приглашаем в пространство для взрослых
            } else if (resp.equals("no")) {
                out.println(String.format
                        ("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }
            System.out.println(resp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
