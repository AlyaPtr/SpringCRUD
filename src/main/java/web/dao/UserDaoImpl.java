package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void removeUser(Long id) {
        entityManager.createQuery("delete from User where id=:param")
                .setParameter("param", id).executeUpdate();
    }

    @Override
    public void editUser(User user) {
        User old = getUserById(user.getId());
        if (user.getName() != null && !Objects.equals(user.getName(), "")) {
            old.setName(user.getName());
        }
        if (user.getLastname() != null && !Objects.equals(user.getLastname(), "")) {
            old.setLastname(user.getLastname());
        }
        entityManager.merge(old);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}
