package project.springbootchat.dao;


import project.springbootchat.model.Room;

public interface RoomDao {
    public void createRoom(Room room);

    public Room getRoomByName(String name);
}
