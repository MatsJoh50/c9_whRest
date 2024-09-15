package service;

import com.sun.tools.javac.Main;
import entities.Category;
import entities.Product;

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

  public void modifyProduct(String name, String newInput) {
    Product product = findProductByName(name);
    if (product != null) {
      product.editProduct(newInput);
    }
  }


  public void modifyProduct( String name, Category newInput) {
    System.out.println("Vad vill du att nya kategorin ska vara?");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    Category newinput = Category.valueOf(input);
    Product product = findProductByName(name);
    if (product != null) {
      product.editProduct(newInput);
    }
  }

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
      System.out.println("Id: " + product.getId() + " Name: " + product.getName() + " Category: " + product.getCategory());
    }
  }

  public void printCategory(Category inputCategory) {
    List<Product> sortedList = getProductsByCategoryAndSortByName(inputCategory);
    for (Product product : sortedList) {
      System.out.println(product.toString());
    }
  }

  public List<Product> getProductsByCategoryAndSortByName(Category category) {
    return warehouseProducts.stream()
        .filter(product -> product.getCategory().equals(category))
        .sorted(Comparator.comparing(Product::getName))
        .collect(Collectors.toList());
  }
}//endpoint
