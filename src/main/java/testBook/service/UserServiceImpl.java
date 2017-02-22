package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.UserDaoImpl;
import testBook.model.User;

import java.util.List;

/**
 * Created by yasha on 22.02.2017.
 */
public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao;


    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDaoImpl getCUserDao() {
        return userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        this.userDao.removeUser(id);

    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        return this.userDao.listUser();
    }
}
