package kevinp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Advent5Test {

  @Test
  public void test1a_eq_pos_false() {
    assertEquals("0", Advent5.run(7, "3,9,8,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test1b_eq_pos_true() {
    assertEquals("1", Advent5.run(8, "3,9,8,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test1c_eq_pos_false() {
    assertEquals("0", Advent5.run(9, "3,9,8,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test2a_lt_pos_true() {
    assertEquals("1", Advent5.run(7, "3,9,7,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test2b_lt_pos_false() {
    assertEquals("0", Advent5.run(8, "3,9,7,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test2c_lt_pos_false() {
    assertEquals("0", Advent5.run(9, "3,9,7,9,10,9,4,9,99,-1,8"));
  }

  @Test
  public void test3a_eq_imm_false() {
    assertEquals("0", Advent5.run(7, "3,3,1108,-1,8,3,4,3,99"));
  }

  @Test
  public void test3b_eq_imm_true() {
    assertEquals("1", Advent5.run(8, "3,3,1108,-1,8,3,4,3,99"));
  }

  @Test
  public void test3c_eq_imm_false() {
    assertEquals("0", Advent5.run(9, "3,3,1108,-1,8,3,4,3,99"));
  }

  @Test
  public void test4a_lt_imm_true() {
    assertEquals("1", Advent5.run(7, "3,3,1107,-1,8,3,4,3,99"));
  }

  @Test
  public void test4b_lt_imm_false() {
    assertEquals("0", Advent5.run(8, "3,3,1107,-1,8,3,4,3,99"));
  }

  @Test
  public void test4c_lt_imm_false() {
    assertEquals("0", Advent5.run(9, "3,3,1107,-1,8,3,4,3,99"));
  }

  @Test
  public void test5a_jmp_pos_0() {
    assertEquals("0", Advent5.run(0, "3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9"));
  }

  @Test
  public void test5b_jmp_pos_1() {
    assertEquals("1", Advent5.run(1, "3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9"));
  }

  @Test
  public void test6a_jmp_imm_0() {
    assertEquals("0", Advent5.run(0, "3,3,1105,-1,9,1101,0,0,12,4,12,99,1"));
  }

  @Test
  public void test6b_jmp_imm_1() {
    assertEquals("1", Advent5.run(1, "3,3,1105,-1,9,1101,0,0,12,4,12,99,1"));
  }

  @Test
  public void test7a_long_low() {
    assertEquals("999", Advent5.run(4,
        "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"));
  }

  @Test
  public void test7b_long_low() {
    assertEquals("1000", Advent5.run(8,
        "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"));
  }

  @Test
  public void test7c_long_high() {
    assertEquals("1001", Advent5.run(12,
        "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"));
  }

}