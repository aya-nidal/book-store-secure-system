package fin.fintechpath.com.bookstoresecuresystem.Service;

import fin.fintechpath.com.bookstoresecuresystem.model.Book;
import fin.fintechpath.com.bookstoresecuresystem.model.Store;
import fin.fintechpath.com.bookstoresecuresystem.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private StoreRepository storeRepository;
    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getAllStore() {
        return storeRepository.findAll();
    }
    public Store getStore(int id) {
        return storeRepository.findById((long) id).get();
    }
    public List<Book> findAllBookByStoreId(int id) {
        return storeRepository.findById((long) id).get().getBooks();
    }
}
