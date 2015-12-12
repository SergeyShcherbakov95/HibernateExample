import shcherbakov.sergey.hibernateExample.Util.HibernateUtil;
import shcherbakov.sergey.hibernateExample.dao.UserDao;
import shcherbakov.sergey.hibernateExample.dao.UserDaoImpl;
import shcherbakov.sergey.hibernateExample.model.User;


public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
    
        User user = new User();
        user.setName("Sergey");
        user.setAge(20);
        user.setEmail("Sergey.shcherbakov95@gmail.com");
        
        userDao.add(user);
        
        //System.out.println(userDao.getUser(1));
        //System.out.println(userDao.getUser(2));
        
        //userDao.remove(6);
        
        HibernateUtil.shutdown();
    }
}
