package ua.lviv.iot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AppTest {

  private final ArrayList<Drink> drinkList = new ArrayList<>();

  private final Coffee coffee = new Coffee("Americano", 45, 200, Type.GROUND, 121);
  private final WarmDrink warmDrink = new WarmDrink("Homemade tea", 71, 220);
  private final NonAlcoholicDrink nonAlcoholicDrink = new NonAlcoholicDrink("Galicia, natural juices", 50, 300);
  private final Beer beer = new Beer("Coca-cola", 75, 330);
  private final Wine wine = new Wine("TM SHABO Classic", 400, 500);


  @BeforeEach
  void setUp() {
    drinkList.add(coffee);
    drinkList.add(warmDrink);
    drinkList.add(nonAlcoholicDrink);
    drinkList.add(beer);
    drinkList.add(wine);
  }

  @Test
  void findCoffee() {
    ArrayList<Drink> result = App.findCoffee(drinkList, Type.GROUND);

    Assertions.assertIterableEquals(List.of(coffee), result);
  }

  @Test
  void printCoffeeTypes() {
    Assertions.assertDoesNotThrow(App::printCoffeeTypes);
  }

  @Test
  void parseType() {
    Assertions.assertEquals(Type.BEAN, App.parseType(1));
    Assertions.assertEquals(Type.GROUND, App.parseType(2));
    Assertions.assertEquals(Type.INSTANT, App.parseType(3));
    Assertions.assertEquals(Type.PACK, App.parseType(4));
    Assertions.assertEquals(Type.BEAN, App.parseType(0));
  }

  @Test
  void printDrinks() {
    Assertions.assertDoesNotThrow(() -> App.printDrinks(drinkList));
  }

  @Test
  void quickSort_asc() {

    ArrayList<Drink> result = App.quickSort(drinkList, true);

    List<Object> expected = List.of(
      coffee,
      beer,
      nonAlcoholicDrink,
      warmDrink,
      wine
    );
    Assertions.assertIterableEquals(expected, result);
  }

  @Test
  void quickSort_dsc() {

    ArrayList<Drink> result = App.quickSort(drinkList, false);

    List<Object> expected = List.of(
      wine,
      warmDrink,
      nonAlcoholicDrink,
      beer,
      coffee
    );
    Assertions.assertIterableEquals(expected, result);
  }

  @Test
  void fulfillWithSomeDrinks() {
    List<Drink> drinks = new ArrayList<>();

    App.fulfillWithSomeDrinks(drinks);

    Assertions.assertEquals(31, drinks.size());
  }

}