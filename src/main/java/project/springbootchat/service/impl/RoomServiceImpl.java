package project.springbootchat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.springbootchat.dao.RoomDao;
import project.springbootchat.model.Room;
import project.springbootchat.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomDao roomDao;
    public void createRoom(Room room){
        roomDao.createRoom(room);
    }

    public Room getRoomByName (String name){
        return roomDao.getRoomByName(name);
    }
}
