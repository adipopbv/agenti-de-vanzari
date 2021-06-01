package repositories.hibernate;

import domain.Order;
import domain.exceptions.NotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderHibernateRepository extends HibernateRepository implements OrderRepository {
    @Override
    public Order getOne(Integer id) throws NotFoundException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Order order = session.createQuery("from Order where id = " + id, Order.class).getSingleResult();
                transaction.commit();
                return order;
            } catch (RuntimeException exception) {
                if (transaction != null)
                    transaction.rollback();
                throw new NotFoundException("order not found");
            }
        }
    }

    @Override
    public Iterable<Order> getAll() {
        List<Order> salespeople = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                salespeople = session.createQuery("select order from Order order", Order.class).getResultList();
                transaction.commit();
            } catch (RuntimeException exception) {
                if (transaction != null)
                    transaction.rollback();
            }
        }

        return salespeople;
    }

    @Override
    public void add(Order order) {

    }

    @Override
    public Order modify(Integer id, Order newOrder) {
        return null;
    }

    @Override
    public Order delete(Integer id) {
        return null;
    }
}
