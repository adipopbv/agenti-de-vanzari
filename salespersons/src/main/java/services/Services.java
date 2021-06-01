package services;

import domain.Client;
import domain.Order;
import domain.Product;
import domain.Salesperson;
import domain.exceptions.SignInException;
import domain.observers.IObserver;
import repositories.ClientRepository;
import repositories.OrderRepository;
import repositories.ProductRepository;
import repositories.SalespersonRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services implements IServices {
    private final SalespersonRepository salespersonRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final Map<Salesperson, IObserver> signedInClients;

    public Services(SalespersonRepository salespersonRepository, ClientRepository clientRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.salespersonRepository = salespersonRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        signedInClients = new ConcurrentHashMap<>();
    }

    @Override
    public synchronized Salesperson signInUser(String username, String password, IObserver client) throws Exception {
        Salesperson salesperson = salespersonRepository.getOne(username);
        if (signedInClients.containsKey(salesperson))
            throw new SignInException("user already signed in");
        if (!salesperson.getPassword().equals(password))
            throw new SignInException("incorrect password");
        signedInClients.put(salesperson, client);

        return salesperson;
    }

    @Override
    public void signOutUser(String username, IObserver client) throws Exception {
        Salesperson salesperson = salespersonRepository.getOne(username);
        if (!signedInClients.containsKey(salesperson))
            throw new SignInException("user already signed out");
        signedInClients.remove(salesperson);
    }

    @Override
    public Collection<Client> getAllClients() {
        Collection<Client> clients = new ArrayList<>();
        for (Client client : clientRepository.getAll())
            clients.add(client);

        return clients;
    }

    @Override
    public Collection<Product> getAllProducts() {
        Collection<Product> products = new ArrayList<>();
        for (Product product : productRepository.getAll())
            products.add(product);

        return products;
    }

    @Override
    public Collection<Order> getAllOrders() {
        Collection<Order> orders = new ArrayList<>();
        for (Order order : orderRepository.getAll())
            orders.add(order);

        return orders;
    }
}
