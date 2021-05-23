package repositories;

import domain.Product;

public interface IRepository<Id, E> {
    E getOne(Id id);

    Iterable<E> getAll();

    void add(E e);

    E modify(Id id, E newE);

    E delete(Id id);
}
