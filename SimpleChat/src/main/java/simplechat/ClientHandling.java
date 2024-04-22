package simplechat;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class ClientHandling extends Thread {
    private Socket socket;
    private TreeMap<String, PrintWriter> all_out; // Use ConcurrentHashMap for thread safety
    private String myname;

    public ClientHandling(Socket socket, TreeMap<String, PrintWriter> all_out) {
        this.socket = socket;
        this.all_out = all_out;
        this.myname = "DEFAULT";
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) { // AutoFlush for PrintWriter
            out.println("Hello! This is the Java Chat Room. \nEnter BYE to exit.\nEnter your name: ");
            String name = in.readLine();
            while (this.all_out.containsKey(name)) {
                out.println("This name already existed!\nEnter other name:");
                name = in.readLine();
            }
            this.myname = name;
            this.all_out.put(name, out);
            while (true){
                out.println("1. Private chat\n2. Chat room\nYour choice:");
                String type = in.readLine();
                while (!type.trim().equals("1") && !type.trim().equals("2")) {
                    out.println("Error! Please enter 1 or 2 to continue");
                    out.println("1. Private chat\n2. Chat room\nYour choice:");
                    type = in.readLine();
                }
                // Loop for message entry and processing
                out.println("_Let's start your conversation_");
                while (true){
                    String msg= null;
                    String to= null;
                    String con = null;
                    if (type.trim().equals("1")){
                        out.println("If you exit to change to type of chat! Please enter 'exit' at your message");
                        out.println("TO:");
                        to = in.readLine();
                        out.println("Enter your message:");
                        msg = in.readLine();
                        notifyAll(this.myname,msg,"1",to);
                    } else if (type.trim().equals("2")) {
                        out.println("Enter your message:");
                        msg = in.readLine();
                        notifyAll(this.myname,msg,"2",null);
                    }
                    if (msg.trim().toUpperCase().equals("EXIT")) {
                        break;
                    } else if (msg.toUpperCase().trim().equals("BYE")){
                        try {
                            this.socket.close(); // Ensure socket is closed on exit
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        this.all_out.remove(this.myname); // Remove user from the list upon disconnection
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close(); // Ensure socket is closed on exit
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.all_out.remove(this.myname); // Remove user from the list upon disconnection
        }
    }

    public void notifyAll(String name, String msg, String chatType,String to) {
        synchronized (this.all_out) {
            for (Map.Entry<String, PrintWriter> entry : this.all_out.entrySet()) {
                if (chatType == "1" && entry.getKey().equals(to)) {
                    entry.getValue().println("_Private chat_\n" + name + ": " + msg);
                } else if (chatType == "2" && !entry.getKey().equals(name)){ // Send to all except self in chat room mode
                    entry.getValue().println("_Chat room_\n" + name + ": " + msg);
                }
            }
        }
    }
}
