package session08.session08.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session08.session08.model.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
