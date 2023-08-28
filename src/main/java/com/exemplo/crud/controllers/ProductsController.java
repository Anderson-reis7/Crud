package com.exemplo.crud.controllers;


import com.exemplo.crud.domain.product.Product;
import com.exemplo.crud.domain.product.ProductRepository;
import com.exemplo.crud.domain.dto.ResquestProductDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok(productRepository.findAll());
    }
    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid ResquestProductDTO data){
        Product newProduct = new Product(data);
        return new ResponseEntity<>(productRepository.save(newProduct), HttpStatus.OK);
    }
}
