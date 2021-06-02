package repositories.hibernate;

import domain.Product;
import domain.exceptions.NotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductHibernateRepository extends HibernateRepository implements ProductRepository {
    @Override
    public Product getOne(Integer id) throws NotFoundException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Product product = session.createQuery("from Product where id = " + id, Product.class).getSingleResult();
                transaction.commit();
                return product;
            } catch (RuntimeException exception) {
                if (transaction != null)
                    transaction.rollback();
                throw new NotFoundException("product not found");
            }
        }
    }

    @Override
    public Iterable<Product> getAll() {
        List<Product> salespeople = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                salespeople = session.createQuery("select p from Product p", Product.class).getResultList();
                transaction.commit();
            } catch (RuntimeException exception) {
                if (transaction != null)
                    transaction.rollback();
            }
        }

        return salespeople;
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public Product modify(Integer id, Product newOrder) {
        return null;
    }

    @Override
    public Product delete(Integer id) {
        return null;
    }
}
