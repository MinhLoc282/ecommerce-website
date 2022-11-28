package com.ecommerce.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "category", catalog = "ecommercedb")
@NamedQueries({@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c ORDER BY c.name"),
        @NamedQuery(name = "Category.countAll", query = "SELECT COUNT(c) FROM Category c"),
        @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name")})
public class Category {
    private Integer categoryId;
    private String name;
    private Set<Product> products = new HashSet<>(0);

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "category_id", unique = true, nullable = false)
    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "name", nullable = false, length = 64)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
