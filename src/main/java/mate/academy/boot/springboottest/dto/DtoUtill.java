package mate.academy.boot.springboottest.dto;

import mate.academy.boot.springboottest.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class DtoUtill {

    public static Book dtoToBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setPrice(bookDto.getPrice());

        return book;
    }
}
