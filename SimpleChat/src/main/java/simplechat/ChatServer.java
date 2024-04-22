package simplechat;
import java.io.*;
import java.net.*;
import java.util.TreeMap;

public class ChatServer {
    public static void main(String[] agrs){
        try {
            TreeMap<String,PrintWriter> sockets = new TreeMap<>();
            ServerSocket server = new ServerSocket(8080);
            System.out.println("List of sockets connected to server:");
            int count = 1;
            while (true){
                Socket client = server.accept();
                new ClientHandling(client,sockets).start();
                System.out.println(count+". "+client);
                count++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
