package session02.session02.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IController<T, ID> {
    ResponseEntity<List<T>> findAll(String search);
    ResponseEntity<T> add(T t);
    ResponseEntity<T> update(ID id, T t);
    ResponseEntity<T> delete(ID id);
    T findById(ID id);
}
