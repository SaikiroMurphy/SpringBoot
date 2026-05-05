package session15.session15.service;

import session15.session15.model.dto.request.ProductCreateDTO;
import session15.session15.model.dto.request.ProductUpdateDTO;
import session15.session15.model.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> findAll();

    ProductResponseDTO create(ProductCreateDTO req);

    ProductResponseDTO update(Long id, ProductUpdateDTO req);

    void delete(Long id);
}
