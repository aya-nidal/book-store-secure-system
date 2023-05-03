package fin.fintechpath.com.bookstoresecuresystem.repository;

import fin.fintechpath.com.bookstoresecuresystem.model.UserAuthorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<UserAuthorities, Long> {
}
