package project.springbootchat.service;

import project.springbootchat.model.Room;

public interface RoomService {
    public void createRoom(Room room);

    public Room getRoomByName(String name);
}
