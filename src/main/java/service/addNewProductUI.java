package service;


import entities.Category;
import entities.Product;

import java.util.Scanner;

public class addNewProductUI {
  Scanner scanner = new Scanner(System.in);
  public Product UI(){
    System.out.print("Produktens namn: ");
    String name = scanner.nextLine();
    System.out.print("Produktens kategori: ");
    printCategorys();
    String inputCategory = scanner.nextLine();
    Category category = Category.valueOf(inputCategory);
    System.out.print("Produktens rating: ");
    int rating = scanner.nextInt();
    UID uid = new UID(1,4);

    return new Product(name, category, rating);
  }


  private void printCategorys(){
    System.out.println("Categories");
    for (int i = 0; i < Category.values().length; i++) {
      System.out.print(Category.values() + "\t");
      if(i % 4 == 0){
        System.out.println();
      }
    }
  }
}
