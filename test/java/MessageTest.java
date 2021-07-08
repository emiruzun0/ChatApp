import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    Message message = new Message("time","to","cc","subject","field","priority");

    @Test
    void getCreationTime(){
        assertEquals(message.getCreationTime(),"time");
    }

    @Test
    void setCreationTime() {
        message.setCreationTime("newTime");
        assertEquals(message.getCreationTime(),"newTime");
    }

    @Test
    void getMessageTo() {
        assertEquals(message.getMessageTo(),"to");
    }

    @Test
    void setMessageTo(){
        message.setMessageTo("newTo");
        assertEquals(message.getMessageTo(),"newTo");
    }

    @Test
    void getMessageCc() {
        assertEquals(message.getMessageCc(),"cc");

    }

    @Test
    void setMessageCc() {
        message.setMessageCc("newCc");
        assertEquals(message.getMessageCc(),"newCc");
    }

    @Test
    void getMessageSubject(){
        assertEquals(message.getMessageSubject(),"subject");
    }

    @Test
    void setMessageSubject() {
        message.setMessageSubject("newSubject");
        assertEquals(message.getMessageSubject(),"newSubject");
    }

    @Test
    void getMessageField() {
        assertEquals(message.getMessageField(),"field");
    }

    @Test
    void setMessageField(){
        message.setMessageField("newField");
        assertEquals(message.getMessageField(),"newField");
    }

    @Test
    void getPriority() {
        assertEquals(message.getPriority(),"priority");
    }

    @Test
    void setPriority() {
        message.setPriority("newPriority");
        assertEquals(message.getPriority(),"newPriority");
    }
}