package ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DrinkWriterTest {

  private DrinkWriter writer;
  private final ArrayList<Drink> drinkList = new ArrayList<>();

  private final Coffee coffee = new Coffee("Americano", 45, 200, Type.GROUND, 121);
  private final WarmDrink warmDrink = new WarmDrink("Homemade tea", 71, 220);
  private final NonAlcoholicDrink nonAlcoholicDrink = new NonAlcoholicDrink("Galicia, natural juices", 50, 300);
  private final Beer beer = new Beer("Coca-cola", 75, 330);
  private final Wine wine = new Wine("TM SHABO Classic", 400, 500);


  @BeforeEach
  void setUp() {
    writer = new DrinkWriter();

    drinkList.add(coffee);
    drinkList.add(warmDrink);
    drinkList.add(nonAlcoholicDrink);
    drinkList.add(beer);
    drinkList.add(wine);
  }

  @Test
  void writeToFile() throws IOException {
   writer.writeToFile(drinkList);
  }

}