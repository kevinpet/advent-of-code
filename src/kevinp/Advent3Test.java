package kevinp;

import static org.junit.Assert.*;

import org.junit.Test;

public class Advent3Test {

  @Test
  public void testGiven1() {
    assertEquals(159, Advent3.crossingDistance("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"));
  }

  @Test
  public void testGiven2() {
    assertEquals(135, Advent3.crossingDistance("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"));
  }

}