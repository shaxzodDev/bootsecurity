package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rc.bootsecurity.model.order.OrderMain;
import rc.bootsecurity.service.OrderServiceImpl;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.get(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody OrderMain orderMain) {
        orderService.create(orderMain);
        return new ResponseEntity<>("OrderMain created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody OrderMain orderMain) {
        orderService.update(id, orderMain);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        orderService.delete(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

}
