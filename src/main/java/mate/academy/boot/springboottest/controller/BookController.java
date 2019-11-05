package mate.academy.boot.springboottest.controller;

import mate.academy.boot.springboottest.dto.BookDto;
import mate.academy.boot.springboottest.dto.DtoUtill;
import mate.academy.boot.springboottest.entity.Book;
import mate.academy.boot.springboottest.repository.BookRepository;
import mate.academy.boot.springboottest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> allBooks() {
        return bookService.allBooks();
    }

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable("bookId") long id) {
        return bookService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can`t find book with id:" + id));
    }

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Long id) {
        bookService.delete(id);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable("bookId") Long id,
                           @Valid @RequestBody BookDto bookDto){
        return bookService.update(id, bookDto);
    }
}
