package session08.session08.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import session08.session08.model.dto.request.BookCreateDTO;
import session08.session08.model.dto.request.BookUpdateStockDTO;
import session08.session08.model.entity.Book;
import session08.session08.service.BookService;

import java.io.IOException;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @PostMapping()
    public Book addBook(@ModelAttribute BookCreateDTO req) throws IOException {
        Book book = bookService.createBook(req);
        
        return book;
    }
    
    @PatchMapping("/update/{id}")
    public Book updateBook(@RequestBody @Valid BookUpdateStockDTO req, @PathVariable Long id) {
        Book book = bookService.updateBook(id, req);

        return book;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return book;
    }
    
}
