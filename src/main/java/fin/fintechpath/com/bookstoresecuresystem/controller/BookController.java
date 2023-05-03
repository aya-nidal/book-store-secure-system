package fin.fintechpath.com.bookstoresecuresystem.controller;

import fin.fintechpath.com.bookstoresecuresystem.Service.BookService;
import fin.fintechpath.com.bookstoresecuresystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }


}
