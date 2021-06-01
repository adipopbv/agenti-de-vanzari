package repositories;

import domain.Order;

public interface OrderRepository extends IRepository<Integer, Order> {
    public Iterable<Order> getAllBySalesperson(String username);
}
