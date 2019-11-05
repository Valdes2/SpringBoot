package mate.academy.boot.springboottest.controller;

import mate.academy.boot.springboottest.dto.BookDto;
import mate.academy.boot.springboottest.entity.Book;
import mate.academy.boot.springboottest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InjectData {

    @Autowired
    BookService bookService;

    @PostConstruct
    public void initData() {
        createBooks();
    }

    private void createBooks() {
        BookDto bible = new BookDto("Bible", 1567, 550.00);
        bookService.addBook(bible);
        BookDto mobidic = new BookDto("Mobidic", 1984, 235.00);
        bookService.addBook(mobidic);
        BookDto book1 = new BookDto("The Great Gatsby", 1928, 47.00);
        bookService.addBook(book1);
        BookDto book2 = new BookDto("1984", 1976, 80.00);
        bookService.addBook(book2);
        BookDto book3 = new BookDto("Malleus Maleficarum", 1487, 440.00);
        bookService.addBook(book3);
    }
}
