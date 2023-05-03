package fin.fintechpath.com.bookstoresecuresystem.repository;

import fin.fintechpath.com.bookstoresecuresystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
