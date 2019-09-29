package rc.bootsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.bootsecurity.exception.ProductNotFoundException;
import rc.bootsecurity.model.Product;
import rc.bootsecurity.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return (List<Product>)productRepository.findAll();
    }

    public Optional<Product> get(Long id) {
        return productRepository.findById(id);
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) throw new ProductNotFoundException();
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public void update(Long id, Product product) {
        if (!productRepository.existsById(id)) throw new ProductNotFoundException();
        productRepository.deleteById(id);
        productRepository.save(product);
    }

    public void create(Product product) {
        productRepository.save(product);
    }
}
