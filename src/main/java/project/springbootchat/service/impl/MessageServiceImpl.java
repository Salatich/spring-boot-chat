package project.springbootchat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.springbootchat.dao.MessageDao;
import project.springbootchat.model.Message;
import project.springbootchat.model.MessageWrapper;
import project.springbootchat.model.Room;
import project.springbootchat.service.MessageService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    public void createMessage(Message message){
        messageDao.createMessage(message);
    }

    public List getMessagesInRoom(Room room){
        ArrayList<MessageWrapper> messages = new ArrayList<>();
        for(Object object : messageDao.getMessagesInRoom(room)){
            MessageWrapper mw = new MessageWrapper();
            mw.setText(((Message)object).getText());
            mw.setUserName(((Message)object).getUser().getLogin());
            messages.add(mw);
        }
        return messages;
    }
}
