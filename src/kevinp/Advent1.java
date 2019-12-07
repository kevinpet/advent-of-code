package kevinp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Advent1 {

    public static void main(String[] args) throws IOException {
      List<String> lines = Files.readAllLines(Path.of("advent1.txt"));
      System.out.println(lines.stream().mapToInt(Integer::parseInt).map(mass -> {
        int totalFuel = 0;
        while (mass > 8) {
          mass = mass / 3 - 2;
          totalFuel += mass;
        }
        return totalFuel;
      }).sum());
    }
}
