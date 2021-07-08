import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientGUI extends JFrame{
    private JPanel form;
    private JTextField MessageToTextField;
    private JLabel MessageToLabel;
    private JLabel MessageSubjectLabel;
    private JTextField MessageSubjectTextField;
    private JLabel MessageCcLabel;
    private JTextField MessageCcTextField;
    private JButton sendButton;
    private JTextField priorityField;
    private JLabel PriorityLabel;
    private JLabel messageLabel;
    private JTextArea msgField;
    private JComboBox priorityBox;
    protected Message message;

    public ClientGUI(){
        add(form);
        setSize(1000,500);
        setTitle("Chat Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getfromUI();
                setUI();
                try {
                    Client.sendObj(message);
                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    private void setUI() {
        MessageToTextField.setText("");
        MessageCcTextField.setText("");
        MessageSubjectTextField.setText("");
        msgField.setText("");
    }

    private void getfromUI() {
        String creationTime,to,cc,subject,messageField,priority;
        to = MessageToTextField.getText();
        cc = MessageCcTextField.getText();
        subject = MessageSubjectTextField.getText();
        priority = (String) priorityBox.getSelectedItem();
        messageField = msgField.getText();
        creationTime = String.valueOf(System.currentTimeMillis());
        message = new Message(creationTime, to, cc, subject, messageField, priority);
    }

}
