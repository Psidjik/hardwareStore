package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
@Entity
@Table(name = "category")
public class Category extends BaseEntity{
    private String categoryTitle;
    private List<Product> products;

    public Category(String categoryTitle, List<Product> products) {
        this.categoryTitle = categoryTitle;
        this.products = products;
    }

    public Category() {
    }
    @Column(name = "category_title")
    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    @OneToMany(mappedBy = "productTitle")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
