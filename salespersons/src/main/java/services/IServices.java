package services;

import domain.Order;
import domain.Product;
import domain.User;
import domain.observers.IObserver;

import java.util.Collection;

public interface IServices {
    User signInUser(String username, String password, IObserver client) throws Exception;

    void signOutUser(String username, IObserver client) throws Exception;

    Collection<Product> getAllProducts() throws Exception;

    Collection<Order> getAllOrders() throws Exception;
}
