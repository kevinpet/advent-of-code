package kevinp;

import static org.junit.Assert.*;

import org.junit.Test;

public class Advent8Test {

  @Test
  public void given1() {
    int[][][] expected = {
        {
            {1, 2, 3},
            {4, 5, 6}
        },
        {
            {7, 8, 9},
            {0, 1, 2}
        }
    };
    assertArrayEquals(expected, Advent8.loadLayers(3, 2, "123456789012"));
  }

  @Test
  public void testFewestZeros() {
    int[][][] data = {
        {
            {1, 2, 3},
            {4, 5, 6}
        },
        {
            {7, 8, 9},
            {0, 1, 2}
        }
    };
    assertEquals(0, Advent8.fewestZeros(data));
  }

  @Test
  public void test1sby2s() {
    int[][][] data = {
        {
            {1, 1, 3},
            {4, 5, 6}
        },
        {
            {7, 2, 9},
            {0, 1, 2}
        },
        {
            {2, 2, 9},
            {1, 1, 2}
        }
    };
    assertEquals(0, Advent8.onesByTwos(data, 0));
    assertEquals(2, Advent8.onesByTwos(data, 1));
    assertEquals(6, Advent8.onesByTwos(data, 2));
  }

  @Test
  public void testTopVisible() {
    int[][][] data = {
        {
            {2, 2, 9},
            {1, 2, 2}
        },
        {
            {1, 2, 3},
            {4, 5, 6}
        },
        {
            {7, 0, 9},
            {0, 1, 2}
        }
    };
    int[][] expected = {
        { 1, 0, 9 },
        { 1, 5, 6}
    };
    assertArrayEquals(expected, Advent8.merge(data));
  }

}