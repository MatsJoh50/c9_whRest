package superserverllm.c9_whrestjakarta.service;
import superserverllm.c9_whrestjakarta.entities.Category;
import superserverllm.c9_whrestjakarta.entities.Product;

import java.util.Map;

public class PopulateWH {
  private UID populateUid = new UID(1,4);

  private UID renderNewUID(){
    this.populateUid = new UID(1,4);
    return this.populateUid;
  }

  public void populate(Map warehouseProducts) {

    // PANTS (minst 5 produkter)
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Blue Jeans", Category.PANTS, 8,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Cargo Pants", Category.PANTS, 7,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Khaki Shorts", Category.PANTS, 7,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Black Trousers", Category.PANTS, 6,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Skinny Jeans", Category.PANTS, 9,this.populateUid)));

    // SHIRTS (minst 5 produkter)
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Red T-shirt", Category.SHIRTS, 7,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("White Shirt", Category.SHIRTS, 8,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Blue Polo", Category.SHIRTS, 9,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Black Turtleneck", Category.SHIRTS, 6,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Green Hoodie", Category.SHIRTS, 8,this.populateUid)));

    // SHOES (minst 5 produkter)
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Running Shoes", Category.SHOES, 9,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Sneakers", Category.SHOES, 6,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Formal Shoes", Category.SHOES, 8,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Boots", Category.SHOES, 7,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Sandals", Category.SHOES, 5,this.populateUid)));

    // JACKETS (minst 5 produkter)
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Winter Jacket", Category.JACKETS, 10,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Leather Jacket", Category.JACKETS, 9,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Rain Jacket", Category.JACKETS, 7,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Bomber Jacket", Category.JACKETS, 8,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Windbreaker", Category.JACKETS, 6,this.populateUid)));

    // BACKPACKS (minst 5 produkter)
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Hiking Backpack", Category.BACKPACKS, 6,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Travel Backpack", Category.BACKPACKS, 8,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("School Backpack", Category.BACKPACKS, 7,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Daypack", Category.BACKPACKS, 7,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Laptop Backpack", Category.BACKPACKS, 8,this.populateUid)));

    // COOKING (minst 5 produkter)
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Camping Stove", Category.COOKING, 8,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Portable Grill", Category.COOKING, 6,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Cooking Pot", Category.COOKING, 7,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Frying Pan", Category.COOKING, 8,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("BBQ Tongs", Category.COOKING, 5,this.populateUid)));

    // CARVING (minst 5 produkter)
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Swiss Knife", Category.CARVING, 9,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Hunting Knife", Category.CARVING, 9,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Wood Carving Set", Category.CARVING, 8,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Carving Fork", Category.CARVING, 6,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Carving Knife", Category.CARVING, 7,this.populateUid)));

    // MEDICAL (minst 5 produkter)
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("First Aid Kit", Category.MEDICAL, 7,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Bandages", Category.MEDICAL, 5,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Antiseptic Wipes", Category.MEDICAL, 6,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Pain Relief Spray", Category.MEDICAL, 8,this.populateUid)));
    warehouseProducts.putIfAbsent(renderNewUID(), (new Product("Medical Tape", Category.MEDICAL, 7,this.populateUid)));

  }
}
