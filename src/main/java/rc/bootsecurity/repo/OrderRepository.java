package rc.bootsecurity.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rc.bootsecurity.model.order.OrderMain;

@Repository
public interface OrderRepository extends CrudRepository<OrderMain, Long> {


}
