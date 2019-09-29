package rc.bootsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rc.bootsecurity.model.Product;
import rc.bootsecurity.model.User;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    void deleteById(Long aLong);
}
