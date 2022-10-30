package services;

import dataaccess.UserDB;
import java.util.ArrayList;
import models.User;

/**
 *
 * @author Hu Peng
 */
public class UserService {
    private UserDB userDB;
 
    public UserService() {
    }

    public ArrayList<User> getAll() throws Exception {
        userDB = new UserDB();
        ArrayList<User> users = userDB.getAll();
        return users;
    }

    // return the User based on their email
    public User getUser(String Email) throws Exception {

        userDB = new UserDB();
        return userDB.getUser(Email);
    }

    public void updateUser(User user) throws Exception {
        userDB = new UserDB();
        userDB.update(user);
    }

    public void insert(User user) throws Exception {
        userDB.insert(user);
    }

    public void delete(User user) throws Exception {
    
        userDB = new UserDB();
        userDB.delete(user);
        
    }

}
