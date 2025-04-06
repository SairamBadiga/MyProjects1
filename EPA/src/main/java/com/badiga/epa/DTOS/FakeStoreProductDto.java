package com.badiga.epa.DTOS;

import com.badiga.epa.Models.Category;
import com.badiga.epa.Models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDto {
    String Title;
    Integer Id;
    Float Price;
    String Description;
    String Category;

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.Id);
        product.setName(this.Title);
        product.setPrice(this.Price);
        Category category = new Category();
        category.setId(899);
        category.setName(this.Category);
        product.setCategory(category);
        return product;
    }
}
