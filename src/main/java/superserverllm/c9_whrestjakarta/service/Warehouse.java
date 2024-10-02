package superserverllm.c9_whrestjakarta.service;

import superserverllm.c9_whrestjakarta.entities.Category;
import superserverllm.c9_whrestjakarta.entities.Product;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.*;

public class Warehouse {
  protected Map<UID, Product> warehouseProducts = new ConcurrentHashMap<>();
  private UID populateUid = new UID(1, 4);

  private UID renderNewUID(){
    this.populateUid = new UID(1,4);
    return this.populateUid;
  }

  public void populateWarehouseProducts() {
    PopulateWH populateWH = new PopulateWH();
    populateWH.populate(warehouseProducts);
  }

  public void addProduct(Product product) {
      try {
        warehouseProducts.putIfAbsent(product.getUID(), product);
        System.out.println("Produkten tillagd");
        callbackOnAddedProduct(product);
      }catch (Exception e) {
      System.out.println("Varan finns redan");
      }
    }
    
public String callbackOnAddedProduct(Product product) {
  return product.toString();
}

  public List<String> getAllNames(){
    List<String> names = new CopyOnWriteArrayList<>();
    for(Product product : warehouseProducts.values()){
      names.add(product.getName());
    }
    return Collections.unmodifiableList(names);
  }

  //NEW NAME
  public void modifyProduct(String id, String newName) {
    Product product = search(id);
    if (product != null) {
      product.editProduct(newName);
    }
  }

//NEW CATEGORY
  public void modifyProduct( String id, Category newCategory) {
    Product product = search(id);
    if (product != null) {
      product.editProduct(newCategory);
    }
  }

  //NEW RATING
  public void modifyProduct(String id, int newRating) {
    Product product = search(id);
    if (product != null) {
      product.editProduct(newRating);
    }
  }

  public Product search(String uid) {
    try {
      for (Product product : warehouseProducts.values()) {
        if (product.getId().equals(uid)) {
          return product;
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return null;
  };

  public void printAll() {
    for (Product product : warehouseProducts.values()) {
      System.out.println(product.toString());
    }
  }

  public void printCategory(Category inputCategory) {
    List<Product> sortedList = getProductsByCategoryAndSortByName(inputCategory);
    printGivenList(sortedList);
  }

  public List<Product> getProductsByCategoryAndSortByName(Category category) {
    return warehouseProducts.values().stream()
        .filter(product -> product.getCategory().equals(category))
        .sorted(Comparator.comparing(Product::getName))
        .collect(Collectors.toList());
  }

  public List<Product> fetchListByDate(LocalDateTime date) {
    return warehouseProducts.values().stream()
        .filter(product -> product.getCreatedDate().isAfter(date))
        .sorted(Comparator.comparing(Product::getCreatedDate))
        .collect(Collectors.toList());
  }
  public void printProductsByDate(LocalDateTime date){
    List<Product> productsByDate = fetchListByDate(date);
    printGivenList(productsByDate);
  }

  private static void printGivenList(List<Product> listOfProducts) {
    for (Product product : listOfProducts) {
      System.out.println(product.toString());
    }
  }



  public void isModified() {
    List<Product> productsIsModified = getModifiedList();
    printGivenList(productsIsModified);
  }

  public List<Product> getModifiedList() {
    return warehouseProducts.values().stream()
        .filter(product -> !product.getCreatedDate().equals(product.getLastModifiedDate()))
        .sorted(Comparator.comparing(Product::getLastModifiedDate))
        .collect(Collectors.toList());
  }
}
