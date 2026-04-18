package session11.session11.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<Request, ID, Response> {
    List<Response> getAll ();
    Page<Response> getAll (Pageable pageable);
    Response create (Request req);
    Response update (Request req, ID id);
    Response deleteById (ID id);
    Response findById (ID id);
}
