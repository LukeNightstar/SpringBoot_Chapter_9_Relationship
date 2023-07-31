package com.springboot.relationship.data.repository;

import com.springboot.relationship.data.entity.Product;
import com.springboot.relationship.data.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProviderRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Test
    void relationshipTest1(){
        // Create test data.
        Provider provider = new Provider();
        provider.setName("Test-Tech");

        providerRepository.save(provider);

        Product product = new Product();
        product.setName("TEST PRODUCT");
        product.setPrice(5000);
        product.setStock(500);
        product.setProvider(provider);

        productRepository.save(product);

        // Test
        System.out.println(
                "product : " + productRepository.findById(1L)
                        .orElseThrow(RuntimeException::new));
        System.out.println("provider : " + productRepository.findById(1L)
                .orElseThrow(RuntimeException::new).getProvider());

    }
}
