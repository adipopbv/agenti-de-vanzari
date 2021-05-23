package services;

import domain.Order;
import domain.Product;
import domain.User;
import domain.exceptions.SignInException;
import domain.observers.IObserver;
import repositories.IRepository;
import repositories.OrderRepository;
import repositories.ProductRepository;
import repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services implements IServices {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final Map<User, IObserver> signedInClients;

    public Services(UserRepository userRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        signedInClients = new ConcurrentHashMap<>();
    }

    @Override
    public synchronized User signInUser(String username, String password, IObserver client) throws Exception {
        User user = userRepository.getOne(username);
        if (signedInClients.containsKey(user))
            throw new SignInException("user already signed in");
        if (!user.getPassword().equals(password))
            throw new SignInException("incorrect password");
        signedInClients.put(user, client);

        return user;
    }

    @Override
    public void signOutUser(String username, IObserver client) throws Exception {
        User user = userRepository.getOne(username);
        if (!signedInClients.containsKey(user))
            throw new SignInException("user already signed out");
        signedInClients.remove(user);
    }

    @Override
    public Collection<Product> getAllProducts() throws Exception {
        Collection<Product> products = new ArrayList<>();
        for (Product product : productRepository.getAll())
            products.add(product);

        return products;
    }

    @Override
    public Collection<Order> getAllOrders() throws Exception {
        Collection<Order> orders = new ArrayList<>();
        for (Order order : orderRepository.getAll())
            orders.add(order);

        return orders;
    }
}
