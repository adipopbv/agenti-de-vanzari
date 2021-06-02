package repositories;

import domain.exceptions.DuplicateException;
import domain.exceptions.NotFoundException;

public interface IRepository<Id, E> {
    E getOne(Id id) throws NotFoundException;

    Iterable<E> getAll();

    void add(E e) throws DuplicateException;

    E modify(Id id, E newE) throws NotFoundException, DuplicateException;

    E delete(Id id) throws NotFoundException;
}
