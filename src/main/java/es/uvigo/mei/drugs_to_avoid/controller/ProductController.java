package es.uvigo.mei.drugs_to_avoid.controller;

import es.uvigo.mei.drugs_to_avoid.repository.daos.ProductDao;
import es.uvigo.mei.drugs_to_avoid.repository.entidades.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "products", produces = "application/json")
public class ProductController {

    @Autowired
    ProductDao productDao;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productDao.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> product = productDao.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<Product>> findByName(@RequestParam(name = "name", required = true) String name) {
        return ResponseEntity.ok(productDao.findByName(name));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product savedProduct = productDao.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product productDetails) {
        Optional<Product> existingProduct = productDao.findById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = productDao.save(productDetails);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Product> product = productDao.findById(id);
        if (product.isPresent()) {
            productDao.delete(product.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}