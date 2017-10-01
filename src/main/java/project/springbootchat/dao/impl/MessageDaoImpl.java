package project.springbootchat.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import project.springbootchat.dao.MessageDao;
import project.springbootchat.model.Message;
import project.springbootchat.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void createMessage(Message message){
        entityManager.persist(message);
    }

    public List getMessagesInRoom(Room room){
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Message.class);
        criteria.add(Restrictions.eq("room",room));
        return criteria.list();
    }
}
