package repositories.hibernate;

import domain.Client;
import domain.exceptions.DuplicateException;
import domain.exceptions.NotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientHibernateRepository extends HibernateRepository implements ClientRepository {
    @Override
    public Client getOne(Integer id) throws NotFoundException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Client client = session.createQuery("from Client where id = " + id, Client.class).getSingleResult();
                transaction.commit();
                return client;
            } catch (RuntimeException exception) {
                if (transaction != null)
                    transaction.rollback();
                throw new NotFoundException("client not found");
            }
        }
    }

    @Override
    public Iterable<Client> getAll() {
        List<Client> salespeople = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                salespeople = session.createQuery("select c from Client c", Client.class).getResultList();
                transaction.commit();
            } catch (RuntimeException exception) {
                if (transaction != null)
                    transaction.rollback();
            }
        }

        return salespeople;
    }

    @Override
    public void add(Client client) throws DuplicateException {

    }

    @Override
    public Client modify(Integer id, Client newClient) throws NotFoundException, DuplicateException {
        return null;
    }

    @Override
    public Client delete(Integer id) throws NotFoundException {
        return null;
    }
}
