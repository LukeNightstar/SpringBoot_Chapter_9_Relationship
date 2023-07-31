package com.springboot.relationship.data.repository.support;

import com.springboot.relationship.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("productRepositorySupport")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // find...By
    Optional<Product> findByNumber(Long number);

    List<Product> findAllByName(String name);

    Product queryByNumber(Long number);

    // exists...By
    boolean existsByNumber(Long number);

    // count..By
    long countByName(String name);

    // delete...By, remove...Byvoid
    void deleteByNumber(Long number);

    long removeByName(String name);

    // ...First<number>...,Top<Number>...
    List<Product> findFirst5ByName(String name);

    List<Product> findTop10ByName(String name);

    List<Product> findByName(String name, Sort sort);

    // Pageable system
    Page<Product> findByName(String name, Pageable pageable);

    // Query Annotation
    // type1
    // With JPQL, the JPA implementation automatically interprets and executes query statements.
    @Query("SELECT p FROM Product AS p WHERE p.name = ?1")
    List<Product> findByName(String name);

    // type2
    // Implementing a method by binding parameters makes the code more readable and easier to maintain.
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> findByNameParam(@Param("name") String name);

    // type3
    // Using query, it is possible to extract only the values of the column you want, not the entity type.
    @Query("SELECT p.name, p.price, p.stock FROM Product p WHERE p.name = :name")
    List<Object[]> findByNameParam2(@Param("name") String name);


}
