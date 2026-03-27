package session02.session02.repository;

import java.util.List;

public interface IRepository<T, ID> {
    List<T> findAll();
    T add();
    T update(ID id, T t);
    T delete(ID id);
    T findById(ID id);
}
