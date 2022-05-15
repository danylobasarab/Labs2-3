package ua.lviv.iot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * DrinkWriter.
 */
public class DrinkWriter {

  /**
   * Write to file.
   * @param drinkList
   * @throws IOException
   */
  public void writeToFile(final List<Drink> drinkList) throws IOException {
    List<String> lines = new ArrayList<>();
    lines.add(drinkList.get(0).getHeaders());
    drinkList.stream().map(Drink::toCsv).forEach(lines::add);

    Path path = Path.of("./drinks.csv");
    Files.write(path, lines);
  }

}
