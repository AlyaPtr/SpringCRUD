package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> getAllUsers();

    void removeUser(Long id);

    void editUser(User user);

    User getUserById(long id);
}
