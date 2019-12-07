package kevinp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Advent7 {

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Path.of("advent7.txt"));
    int[] original =
        Arrays.stream(lines.iterator().next().split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
    System.out.println(findBestPermuation(original));
  }

  static String findBestPermuation(int[] program) {
    int max = 0;
    String best = "";
    for (int a = 0; a < 5; a++) {
      for (int b = 0; b < 5; b++) {
        if (b == a) continue;
        for (int c = 0; c < 5; c++) {
          if (c == b || c == a) continue;
          for (int d = 0; d < 5; d++) {
            if (d == c || d == b || d == a) continue;
            for (int e = 0; e < 5; e++) {
              if (e == d || e == c || e == b || e == a) continue;
              int output = runPermutation(new int[] { a, b, c, d, e }, program);
              if (output > max) {
                max = output;
                best = String.format("%d %d %d %d %d", a, b, c, d, e);
              }
            }
          }
        }
      }
    }
    return String.format("%d given by %s", max, best);
  }

  static int runPermutation(int[] phaseSettings, int[] program) {
    Program a = new Program(program);
    a.run(phaseSettings[0], 0);
    a.run();
    int outA = a.outputs.poll();

    Program b = new Program(program);
    b.run(phaseSettings[1], outA);
    b.run();
    int outB = b.outputs.poll();

    Program c = new Program(program);
    c.run(phaseSettings[2], outB);
    c.run();
    int outC = c.outputs.poll();

    Program d = new Program(program);
    d.run(phaseSettings[3], outC);
    int outD = d.outputs.poll();

    Program e = new Program(program);
    e.run(phaseSettings[4], outD);
    int outE = e.outputs.poll();
    return outE;
  }

  static String run(int input, String program) {
    return run(input, Arrays.stream(program.split(","))
        .mapToInt(Integer::parseInt)
        .toArray());
  }

  static class Program {
    int[] p;
    int i = 0;
    boolean halted = false;
    Queue<Integer> inputs = new LinkedList<>();
    Queue<Integer> outputs = new LinkedList<>();
    Program(int[] mem) {
      this.p = mem.clone();
    }

    String runToCompletion() {
      while (!halted) {
        run();
      }
      return outputs.stream().map(i -> Integer.toString(i)).collect(Collectors.joining());
    }

    void run(Integer... newInputs) {
      inputs.addAll(Arrays.asList(newInputs));
      while (true) {
        int opCode = p[i] % 100;
        boolean imm1 = (p[i] / 100) % 10 > 0;
        boolean imm2 = (p[i] / 1000) % 10 > 0;
        boolean imm3 = (p[i] / 10000) % 10 > 0;
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
            if (inputs.peek() == null) {
              return;
            }
            p[p[i + 1]] = inputs.poll();
            i += 2;
            break;
          case 4: // output
            outputs.add(v(1, imm1, i, p));
            i += 2;
            System.out.println(this);
            return;
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
          case 99:
            halted = true;
            return;
          default:
            throw new IllegalArgumentException("op: " + opCode);
        }
      }
    }

    public String toString() {
      StringBuilder sb = new StringBuilder("state: ");
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
      sb.append("\nremaining inputs: ").append(inputs);
      sb.append("\noutput: ").append(outputs);
      return sb.toString();
    }

  }

  static String run(int input, int[] p) {
    Program program = new Program(p);
    program.run(input);
    program.runToCompletion();
    return program.outputs.stream().map(i -> Integer.toString(i)).collect(Collectors.joining());
  }

  private static int v(int arg, boolean immediate, int i, int[] p) {
    return immediate ? p[i + arg] : p[p[i + arg]];
  }

  //      }
//    }
}
