import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientApp {

    public static void main(String[] args) {

        String host = "netology.homework";
        int port = 8089;

        try (Socket socket = new Socket(host, port); // ждем подключения
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

            // считываем первый вопрос сервера
            String question = in.readLine();
            System.out.println(question);

            // если запрашивается имя, то отправляем  имя
            if (question.equals("Write your name")) {
                out.println("Petya");
                System.out.println("Petya");
            }

            // второй запрос сервера
            question = in.readLine();
            System.out.println(question);

            // ответ на запрос сервера ребенок/взрослый
            if(question.contains("are you a child")) {
                out.println("no");
                System.out.println("no");
            }

            question = in.readLine();
            System.out.println(question);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
