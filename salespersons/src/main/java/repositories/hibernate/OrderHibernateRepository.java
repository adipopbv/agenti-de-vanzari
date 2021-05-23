package repositories.hibernate;

import domain.Order;
import repositories.OrderRepository;

public class OrderHibernateRepository implements OrderRepository {
    @Override
    public Order getOne(Integer integer) {
        return null;
    }

    @Override
    public Iterable<Order> getAll() {
        return null;
    }

    @Override
    public void add(Order order) {

    }

    @Override
    public Order modify(Integer integer, Order newE) {
        return null;
    }

    @Override
    public Order delete(Integer integer) {
        return null;
    }
}
