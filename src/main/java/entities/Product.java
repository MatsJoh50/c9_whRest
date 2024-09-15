package entities;


import service.UID;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product{
  private final String id = new UID(1,4).getUid();
  private String name;
  private Category category;
  private int rating;
  private final LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

  public Product(String name, Category category, int rating) {
    LocalDateTime now = LocalDateTime.now();
    this.name = name;
    this.category = category;
    this.rating = rating;
    this.createdDate = now;
    this.lastModifiedDate = now;
  }
  @Override
  public String toString() {
    return
        "Id: " + id + ",\t" +
        "Name: " + name + ",\t" +
        "Category: " + category + ",\t" +
        "Rating: " + rating;
  }

  
  public String getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public Category getCategory() {
    return category;
  }
  public int getRating() {
    return rating;
  }
  public LocalDateTime getCreatedDate() {
    return createdDate;
  }
  public LocalDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }
  public void setLastModifiedDate() {
    this.lastModifiedDate = LocalDateTime.now();
  }

  public void editProduct(String newName){
    this.name = newName;
    setLastModifiedDate();
  }

  public void editProduct(Category newCategory){
    this.category = newCategory;
    setLastModifiedDate();
  }

  public void editProduct(int newRating){
    this.rating = newRating;
    setLastModifiedDate();
  }

}