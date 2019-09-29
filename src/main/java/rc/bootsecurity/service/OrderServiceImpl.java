package rc.bootsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.bootsecurity.exception.ProductNotFoundException;
import rc.bootsecurity.model.order.OrderMain;
import rc.bootsecurity.repo.OrderRepository;

import java.util.Optional;

@Service
public class OrderServiceImpl {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductServiceImpl productService;

    public Optional<OrderMain> get(Long id) {
        return orderRepository.findById(id);
    }

    public void delete(Long id) {
        if (!orderRepository.existsById(id)) throw new ProductNotFoundException();
        orderRepository.deleteById(id);
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }

    public void update(Long id, OrderMain orderMain) {
        if (!orderRepository.existsById(id)) throw new ProductNotFoundException();
        orderRepository.deleteById(id);
        orderRepository.save(orderMain);
    }

    public void create(OrderMain orderMain) {
//        if (orderMain.getProducts()!= null) {
//            for (Product product:
//                 orderMain.getProducts()) {
//                productService.create(product);
//            }
//        }
        orderRepository.save(orderMain);
    }
}
