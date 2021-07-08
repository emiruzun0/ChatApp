import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 9090;
    private static ArrayList<MultiClientHandler> clients = new ArrayList<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);

        while(true) {
            System.out.println("[SERVER] Server waiting for client connection");
            Socket client = listener.accept();
            System.out.println("[SERVER] Connected to the client");
            MultiClientHandler clientThread = new MultiClientHandler(client);
            clients.add(clientThread);

            threadPool.execute(clientThread);
        }
    }




}
