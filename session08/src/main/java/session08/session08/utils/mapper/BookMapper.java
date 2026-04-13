package session08.session08.utils.mapper;

import session08.session08.model.dto.request.BookCreateDTO;
import session08.session08.model.entity.Book;

public class BookMapper {
    public static Book mapToEntity(BookCreateDTO dto) {
        Book entity = new Book();
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setStock(dto.getStock());
        return entity;
    }
}
