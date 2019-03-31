package lesson_6.H_W;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDRES = "localhost";
        final int SERVER_PORT = 8080;

        try {
            System.out.println("Подключаемся к серверу");
            Socket socket = new Socket(SERVER_ADDRES, SERVER_PORT);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner keyboard = new Scanner(new DataInputStream(System.in));

            new Thread (() -> {
                while (true) {
                    try{
                        String msgToServer = keyboard.nextLine();
                        dataOutputStream.writeUTF(msgToServer);
                        dataOutputStream.flush();
                    } catch(IOException e){
                        System.err.println("Ощибка передачи данных");
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true) {
                try {
                    String msgFromServer = dataInputStream.readUTF();
                    if ("exit".equalsIgnoreCase(msgFromServer)) {
                        System.exit(0);
                    }
                    System.out.println("Сервер: " + msgFromServer);
                } catch (IOException e) {
                    System.err.println("Ощибка приема данных");
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            System.err.println("Ощибка подключения");
            e.printStackTrace();
        }

    }
}
