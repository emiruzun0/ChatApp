import java.io.*;
import java.net.Socket;


public class MultiClientHandler implements Runnable{
    private Socket client;
    private ObjectInputStream is;
    private ObjectOutputStream os;

    public MultiClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        is = new ObjectInputStream(client.getInputStream());
        os = new ObjectOutputStream(client.getOutputStream());
    }


    @Override
    public void run() {
        try{
            while (true) {
                Message m = (Message) is.readObject();

                MessageOperations.printValues(m);

                os.writeObject("[SERVER RESPONSE] Message was taken from client ! ");

                String tempPri = m.getPriority();
                MessageOperations.addToMessageList(tempPri, m);
                //DbOperations.addToDb(m);

            }
        } catch (IOException e) {
            System.out.println("IO exception in MultiClientHandler ");
            e.printStackTrace();
        } catch (ClassNotFoundException | InterruptedException e) {
            System.out.println("Class not found exception in MultiClientHandler ");
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
