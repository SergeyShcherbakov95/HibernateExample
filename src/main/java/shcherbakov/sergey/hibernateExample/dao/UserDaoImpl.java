package shcherbakov.sergey.hibernateExample.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import shcherbakov.sergey.hibernateExample.model.User;
import shcherbakov.sergey.hibernateExample.Util.HibernateUtil;

/**
 *
 * @author sergey
 */
public class UserDaoImpl implements UserDao{
    private final static Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public void add(User user) {
        logger.info("start adding user -" + user);
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        
        } catch (Exception  e){
            logger.error("Error in add(user) - " + user + ". Exception - " + e);
        }
        logger.info("finish adding user -" + user);
    }

    @Override
    public User getUser(Integer id) {
        logger.info("start getting user with id =" + id);
        User user = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
       
        session.beginTransaction();
        user = (User)session.get(User.class, id);
        session.getTransaction().commit();
       
        } catch (Exception  e){
            logger.error("Error in get(id) id =  " + id + ". Exception - " + e);
        }
        if(user == null)
            logger.info("finish getting user with id =" + id + ". User does not exist.");
        else
            logger.info("finish getting user with id =" + id + ". User - " + user);
        return user;
    }

    @Override
    public void remove(Integer id) {
        logger.info("start deleting user with id =" + id);
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
       
        session.beginTransaction();
        User user = (User)session.get(User.class, id);
        if(user == null)
            logger.info("User with id = " + id + " does not exist");
        else
            session.delete(user);
        session.getTransaction().commit();
        
        } catch (Exception  e){
            logger.error("Error in remove(id) id =  " + id + ". Exception - " + e);
        }
        logger.info("finish deleting user with id =" + id);
    }
    
}
