package mate.academy.boot.springboottest.repository;

import mate.academy.boot.springboottest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
