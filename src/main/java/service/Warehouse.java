package service;

import entities.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {
  boolean isRunning= true;
  Scanner scanner = new Scanner(System.in);
  addNewProductUI addNewProductUI = new addNewProductUI();
  private  ArrayList<Product> warehouseProducts = new ArrayList<Product>();
  public Warehouse() {
    ui();
  }

  private void ui() {
    while(isRunning) {
      System.out.println("Välkommen till din Vauhusmeny");
      System.out.println("1: Lägg till produkt");
      System.out.println("2: Ändra en produkt");
      System.out.println("3: Hitta en produkt");
      System.out.println("E: Avsluta.");
      String input = scanner.nextLine();
      switch (input) {
        case "1":
          Product newProduct = addNewProductUI.UI();
          warehouseProducts.add(newProduct);
          break;
        case "2":
          break;
        case "3":
          break;
        case "E":
          isRunning= false;
          break;
      }
    }
  }
}
