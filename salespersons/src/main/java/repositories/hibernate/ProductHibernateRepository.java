package repositories.hibernate;

import domain.Product;
import repositories.ProductRepository;

public class ProductHibernateRepository implements ProductRepository {
    @Override
    public Product getOne(Integer integer) {
        return null;
    }

    @Override
    public Iterable<Product> getAll() {
        return null;
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public Product modify(Integer integer, Product newE) {
        return null;
    }

    @Override
    public Product delete(Integer integer) {
        return null;
    }
}
