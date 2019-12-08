package kevinp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Advent8 {
  public static void main(String[] args) throws IOException {
    int[][][] data = loadLayers(25, 6, Files.readString(Path.of("advent8.txt")));
    var layer = fewestZeros(data);
    System.out.println(onesByTwos(data, layer));
    Arrays.stream(merge(data)).forEach(row -> {
      Arrays.stream(row).forEach(e -> System.out.print(e == 1 ? "#" : " "));
      System.out.println();
    });
  }

  public static int[][][] loadLayers(int width, int height, String data) {
    int numLayers = data.length() / (width * height);
    int[][][] result = new int[numLayers][][];
    for (int layer = 0; layer < numLayers; layer++) {
      result[layer] = new int[height][];
      for (int row = 0; row < height; row++) {
        result[layer][row] = new int[width];
        for (int column = 0; column < width; column++) {
          int index = layer * height * width + row * width + column;
          result[layer][row][column] = Integer.parseInt(data.substring(index, index + 1));
        }
      }
    }
    return result;
  }

  public static int fewestZeros(int[][][] data) {
    int fewestIndex = -1;
    int fewestZeroes = Integer.MAX_VALUE;
    for (int i = 0; i < data.length; i++) {
      int zeros = 0;
      for (int r = 0; r < data[i].length; r++) {
        for (int c = 0; c < data[i][r].length; c++) {
          if (data[i][r][c] == 0) {
            zeros++;
          }
        }
      }
      if (zeros < fewestZeroes) {
        fewestIndex = i;
        fewestZeroes = zeros;
      }
    }
    return fewestIndex;
  }

  public static int onesByTwos(int[][][] data, int layer) {
    int ones = 0;
    int twos = 0;
      for (int r = 0; r < data[layer].length; r++) {
        for (int c = 0; c < data[layer][r].length; c++) {
          if (data[layer][r][c] == 1) {
            ones++;
          }
          if (data[layer][r][c] == 2) {
            twos++;
          }
        }
      }
    return ones * twos;
  }

  public static int[][] merge(int[][][] data) {
    int[][] merged = new int[data[0].length][];
    for (int row = 0; row < merged.length; row++) {
      merged[row] = new int[data[0][0].length];
      for (int column = 0; column < merged[row].length; column++) {
        for (int layer = 0; layer < data.length; layer++) {
          if (data[layer][row][column] != 2) {
            merged[row][column] = data[layer][row][column];
            break;
          }
        }
      }
    }
    return merged;
  }

}
