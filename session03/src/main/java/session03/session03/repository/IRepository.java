package session03.session03.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    List<T> findAll();
    T create(T t);
    T update(String id, T t);
    T detele(String id);
    Optional<T> findById(String id);
}
