package session10.session10.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<Request, Response> {
    Page<Response> findAll(Pageable pageable);
    Response create(Request req);
    Response update(Request req, Long id);
    Response deleteById(Long id);
}
