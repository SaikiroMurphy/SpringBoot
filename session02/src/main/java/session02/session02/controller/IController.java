package session02.session02.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface IController<T, ID> {
    ResponseEntity<List<T>> findAll(@RequestParam(required = false) String search);
    ResponseEntity<T> add();
    ResponseEntity<T> update(ID id, T t);
    ResponseEntity<T> delete(ID id);
    ResponseEntity<T> findById(ID id);
}
