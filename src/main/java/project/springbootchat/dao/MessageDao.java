package project.springbootchat.dao;

import project.springbootchat.model.Message;
import project.springbootchat.model.Room;

import java.util.List;

public interface MessageDao {
    public void createMessage(Message message);
    public List getMessagesInRoom(Room room);
}
