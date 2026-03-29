package session03.session03.controller;

import java.util.List;

import session03.session03.utils.ApiResponse;

public interface IController<T> {
    ApiResponse<List<T>> findAll();
    ApiResponse<T> create(T t);
    ApiResponse<T> update(String id, T t);
    ApiResponse<T> delete(String id);
    ApiResponse<T> findById(String id);

}
