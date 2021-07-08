import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {

    private static final String IP =  "127.0.0.1";  //Ip address
    private static final int PORT = 9090;           //PORT
    static private ObjectOutputStream os;
    static private ObjectInputStream is;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(IP,PORT);

        os = new ObjectOutputStream(socket.getOutputStream());
        is = new ObjectInputStream(socket.getInputStream());

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            ClientGUI ui = new ClientGUI();
            ui.setVisible(true);
        });

        //socket.close();

    }

    public static void sendObj(Message message) throws IOException, ClassNotFoundException {
        os.writeObject(message);
        String input = (String) is.readObject();
        JOptionPane.showMessageDialog(null,input);
    }
}
