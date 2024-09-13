package entities;


import service.UID;

import java.time.LocalDate;

public class Product{
  private final String id;
  private String name;
  private final Category category;
  private int rating;
  private final LocalDate createdDate;
  private LocalDate lastModifiedDate;

  public Product(String name, Category category, int rating) {
    UID uid = new UID(1,4);
    this.id = uid.toString();
    this.name = name;
    this.category = category;
    this.rating = rating;
    this.createdDate = LocalDate.now();
    this.lastModifiedDate = LocalDate.now();
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
  public LocalDate getCreatedDate() {
    return createdDate;
  }
  public LocalDate getLastModifiedDate() {
    return lastModifiedDate;
  }
  public void setLastModifiedDate(LocalDate lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public void editProduct(String newName, int newRating){
    this.name = newName;
    this.rating = newRating;
    this.lastModifiedDate = LocalDate.now();
  }
}