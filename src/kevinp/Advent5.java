package kevinp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Advent5 {

  public static void main(String[] args) throws IOException {
    int input = 5;
    String example = null;
    List<String> lines = Files.readAllLines(Path.of("advent5.txt"));
    int[] original =
        Arrays.stream(example != null ? example.split(",") : lines.iterator().next().split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
    System.out.println("out> " + run(input, original));
  }

  static String run(int input, String program) {
    return run(input, Arrays.stream(program.split(","))
        .mapToInt(Integer::parseInt)
        .toArray());
  }

  static String run(int input, int[] p) {
    StringBuilder output = new StringBuilder();
    int i = 0;
    while (p[i] != 99) {
      int opCode = p[i] % 100;
      boolean imm1 = (p[i] / 100) % 10 > 0;
      boolean imm2 = (p[i] / 1000) % 10 > 0;
      boolean imm3 = (p[i] / 10000) % 10 > 0;
      outputWithPointer(i, p);
      switch (opCode) {
        case 1: // add
          p[p[i + 3]] = (imm1 ? p[i + 1] : p[p[i + 1]]) + (imm2 ? p[i + 2] : p[p[i + 2]]);
          i += 4;
          break;
        case 2: // multiply
          p[p[i + 3]] = v(1, imm1, i, p) * v(2, imm2, i, p);
          i += 4;
          break;
        case 3: // input
          p[p[i + 1]] = input;
          i += 2;
          break;
        case 4: // output
          output.append(v(1, imm1, i, p));
          i += 2;
          break;
        case 5: // jump if true
          if (v(1, imm1, i, p) != 0) {
            i = v(2, imm2, i, p);
          } else {
            i += 3;
          }
          break;
        case 6: // jump if false
          if (v(1, imm1, i, p) == 0) {
            i = v(2, imm2, i, p);
          } else {
            i += 3;
          }
          break;
        case 7: // less than
          if (v(1, imm1, i, p) < v(2, imm2, i, p)) {
            p[p[i + 3]] = 1;
          } else {
            p[p[i + 3]] = 0;
          }
          i += 4;
          break;
        case 8: // equals
          if (v(1, imm1, i, p) == v(2, imm2, i, p)) {
            p[p[i + 3]] = 1;
          } else {
            p[p[i + 3]] = 0;
          }
          i += 4;
          break;
        default:
          throw new IllegalArgumentException("op: " + opCode);
      }
    }
    return output.toString();
  }

  private static int v(int arg, boolean immediate, int i, int[] p) {
    return immediate ? p[i + arg] : p[p[i + arg]];
  }

  private static void outputWithPointer(int i, int[] p) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < p.length; j++) {
        if (i == j) {
          sb.append(">");
        }
        sb.append(p[j]);
        if (i == j) {
          sb.append("<");
        }
        sb.append(",");
    }
    System.out.println(sb);
  }
  //      }
//    }
}
