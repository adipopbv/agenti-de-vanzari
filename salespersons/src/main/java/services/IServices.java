package services;

import domain.Client;
import domain.Order;
import domain.Product;
import domain.Salesperson;
import domain.observers.IObserver;

import java.util.Collection;

public interface IServices {
    Salesperson signInUser(String username, String password, IObserver client) throws Exception;

    void signOutUser(String username, IObserver client) throws Exception;

    Collection<Client> getAllClients();

    Collection<Product> getAllProducts();

    Collection<Order> getAllOrders();

    Collection<Order> getAllOrdersBySalesperson(String username);
}
