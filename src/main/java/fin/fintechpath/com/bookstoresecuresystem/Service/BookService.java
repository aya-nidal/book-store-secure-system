package fin.fintechpath.com.bookstoresecuresystem.Service;

import fin.fintechpath.com.bookstoresecuresystem.model.Book;
import fin.fintechpath.com.bookstoresecuresystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }


}
