package entities;


import service.UID;

import java.time.LocalDate;

public class Product{
  private final String id = new UID(1,4).getUid();
  private String name;
  private Category category;
  private int rating;
  private final LocalDate createdDate;
  private LocalDate lastModifiedDate;

  public Product(String name, Category category, int rating) {
    this.name = name;
    this.category = category;
    this.rating = rating;
    this.createdDate = LocalDate.now();
    this.lastModifiedDate = LocalDate.now();
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
    return name.toString();
  }
  public Category getCategory() {
    return category;
  }
  public int getRating() {
    return rating;
  }
  public LocalDate getCreatedDate() {
    return createdDate;
  }
  public LocalDate getLastModifiedDate() {
    return lastModifiedDate;
  }
  public void setLastModifiedDate(LocalDate lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public void editProduct(String newName){
    this.name = newName;
    this.lastModifiedDate = LocalDate.now();
  }

  public void editProduct(Category newCategory){
    this.category = newCategory;
    this.lastModifiedDate = LocalDate.now();
  }

  public void editProduct(int newRating){
    this.rating = newRating;
    this.lastModifiedDate = LocalDate.now();
  }

}