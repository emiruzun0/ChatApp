import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class MessageOperations {
    protected static LinkedList<Message> highMessages = new LinkedList<>();
    protected static LinkedList<Message> mediumMessages = new LinkedList<>();
    protected static LinkedList<Message> lowMessages = new LinkedList<>();
    private static Thread hThread, mThread, lThread;
    private static FileOperations f1, f2, f3;
    private static Message[] messages = new Message[8];




    protected static void addToMessageList(String tempPri, Message message) throws IOException, InterruptedException {

        switch (tempPri) {
            case "Low":
                lowMessages.add(message);
                break;
            case "Medium":
                mediumMessages.add(message);
                break;
            case "High":
                highMessages.add(message);
                break;
            default:
                System.out.println("You've entered the wrong priority");
                System.exit(0);
        }
        createMessageObject();

        startThreads();
    }

    private static void createMessageObject() {
        ArrayList<String> priorities = new ArrayList<>();
        priorities.add("low");
        priorities.add("medium");
        priorities.add("high");
        for(int i = 0;i<8;++i){
            messages[i] = new Message(String.valueOf(i),
                    String.valueOf(i),String.valueOf(i),
                    String.valueOf(i),String.valueOf(i),
                    priorities.get(i%3));
            switch (i%3){
                case 0:
                    lowMessages.add(messages[i]);
                    break;
                case 1:
                    mediumMessages.add(messages[i]);
                    break;
                case 2:
                    highMessages.add(messages[i]);
                    break;
            }
        }
    }

    private static void startThreads() {
        f1 = new FileOperations(3);
        f2 = new FileOperations(2);
        f3 = new FileOperations(1);

        lThread = new Thread(f1);
        lThread.setPriority(Thread.MIN_PRIORITY);
        mThread = new Thread(f2);
        mThread.setPriority(Thread.NORM_PRIORITY);
        hThread = new Thread(f3);
        hThread.setPriority(Thread.MAX_PRIORITY);

        lThread.start();
        mThread.start();
        hThread.start();
    }


    public static void printValues(Message m) {
        System.out.println("************************************************************");
        System.out.println("[SERVER] Message To : " + m.getMessageTo());
        System.out.println("[SERVER] Message Cc : " + m.getMessageCc());
        System.out.println("[SERVER] Message Subject : " + m.getMessageSubject());
        System.out.println("[SERVER] Message Priority : " + m.getPriority());
        System.out.println("************************************************************");
    }
}
