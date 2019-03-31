package lesson_6.H_W;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Сервер запущен, ожидаем подключения...");
            Socket client = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
            Scanner keyboard = new Scanner(new DataInputStream(System.in));

            dataOutputStream.writeUTF("Вы подключились к серверу");

            new Thread(() ->{
                String msgToClient = null;
                while (true) {
                    try {
                        msgToClient = keyboard.nextLine();
                        dataOutputStream.writeUTF(msgToClient);
//                        dataOutputStream.writeUTF("На сервер поступило Ваше сообщение: " + msgClient);
                        dataOutputStream.flush();
                    } catch (IOException e) {
                        System.err.println("Ощибка передачи данных");
                        e.printStackTrace();
                    }
                }
            }).start();

            String msgFromClient = null;
            while (true) {
                try {
                    System.out.println("Ожидаем сообщения от клиента");
                    msgFromClient = dataInputStream.readUTF();

                    if ("exit".equalsIgnoreCase(msgFromClient)) {
                        System.out.println("Клиент хочет завешить сеанс");
                        dataOutputStream.writeUTF(msgFromClient);
                        dataOutputStream.flush();
                        System.exit(0);
                    }
                    System.out.println("Сообщение от клиента: " + msgFromClient);
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
