package com.example.demo.Repository.Entities;
// Generated Mar 5, 2023, 5:09:22 PM by Hibernate Tools 6.2.0.CR1

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "flamingoo")
public class Category implements java.io.Serializable {

    private int id;
    private String categoryName;
    private String image;
    private Set<Product> products = new HashSet<Product>(0);

    public Category() {
    }

    public Category(String categoryName, String image) {
        this.categoryName = categoryName;
        this.image = image;
    }

    public Category(int id, String categoryName, String image) {
        this.id = id;
        this.categoryName = categoryName;
        this.image = image;
    }

    public Category(int id, String categoryName, String image, Set<Product> products) {
        this.id = id;
        this.categoryName = categoryName;
        this.image = image;
        this.products = products;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "category_name", nullable = false, length = 45)
    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Column(name = "image", nullable = false, length = 45)
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
