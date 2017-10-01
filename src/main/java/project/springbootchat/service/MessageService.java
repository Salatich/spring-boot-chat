package project.springbootchat.service;

import project.springbootchat.model.Message;
import project.springbootchat.model.Room;

import java.util.List;

public interface MessageService {

    public void createMessage(Message message);
    public List getMessagesInRoom(Room room);
}
