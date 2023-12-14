package com.example.demo.dtos;

public class CategoryDto {
    private String categoryTitle;

    public CategoryDto() {
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryTitle='" + categoryTitle + '\'' +
                '}';
    }
}
