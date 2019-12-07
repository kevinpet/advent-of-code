package kevinp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Advent7Test {

  @Test
  public void test1a_eq_pos_false() {
    assertEquals("0", Advent7.run(7, "3,9,8,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test1b_eq_pos_true() {
    assertEquals("1", Advent7.run(8, "3,9,8,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test1c_eq_pos_false() {
    assertEquals("0", Advent7.run(9, "3,9,8,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test2a_lt_pos_true() {
    assertEquals("1", Advent7.run(7, "3,9,7,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test2b_lt_pos_false() {
    assertEquals("0", Advent7.run(8, "3,9,7,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test2c_lt_pos_false() {
    assertEquals("0", Advent7.run(9, "3,9,7,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test3a_eq_imm_false() {
    assertEquals("0", Advent7.run(7, "3,3,1108,-1,8,3,4,3,99"));
  }

  @Test
  public void test3b_eq_imm_true() {
    assertEquals("1", Advent7.run(8, "3,3,1108,-1,8,3,4,3,99"));
  }

  @Test
  public void test3c_eq_imm_false() {
    assertEquals("0", Advent7.run(9, "3,3,1108,-1,8,3,4,3,99"));
  }

  @Test
  public void test4a_lt_imm_true() {
    assertEquals("1", Advent7.run(7, "3,3,1107,-1,8,3,4,3,99"));
  }

  @Test
  public void test4b_lt_imm_false() {
    assertEquals("0", Advent7.run(8, "3,3,1107,-1,8,3,4,3,99"));
  }

  @Test
  public void test4c_lt_imm_false() {
    assertEquals("0", Advent7.run(9, "3,3,1107,-1,8,3,4,3,99"));
  }

  @Test
  public void test5a_jmp_pos_0() {
    assertEquals("0", Advent7.run(0, "3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9"));
  }

  @Test
  public void test5b_jmp_pos_1() {
    assertEquals("1", Advent7.run(1, "3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9"));
  }

  @Test
  public void test6a_jmp_imm_0() {
    assertEquals("0", Advent7.run(0, "3,3,1105,-1,9,1101,0,0,12,4,12,99,1"));
  }

  @Test
  public void test6b_jmp_imm_1() {
    assertEquals("1", Advent7.run(1, "3,3,1105,-1,9,1101,0,0,12,4,12,99,1"));
  }

  @Test
  public void test7a_long_low() {
    assertEquals("999", Advent7.run(4,
        "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"));
  }

  @Test
  public void test7b_long_low() {
    assertEquals("1000", Advent7.run(8,
        "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"));
  }

  @Test
  public void test7c_long_high() {
    assertEquals("1001", Advent7.run(12,
        "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"));
  }

  @Test
  public void testPhase1() {
    assertEquals(43210, Advent7.runPermutation(new int[]{4, 3, 2, 1, 0},
        new int[]{3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0}));
  }

  @Test
  public void testFindPhase1() {
    assertEquals("43210 given by 4 3 2 1 0",
        Advent7.findBestPermuation(new int[]{3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0}));
  }

  @Test
  public void testPhase2() {
    assertEquals(54321, Advent7.runPermutation(new int[]{0, 1, 2, 3, 4},
        new int[]{3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23,
            101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0}));
  }

  @Test
  public void testPhase3() {
    assertEquals(65210, Advent7.runPermutation(new int[]{1, 0, 4, 3, 2},
        new int[]{3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33, 1002, 33, 7, 33, 1, 33, 31, 31, 1,
            32, 31, 31, 4, 31, 99, 0, 0, 0}));
  }

}