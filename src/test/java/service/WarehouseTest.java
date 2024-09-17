package service;

import entities.Category;
import entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import org.mockito.Mockito;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WarehouseTest {
  private Warehouse warehouse;
  private Warehouse emptyWarehouse;
  private Product mockData1 = new Product("Blue Jeans", Category.PANTS, 8, LocalDateTime.now().minusHours(5), LocalDateTime.now());
  private Product mockData2 = new Product("Red T-shirt", Category.SHIRTS, 7, LocalDateTime.now().minusHours(4), LocalDateTime.now());
  private Product mockData3 = new Product("White Shirt", Category.SHIRTS, 8, LocalDateTime.now().minusHours(3), LocalDateTime.now());
  private Product mockData4 =  new Product("Blue Polo", Category.SHIRTS, 9, LocalDateTime.now().minusHours(2), LocalDateTime.now());

  @BeforeEach
  public void setUp() {


    emptyWarehouse = Mockito.spy(new Warehouse());
    warehouse = Mockito.spy(new Warehouse());

    warehouse.addProduct(mockData1);
    warehouse.addProduct(mockData2);
    warehouse.addProduct(mockData3);
    warehouse.addProduct(mockData4);

  }
  @Test
  @DisplayName("")
  public void testWarehouseHasProducts(){
    assertThat(warehouse.getAllNames().size()).isGreaterThan(0);
  };

  @Test
  public void testWarehouseIsEmpty(){
    assertThat(emptyWarehouse.getAllNames().size()).isEqualTo(0);
  };
  @Test
  public void testResponseAfterAddingProducts(){
    assertThat(warehouse.callbackOnAddedProduct(mockData1)).isEqualTo(mockData1.toString());
  }

  public String getFistUid() {
    List<Product> products = warehouse.fetchListByDate(LocalDateTime.now().minusDays(1));
    return products.getFirst().getId();
  };

  @org.junit.jupiter.api.Nested
  class NestedModifieTests {
    @Nested
    @Test
    public void testToModifyAProductName(){
      warehouse.modifyProduct(getFistUid(), "Test1");
      assertThat(warehouse.search(getFistUid()).getName().equals("Test1")).isTrue();
    }
    @Test
    public void testToModifyAProductCategory(){
      warehouse.modifyProduct(getFistUid(), Category.COOKING);
      assertThat(warehouse.search(getFistUid()).getCategory()).isEqualTo(Category.COOKING);
    }
    @Test
    public void testToModifyAProductRating(){
      warehouse.modifyProduct(getFistUid(), 1);
      assertThat(warehouse.search(getFistUid()).getRating()).isEqualTo(1);
    }


    @Test
    public void testModifiedProducts(){
      emptyWarehouse.addProduct(new Product("Blue Jeans", Category.PANTS, 8, LocalDateTime.now(), LocalDateTime.now().plusDays(1)));
      assertThat(emptyWarehouse.getModifiedList().size()).isEqualTo(1);
    }
  }

  @Test
  public void testFindAProductByUID(){
    assertThat(warehouse.search(getFistUid())).isEqualTo(mockData1);
  }
  @Test
  public void testSearchForNotExistingProduct(){
    String fakeUid = "nothingIsReal";
    assertThat(warehouse.search(fakeUid)).isEqualTo(null);
  }

  @Test
  public void testSortedListByDate(){
    List<Product> products = warehouse.fetchListByDate(LocalDateTime.now().minusDays(1));
    assertThat(products.get(0)).isEqualTo(mockData1);
    assertThat(products.get(1)).isEqualTo(mockData2);
    assertThat(products.get(2)).isEqualTo(mockData3);
    assertThat(products.get(3)).isEqualTo(mockData4);
  }

  @Test
  public void testListOfCategories(){
    List<Product> products = warehouse.getProductsByCategoryAndSortByName(Category.SHIRTS);
    assertThat(products.get(0)).isEqualTo(mockData4);
    assertThat(products.get(1)).isEqualTo(mockData2);
    assertThat(products.get(2)).isEqualTo(mockData3);
  }

  @Test
  public void testUIDUniqnessOfHundredUids(){
    List<UID> uids = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      uids.add(new UID(1,4));
    }

    Set<UID> uniqueUids = new HashSet<>(uids);
    assertThat(uniqueUids.size()).isEqualTo(uids.size());
  }


}
