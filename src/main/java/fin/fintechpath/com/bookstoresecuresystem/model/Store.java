package fin.fintechpath.com.bookstoresecuresystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_name")
    private String storeName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "store_book",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public String getStoreName() {
        return storeName;
    }

    @JsonIgnore
    public List<Book> getBooks() {
        return books;
    }
}
