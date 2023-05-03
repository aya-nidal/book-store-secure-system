package fin.fintechpath.com.bookstoresecuresystem.repository;

import fin.fintechpath.com.bookstoresecuresystem.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
