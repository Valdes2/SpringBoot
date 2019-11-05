package mate.academy.boot.springboottest.service;

import mate.academy.boot.springboottest.dto.BookDto;
import mate.academy.boot.springboottest.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void addBook(BookDto bookDto);

    void delete(Long id);

    Book update(Long id, BookDto bookDto);

    Optional<Book> findById(Long bookId);

    List<Book> allBooks();
}
