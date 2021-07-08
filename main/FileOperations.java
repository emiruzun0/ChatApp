import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations implements Runnable {
    private static String path = "C:\\Users\\Administrator\\Desktop\\";
    private final int priority;


    public FileOperations(int priority) {
        this.priority = priority;
    }

    @Override
    public synchronized void run() {
        String tempPath = path;
        File dir;
        switch (priority) {
            case 1:
                tempPath += "high";
                dir = new File(tempPath);
                dir.mkdir();
                try {
                    createHighFiles(tempPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                tempPath += "medium";
                dir = new File(tempPath);
                dir.mkdir();
                try {
                    createMediumFiles(tempPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                tempPath += "low";
                dir = new File(tempPath);
                dir.mkdir();
                try {
                    createLowFiles(tempPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private synchronized void createLowFiles(String tempPath) throws IOException {
        int lowSize = MessageOperations.lowMessages.size();
        String uniqueId,filename ;
        FileWriter stream;
        BufferedWriter out;
        while(lowSize > 0){
            uniqueId = MessageOperations.lowMessages.peek().getCreationTime();
            DbOperations.addToDb(MessageOperations.lowMessages.peek());
            filename = tempPath + "\\" + uniqueId + ".txt";
            stream = new FileWriter(filename,true);
            out = new BufferedWriter(stream);
            out.write(MessageOperations.lowMessages.remove().toString());
            out.close();
            System.out.println(lowSize + ". file with low priority was created");
            lowSize--;
        }
    }

    private synchronized void  createMediumFiles(String tempPath) throws IOException {
        int mediumSize = MessageOperations.mediumMessages.size();
        String uniqueId,filename ;
        FileWriter stream;
        BufferedWriter out;
        while(mediumSize > 0){
            uniqueId = MessageOperations.mediumMessages.peek().getCreationTime();
            DbOperations.addToDb(MessageOperations.mediumMessages.peek());
            filename = tempPath + "\\" + uniqueId + ".txt";
            stream = new FileWriter(filename,true);
            out = new BufferedWriter(stream);
            out.write(MessageOperations.mediumMessages.remove().toString());
            out.close();
            System.out.println(mediumSize + ". file with low priority was created");
            mediumSize--;
        }
    }

    private synchronized void createHighFiles(String tempPath) throws IOException {
        int highSize = MessageOperations.highMessages.size();
        String uniqueId,filename ;
        FileWriter stream;
        BufferedWriter out;
        while(highSize > 0){
            uniqueId = MessageOperations.highMessages.peek().getCreationTime();
            DbOperations.addToDb(MessageOperations.highMessages.peek());
            filename = tempPath + "\\" + uniqueId + ".txt";
            stream = new FileWriter(filename,true);
            out = new BufferedWriter(stream);
            out.write(MessageOperations.highMessages.remove().toString());
            out.close();
            System.out.println(highSize + ". file with low priority was created");
            highSize--;
        }
    }


}
