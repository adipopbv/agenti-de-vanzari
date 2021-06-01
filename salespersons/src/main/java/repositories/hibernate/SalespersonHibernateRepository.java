package repositories.hibernate;

import domain.Salesperson;
import domain.exceptions.NotFoundException;
import repositories.SalespersonRepository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class SalespersonHibernateRepository extends HibernateRepository implements SalespersonRepository {
    @Override
    public Salesperson getOne(String username) throws NotFoundException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Salesperson salesperson = session.createQuery("from Salesperson where id like '" + username + "'", Salesperson.class).getSingleResult();
                transaction.commit();
                return salesperson;
            } catch (RuntimeException exception) {
                if (transaction != null)
                    transaction.rollback();
                throw new NotFoundException("user not found");
            }
        }
    }

    @Override
    public Iterable<Salesperson> getAll() {
        List<Salesperson> salespeople = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                salespeople = session.createQuery("select salesperson from Salesperson salesperson", Salesperson.class).getResultList();
                transaction.commit();
            } catch (RuntimeException exception) {
                if (transaction != null)
                    transaction.rollback();
            }
        }

        return salespeople;
    }

    @Override
    public void add(Salesperson salesperson) {

    }

    @Override
    public Salesperson modify(String username, Salesperson newSalesperson) {
        return null;
    }

    @Override
    public Salesperson delete(String username) {
        return null;
    }
}
