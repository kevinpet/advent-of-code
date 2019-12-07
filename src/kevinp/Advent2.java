package kevinp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Advent2 {

    public static void main(String[] args) throws IOException {
      List<String> lines = Files.readAllLines(Path.of("advent2.txt"));
      int[] original =
          Arrays.stream(lines.iterator().next().split(","))
              .mapToInt(Integer::parseInt)
              .toArray();
      for (int noun = 0; noun < 100; noun++) {
        candidates:
        for (int verb = 0; verb < 100; verb++) {
          int[] program = original.clone();
          int ip = 0;
          program[1] = noun;
          program[2] = verb;
          while (program[ip] != 99) {
            int opCode = program[ip];
            int a = program[ip + 1];
            int b = program[ip + 2];
            int d = program[ip + 3];
            switch (opCode) {
              case 1:
                program[d] = program[a] + program[b];
                break;
              case 2:
                program[d] = program[a] * program[b];
                break;
              default:
                continue candidates;
            }
            ip += 4;
          }
          if (program[0] == 19690720 || program[0] == 3562624) {
            System.out.println("got " + program[0] + " for " + noun + " " + verb);
          }
        }
      }
    }
}
