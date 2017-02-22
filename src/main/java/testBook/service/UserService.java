package testBook.service;

import testBook.model.User;

import java.util.List;

/**
 * Created by yasha on 22.02.2017.
 */
public interface UserService {

    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(Long id);
    public User getUserById(Long id);
    public List<User> listUser();
}
