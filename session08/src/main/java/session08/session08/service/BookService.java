package session08.session08.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import session08.session08.exception.ResourceNotFoundException;
import session08.session08.model.dto.request.BookCreateDTO;
import session08.session08.model.dto.request.BookUpdateStockDTO;
import session08.session08.model.entity.Book;
import session08.session08.repository.BookRepository;
import session08.session08.utils.mapper.BookMapper;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book createBook(BookCreateDTO dto) throws IOException {
        Book book = BookMapper.mapToEntity(dto);
        String url = FileService.saveFile(dto.getCoverImage());
        book.setCoverUrl(url);
        bookRepository.save(book);
        return book;
    }

    public Book updateBook(Long id, BookUpdateStockDTO dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sách có ID = " + id));
        book.setStock(dto.getStock());
        bookRepository.save(book);
        return book;
    }

    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sách có ID = " + id));
        return book;
    }
}
