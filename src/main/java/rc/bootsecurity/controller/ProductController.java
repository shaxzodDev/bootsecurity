package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rc.bootsecurity.model.Product;
import rc.bootsecurity.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        productServiceImpl.delete(id);
        return new ResponseEntity<>("Products deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        productServiceImpl.update(id, product);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productServiceImpl.create(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productServiceImpl.getAll(), HttpStatus.OK);
    }


}
