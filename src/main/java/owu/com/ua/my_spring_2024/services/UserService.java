package owu.com.ua.my_spring_2024.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import owu.com.ua.my_spring_2024.dao.UserDao;
import owu.com.ua.my_spring_2024.models.User;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(int id) {
        return userDao.findById(id).get();
    }

    public List<User> deleteUserById(int id) {
        userDao.deleteById(id);
        return userDao.findAll();
    }

}
