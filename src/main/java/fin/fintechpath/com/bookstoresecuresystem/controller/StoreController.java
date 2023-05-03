package fin.fintechpath.com.bookstoresecuresystem.controller;

import fin.fintechpath.com.bookstoresecuresystem.Service.StoreService;
import fin.fintechpath.com.bookstoresecuresystem.model.Book;
import fin.fintechpath.com.bookstoresecuresystem.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    private StoreService storeService;
    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/stores")
    public List<Store> getAllStore() {
        return storeService.getAllStore();
    }

    @GetMapping("/stores/{id}")
    public Store getStore(@PathVariable int id) {
        return storeService.getStore(id);
    }

    @GetMapping("/stores/{id}/books")
    public List<Book> getAllBookByStoreId(@PathVariable int id) {
        System.out.println(id);
        return storeService.findAllBookByStoreId(id);
    }
}
