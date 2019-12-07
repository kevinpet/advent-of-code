package kevinp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Advent6 {

    public static void main(String[] args) throws IOException {
      List<String> lines = Files.readAllLines(Path.of("advent6.txt"));
      Map<String, String> sateliteToOrbitedBody = new HashMap<>();
      lines.forEach(line -> {
        String[] pair = line.split("\\)");
        sateliteToOrbitedBody.put(pair[1], pair[0]);
      });
      int totalOrbits = sateliteToOrbitedBody.keySet().stream()
          .mapToInt(satelite -> {
            int chain = 0;
            while (!satelite.equals("COM")) {
              chain++;
              satelite = sateliteToOrbitedBody.get(satelite);
            }
            return chain;
          })
          .sum();
      System.out.println("Total orbits: " + totalOrbits);
      List<String> youToCom = getPathToCom("YOU", sateliteToOrbitedBody);
      Collections.reverse(youToCom);
      System.out.println(youToCom);
      List<String> santaToCom = getPathToCom("SAN", sateliteToOrbitedBody);
      System.out.println(santaToCom);
      Collections.reverse(santaToCom);
      int i = 0;
      while (santaToCom.get(i).equals(youToCom.get(i))) {
        i++;
      }
      int transfersToSanta = santaToCom.size() - i + youToCom.size() - i;
      System.out.println("Transfers to Santa " + transfersToSanta);
    }

    private static List<String> getPathToCom(String loc, Map<String, String> sateliteToOrbitedBody) {
      List<String> pathToCom = new ArrayList<>();
      do {
        loc = sateliteToOrbitedBody.get(loc);
        pathToCom.add(loc);
      } while (!loc.equals("COM"));
      return pathToCom;
    }
}
