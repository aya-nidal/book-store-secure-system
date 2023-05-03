package fin.fintechpath.com.bookstoresecuresystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "authorities")
public class UserAuthorities {

    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authorities_name")
    private String authoritiesName;

    @ManyToMany(mappedBy = "authorities")
    private List<User> users = new ArrayList<>();
}
