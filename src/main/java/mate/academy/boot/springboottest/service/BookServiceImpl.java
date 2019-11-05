package mate.academy.boot.springboottest.service;

import mate.academy.boot.springboottest.dto.BookDto;
import mate.academy.boot.springboottest.dto.DtoUtill;
import mate.academy.boot.springboottest.entity.Book;
import mate.academy.boot.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public void addBook(BookDto bookDto) {
        Book newBook = DtoUtill.dtoToBook(bookDto);
        bookRepository.save(newBook);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book update(Long id, BookDto bookDto) {
        Book updatedBook = DtoUtill.dtoToBook(bookDto);
        Book book = findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can`t find book with id: " + id));
        updatedBook.setId(book.getId());
        bookRepository.deleteById(id);
        return bookRepository.saveAndFlush(updatedBook);
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
}
