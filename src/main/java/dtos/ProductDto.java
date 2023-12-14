package dtos;

import models.Category;

public class ProductDto {
    private String productTitle;
    private double price;
    private String article;
    private int count;
    private CategoryDto category;
    private String image_url;
    private String description;

    public ProductDto(String productTitle, double price, String article, int count, CategoryDto category, String image_url, String description) {
        this.productTitle = productTitle;
        this.price = price;
        this.article = article;
        this.count = count;
        this.category = category;
        this.image_url = image_url;
        this.description = description;
    }

    public ProductDto() {
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
