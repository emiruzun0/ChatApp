import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "messages")
public class Message implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "MessageID", unique = true, nullable = false)
    private Integer messageID;

    @Column (name = "CreationTime")
    private  String creationTime;

    @Column (name = "MessageTo")
    private  String messageTo;

    @Column (name = "MessageCc")
    private  String messageCc ;

    @Column (name = "MessageSubject")
    private  String messageSubject;

    @Column (name = "MessageField")
    private  String messageField;

    @Column (name = "Priority")
    private  String priority;

    public Message() {

    }


    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }


    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }


    public String getMessageTo() {
        return messageTo;
    }

    public void setMessageTo(String messageTo) {
        this.messageTo = messageTo;
    }


    public String getMessageCc() {
        return messageCc;
    }

    public void setMessageCc(String messageCc) {
        this.messageCc = messageCc;
    }


    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }


    public String getMessageField() {
        return messageField;
    }

    public void setMessageField(String messageField) {
        this.messageField = messageField;
    }


    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Message(String creationTime, String messageTo, String messageCc , String messageSubject, String messageField, String priority) {
        this.creationTime = creationTime;
        this.messageTo = messageTo;
        this.messageCc = messageCc;
        this.messageSubject = messageSubject;
        this.messageField = messageField;
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "Message{" +
                "\n Message Creation Time : " + creationTime +
                "\nMessage To : " + messageTo +
                "\nMessage Cc : " + messageCc +
                "\nMessage Subject : " + messageSubject  +
                "\nMessage : " + messageField +
                "\nMessage Priority : " + priority  +
                "\n}";
    }
}
