package ua.lviv.iot;

/**
 * Drink.
 */
public abstract class Drink {
  private String name; // назва
  private double price; // ціна
  private int size; // розмір

  /**
   * Constructor.
   * @param name
   * @param price
   * @param size
   */
  public Drink(final String name,
               final double price,
               final int size) {
    this.name = name;
    this.price = price;
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getHeaders() {
    return "name,price,size";
  }

  public String toCsv() {
    return name + "," + price + "," + size;
  }

}
