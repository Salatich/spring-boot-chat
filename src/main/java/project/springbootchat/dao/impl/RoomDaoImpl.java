package project.springbootchat.dao.impl;

import org.springframework.stereotype.Repository;
import project.springbootchat.dao.RoomDao;
import project.springbootchat.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class RoomDaoImpl implements RoomDao  {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void createRoom(Room room){
        entityManager.persist(room);
    }

    public Room getRoomByName (String name){
        return entityManager.find(Room.class,name);
    }

}
