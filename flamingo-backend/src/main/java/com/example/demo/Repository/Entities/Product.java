package com.example.demo.Repository.Entities;
// Generated Mar 5, 2023, 5:09:22 PM by Hibernate Tools 6.2.0.CR1

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "flamingoo")
public class Product implements java.io.Serializable {

    private int id;
    private Category category;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private Set<UserReviewProduct> userReviewProducts = new HashSet<UserReviewProduct>(0);
    private Images images;
    private Set<OrderProducts> orderProductses = new HashSet<OrderProducts>(0);

    public Product() {
    }

    public Product(String name, String description, int price, int quantity, Category category) {

        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int id, Category category, String name, String description, int price, int quantity) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int id, Category category, String name, String description, int price, int quantity,
            Set<UserReviewProduct> userReviewProducts, Images images, Set<OrderProducts> orderProductses) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.userReviewProducts = userReviewProducts;
        this.images = images;
        this.orderProductses = orderProductses;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false, length = 45)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price", nullable = false)
    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<UserReviewProduct> getUserReviewProducts() {
        return this.userReviewProducts;
    }

    public void setUserReviewProducts(Set<UserReviewProduct> userReviewProducts) {
        this.userReviewProducts = userReviewProducts;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
    public Images getImages() {
        return this.images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<OrderProducts> getOrderProductses() {
        return this.orderProductses;
    }

    public void setOrderProductses(Set<OrderProducts> orderProductses) {
        this.orderProductses = orderProductses;
    }

}
