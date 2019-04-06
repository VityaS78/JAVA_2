package lesson_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            new Thread(() -> {
                try {
                    authentication();
                    readMessege();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка создания обработчика");
        }
    }

    private void authentication() throws IOException {
        while (true) {
            String msg = in.readUTF();
            if (msg.startsWith("/auth")) {
                String[] parts = msg.split("_");
                String nick = server.getAuthService().getNick(parts[1]);
                if (nick != null) {
                    if (!server.isNickBusy(nick)) {
                        sendMessege("/authok_" + nick);
                        name = nick;
                        server.sendMsgToAll(name + "зашёл в чат");
                        server.addClient(this);
                    } else {
                        sendMessege("Учётная запись уже используется.");
                    }
                } else {
                    sendMessege("Ошибка авторизации");
                }
            }
        }
    }

    private void readMessege() throws IOException {
        while (true) {
            String strFromClient = in.readUTF();
            System.out.println("Сщщбщение от " + name + " : " + strFromClient);
            server.distributeMsg(strFromClient);
        }
    }

    private void closeConnection(){
        server.removeClient(this);
        server.sendMsgToAll(name + " покинул чат");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessege(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}