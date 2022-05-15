package ua.lviv.iot;

/**
 * Coffee.
 */
public class Coffee extends NonAlcoholic implements Comparable<Coffee> {
  private Type type;  // фізичний стан кави
  private int weight; // об'єм кави

  /**
   * Constructor.
   * @param name
   * @param price
   * @param size
   * @param type
   * @param weight
   */
  public Coffee(final String name,
                final double price,
                final int size,
                final Type type,
                final int weight) {
    super(name, price, size);
    this.type = type;
    this.weight = weight;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public int compareTo(final Coffee o) {
    return this.getName().compareToIgnoreCase(o.getName());
  }

  @Override
  public String getHeaders() {
    return super.getHeaders() + ",type,weight";
  }

  @Override
  public String toCsv() {
    return super.toCsv() + "," + type + "," + weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Coffee)) {
      return false;
    }

    Coffee coffee = (Coffee) o;

    if (weight != coffee.weight) {
      return false;
    }
    return type == coffee.type;
  }

  @Override
  public int hashCode() {
    int result = type != null ? type.hashCode() : 0;
    result = 31 * result + weight;
    return result;
  }

}
