package com.exemplo.crud.controllers;


import com.exemplo.crud.domain.product.Product;
import com.exemplo.crud.domain.product.ProductRepository;
import com.exemplo.crud.domain.dto.ResquestProductDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok(productRepository.findAllByActiveTrue());
    }
    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid ResquestProductDTO data){
        Product newProduct = new Product(data);
        return new ResponseEntity<>(productRepository.save(newProduct), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Valid ResquestProductDTO data){
        Product product = new Product(data);
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setActive(false);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
