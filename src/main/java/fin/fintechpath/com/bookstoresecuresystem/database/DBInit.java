package fin.fintechpath.com.bookstoresecuresystem.database;

import fin.fintechpath.com.bookstoresecuresystem.model.Book;
import fin.fintechpath.com.bookstoresecuresystem.model.Store;
import fin.fintechpath.com.bookstoresecuresystem.model.User;
import fin.fintechpath.com.bookstoresecuresystem.model.UserAuthorities;
import fin.fintechpath.com.bookstoresecuresystem.repository.AuthoritiesRepository;
import fin.fintechpath.com.bookstoresecuresystem.repository.BookRepository;
import fin.fintechpath.com.bookstoresecuresystem.repository.StoreRepository;
import fin.fintechpath.com.bookstoresecuresystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;
    private AuthoritiesRepository authoritiesRepository;
    private StoreRepository storeRepository;
    private BookRepository bookRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DBInit(UserRepository userRepository, AuthoritiesRepository authoritiesRepository, StoreRepository storeRepository, BookRepository bookRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.storeRepository = storeRepository;
        this.bookRepository = bookRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {

        createAuthorities("StoreAdmin");
        createAuthorities("NormalUser");

        createAdminUser("aya", passwordEncoder.encode("aya123"), "ayanidal56@gmail.com", 1);
        createAdminUser("bayan", passwordEncoder.encode("bayan123"), "bayan_alqasem_96@gmail.com", 1);

        createNormalUser("layan", passwordEncoder.encode("layan123"), "layansofian00@gmail.com", 1);
        createNormalUser("tete", passwordEncoder.encode("tete123"), "tete1999@gmail.com", 1);

        createUserWithoutRole("nidal", passwordEncoder.encode("nidal123"), "nidal35@gmail.com", 1);
        createUserWithoutRole("ahmad", passwordEncoder.encode("ahmed123"), "ahmad1999@gmail.com", 1);

        createBook("Arabic");
        createBook("English");
        createBook("Math");
        createBook("History");
        createBook("Computer");

        List<Integer> arrList = Arrays.asList(1,2,3);
        createStore("etihad-store",arrList);

        List<Integer> arrList2 = Arrays.asList(1,3,4);
        createStore("tqarub-store",arrList2);

        List<Integer> arrList3 = Arrays.asList(2,5);
        createStore("sadeq-store",arrList3);

    }

    private void createStore(String storeName, List<Integer> storeBooks) {
        Store store = new Store();
        store.setStoreName(storeName);
        storeBooks.forEach(book -> {
            store.getBooks().add(bookRepository.findById(Long.valueOf(book)).get());
        });
        storeRepository.save(store);
    }

    private void createBook(String name) {
        Book book = new Book();
        book.setBookName(name);
        bookRepository.save(book);
    }

    public void createAuthorities(String authoritiesName) {
        UserAuthorities authorities = new UserAuthorities();
        authorities.setAuthoritiesName(authoritiesName);
        authoritiesRepository.save(authorities);
    }

    private void createAdminUser(String username, String password, String email, int active) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(active);
        user.getAuthorities().add(authoritiesRepository.findById(1L).get());
        user.getAuthorities().add(authoritiesRepository.findById(2L).get());

        userRepository.save(user);
    }

    private void createNormalUser(String username, String password, String email, int active) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(active);
        user.getAuthorities().add(authoritiesRepository.findById(2L).get());

        userRepository.save(user);
    }

    public void createUserWithoutRole(String username, String password, String email, int active) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(active);
        userRepository.save(user);
    }

}
