import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class ChatServer {
    private int port = 8189;
    public ChatServer() {
    }

    public ChatServer(int port) {
        this.port = port;
    }

    public void service() {
        try {
            ServerSocket server = new ServerSocket(port);

            Socket socket = server.accept();
            try {

                DataInputStream in = new DataInputStream(socket
                        .getInputStream());

                DataOutputStream out = new DataOutputStream(socket
                        .getOutputStream());

                Scanner scanner = new Scanner(System.in);
                while (true) {

                    String accept = in.readUTF();
                    System.out.println(accept);
                    String send = scanner.nextLine();
                    System.out.println("Server：" + send);

                    out.writeUTF("Server：" + send);
                }
            } finally {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer().service();
    }
}  