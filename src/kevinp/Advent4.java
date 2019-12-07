package kevinp;

public class Advent4 {

    public static void main(String[] args) {
      int count = 0;
      num:
      for (int candidate = 171309; candidate <= 643603; candidate++) {
        int i = candidate;
        int last = i % 10;
        int repeatCount = 1;
        i = i / 10;
        boolean doubles = false;
        for (int j = 0; j < 5; j++) {
          int current = i % 10;
          if (current == last) {
            repeatCount++;
          } else {
            if (repeatCount == 2) {
              doubles = true;
            }
            repeatCount = 1;
          }
          if (current > last) {
            continue num;
          }
          i = i / 10;
          last = current;
        }
        if (repeatCount == 2 || doubles) {
          count++;
        }
      }
      System.out.println("\nCount was: " + count);
    }
}
