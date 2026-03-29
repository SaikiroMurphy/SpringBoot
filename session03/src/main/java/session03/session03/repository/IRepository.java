package session03.session03.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    T create(T t);
    T update(String id, T t);
    T detele(String id);
    T findById(String id);
}
