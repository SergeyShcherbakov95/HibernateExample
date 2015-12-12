package shcherbakov.sergey.hibernateExample.dao;

import shcherbakov.sergey.hibernateExample.model.User;

/**
 *
 * @author sergey
 */
public interface UserDao {
    public void add(User user);
    
    public User getUser(Integer id);
    
    public void remove(Integer id);
}
