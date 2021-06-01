package repositories.hibernate;

import domain.User;
import domain.exceptions.NotFoundException;
import repositories.UserRepository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class UserHibernateRepository extends HibernateRepository implements UserRepository {
    @Override
    public User getOne(String username) throws NotFoundException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                User user = session.createQuery("from User where id like '" + username + "'", User.class).getSingleResult();
                transaction.commit();
                return user;
            } catch (RuntimeException exception) {
                if (transaction != null)
                    transaction.rollback();
                throw new NotFoundException("user not found");
            }
        }
    }

    @Override
    public Iterable<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                users = session.createQuery("select u from User u", User.class).getResultList();
                transaction.commit();
            } catch (RuntimeException exception) {
                if (transaction != null)
                    transaction.rollback();
            }
        }

        return users;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public User modify(String username, User newUser) {
        return null;
    }

    @Override
    public User delete(String username) {
        return null;
    }
}
