package service;

import entities.Category;
import entities.Product;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {
  private List<Product> warehouseProducts = new ArrayList<>();

  public void populateWarehouseProducts() {
    PopulateWH populateWH = new PopulateWH();
    populateWH.populate(warehouseProducts);
  }
  public void addProduct(Product product) {
    if(warehouseProducts.contains(product)) {
      System.out.println("Varan finns redan");
    } else{
      warehouseProducts.add(product);
      System.out.println("Produkten tillagd");
      System.out.println(product.toString());

    }
  }

  public List<String> getAllNames(){
    List<String> names = new ArrayList<>();
    for(Product product : warehouseProducts){
      names.add(product.getName());
    }
    return Collections.unmodifiableList(names);
  }

  //NEW NAME
  public void modifyProduct(String name, String newInput) {
    Product product = findProductByName(name);
    if (product != null) {
      product.editProduct(newInput);
    }
  }

//NEW CATEGORY
  public void modifyProduct( String name, Category newInput) {
//    System.out.println("Vad vill du att nya kategorin ska vara?");
//    Scanner scanner = new Scanner(System.in);
//    String input = scanner.nextLine().trim().toUpperCase();
    Product product = findProductByName(name);
    if (product != null) {
      product.editProduct(newInput);
    }
  }

  //NEW RATING
  public void modifyProduct(String name, int newInput) {
    Product product = findProductByName(name);
    if (product != null) {
      product.editProduct(newInput);
    }
  }

  private Product findProductByName(String name) {
    for (Product p : warehouseProducts) {
      if (p.getName().equals(name)) {
        return p;
      }
    }
    return null;
  }


  public void search(String uid) {
    for (Product product : warehouseProducts) {
      if (product.getId().equals(uid)) {
        System.out.println(product.toString());
      }
    }
  }

  public void printAll() {
    for (Product product : warehouseProducts) {
//      System.out.println("Id: " + product.getId() + " Name: " + product.getName() + " Category: " + product.getCategory());
      System.out.println(product.toString());
    }
  }

  public void printCategory(Category inputCategory) {
    List<Product> sortedList = getProductsByCategoryAndSortByName(inputCategory);
    printGivenList(sortedList);
  }

  public List<Product> getProductsByCategoryAndSortByName(Category category) {
    return warehouseProducts.stream()
        .filter(product -> product.getCategory().equals(category))
        .sorted(Comparator.comparing(Product::getName))
        .collect(Collectors.toList());
  }

  public List<Product> fetchListByDate(LocalDateTime date) {
    return warehouseProducts.stream()
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

  private List<Product> getModifiedList() {
    return warehouseProducts.stream()
        .sorted(Comparator.comparing(Product::getLastModifiedDate, Comparator.nullsLast(Comparator.naturalOrder())))
        .sorted(Comparator.comparing(Product::getLastModifiedDate))
        .collect(Collectors.toList());
  }
}//endpoint
