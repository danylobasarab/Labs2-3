package ua.lviv.iot;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
  // пошук напоїв, які приготовані з використанням кави, залежно від заданого фізичного стану
  // та сортування по використаному об’єму кави
  public static ArrayList<Drink> findCoffee(List<Drink> arrlist, Type type) {
    ArrayList<Drink> coffeeList = new ArrayList<>();
    for (Drink drink : arrlist) {
      if (drink instanceof Coffee) {
        Coffee coffee = (Coffee) drink;
        if (coffee.getType() == type) {
          coffeeList.add(drink);
        }
      }
    }
    Comparator<Drink> compareByWeight = Comparator.comparingInt((Drink o) -> ((Coffee) o).getWeight());

    coffeeList.sort(compareByWeight);

    return coffeeList;
  }

  public static void printCoffeeTypes() {
    // виведення списку типів кави залежно від заданого фізичного стану
    System.out.println("\nChoose your coffee type:");
    System.out.println("1. BEAN");        // Зернова
    System.out.println("2. GROUND");    // Мелена
    System.out.println("3. INSTANT");    // Розчинна в банках
    System.out.println("4. PACK");        // В пакетиках
  }

  public static Type parseType(int inType) {
    switch (inType) {
      case 2:
        return Type.GROUND;
      case 3:
        return Type.INSTANT;
      case 4:
        return Type.PACK;
      case 1:
      default:
        return Type.BEAN;
    }
  }

  // виведення результатів
  public static void printDrinks(List<Drink> arrlist) {
    System.out.format("%26s %6s %4s %7s %4s %n", "Name", "Price", "Size", "Type", "Weight");
    for (Drink drink : arrlist) {
      System.out.format("%26s %6.2f %4d ", drink.getName(),
        drink.getPrice(), drink.getSize());
      if (drink instanceof Coffee) {
        Coffee coffee = (Coffee) drink;
        System.out.format("%7s %4d", coffee.getType(), coffee.getWeight());
      }
      System.out.println();
    }
  }

  public static void fulfillWithSomeDrinks(List<Drink> drinkList) {
    //  						  назва	   ціна розмір	  тип	   об'єм
    //											порції				кави
    drinkList.add(new Coffee("Americano", 45, 200, Type.GROUND, 121));

    drinkList.add(new Coffee("Filtered Coffee", 50, 900, Type.GROUND, 152));
    drinkList.add(new Coffee("Cold brew", 79, 150, Type.GROUND, 112));
    drinkList.add(new Coffee("Coffee with ice cream", 75, 200, Type.GROUND, 12));
    drinkList.add(new Coffee("Cappuccino", 55, 800, Type.PACK, 123));
    drinkList.add(new Coffee("Latte", 66, 200, Type.GROUND, 18));
    drinkList.add(new Coffee("Flat white", 60, 200, Type.INSTANT, 14));
    drinkList.add(new Coffee("Raff coffee", 90, 200, Type.INSTANT, 16));
    drinkList.add(new Coffee("Nut latte with cream", 90, 700, Type.PACK, 12));
    drinkList.add(new Coffee("Lviv rainy day coffee", 111, 600, Type.BEAN, 132));
    drinkList.add(new Coffee("Relaxing coffee", 71, 200, Type.BEAN, 112));
    drinkList.add(new Coffee("Evening coffee", 72, 500, Type.BEAN, 142));
    drinkList.add(new Coffee("Best served in bed", 100, 215, Type.BEAN, 162));
    drinkList.add(new Coffee("For lovers", 110, 400, Type.BEAN, 182));
    drinkList.add(new Coffee("Banderivska", 65, 200, Type.BEAN, 172));
    drinkList.add(new Coffee("Mocaccino", 85, 300, Type.BEAN, 192));
    drinkList.add(new Coffee("Fancy latte with roses", 75, 100, Type.BEAN, 12));

    drinkList.add(new WarmDrink("Homemade tea", 71, 220));
    drinkList.add(new WarmDrink("Tea", 78, 200));
    drinkList.add(new WarmDrink("Masala Chai", 77, 330));
    drinkList.add(new WarmDrink("Cocoa with marshmallow", 75, 200));

    drinkList.add(new NonAlcoholicDrink("Galicia, natural juices", 50, 300));
    drinkList.add(new NonAlcoholicDrink("Jaffa juices and nectars", 47, 250));
    drinkList.add(new NonAlcoholicDrink("Coca-cola", 50, 250));

    drinkList.add(new Beer("Coca-cola", 75, 330));
    drinkList.add(new Beer("Bottled beer", 74, 330));

    drinkList.add(new Wine("TM SHABO Classic", 400, 500));
    drinkList.add(new Wine("Riesling Trocken.Dr.Loosen", 600, 500));
    drinkList.add(new Wine("Rose d'Anjou", 600, 500));
    drinkList.add(new Wine("Chianti. Poliziano", 800, 500));
    drinkList.add(new Wine("Shiraz-Malbec.Esperado", 750, 500));

  }

  // алгоритм сортування
  public static ArrayList<Drink> quickSort(ArrayList<Drink> list, boolean asc) {
    if (list.isEmpty()) {
      return list;
    }
    ArrayList<Drink> smaller = new ArrayList<>();
    ArrayList<Drink> greater = new ArrayList<>();
    Drink pivot = list.get(0);
    int i;
    Drink j;
    for (i = 1; i < list.size(); i++) {
      j = list.get(i);
      if (asc) {
        if (j.getName().compareToIgnoreCase(pivot.getName()) < 0) {
          smaller.add(j);
        } else {
          greater.add(j);
        }
      } else {
        if (j.getName().compareToIgnoreCase(pivot.getName()) < 0) {
          greater.add(j);
        } else {
          smaller.add(j);
        }
      }
    }
    smaller = quickSort(smaller, asc);
    greater = quickSort(greater, asc);
    smaller.add(pivot);
    smaller.addAll(greater);

    return smaller;
  }

  public static void main(String[] args) {
    // ініціалізація початкових даних
    List<Drink> listAnything = new ArrayList<>();
    fulfillWithSomeDrinks(listAnything);

    // виведення всього асортименту напоїв
    System.out.println("All drinks list");
    printDrinks(listAnything);

    printCoffeeTypes();

    // вводимо обраний тип кави
    int inType;
    try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {
      inType = in.nextInt();
    }
    Type coffeeType = parseType(inType);

    // пошук та сортування кави залежно від фізичного стану, за об’ємом
    System.out.println("\nSorted coffee responds to the request(Weight)");
    ArrayList<Drink> finded = findCoffee(listAnything, coffeeType);
    printDrinks(finded);

    ArrayList<Drink> listSorted;

    // сортування за назвою (за зростанням)
    System.out.println("\nCoffee sorted by name ascending");
    listSorted = quickSort(finded, true);
    printDrinks(listSorted);

    // сортування за назвою (за спаданням)
    System.out.println("\nCoffee sorted by name descending");
    listSorted = quickSort(finded, false);
    printDrinks(listSorted);

  }
}
