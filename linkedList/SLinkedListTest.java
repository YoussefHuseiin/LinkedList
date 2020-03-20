package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class SLinkedListTest {

	@Test
	void TestSingleList() {
  SLinkedList test = new SLinkedList();
  test.add(1);
  test.add(0, 4);
  test.add(2, 8);
  test.add(5);
  test.add(2,9);
  assertEquals(test.get(0),4);
  assertEquals(test.get(1),1);
  assertEquals(test.get(2),9);
  assertEquals(test.get(3),8);
  assertEquals(test.get(4),5);
  test.set(2, 15);
  test.set(0, 12);
  assertEquals(test.get(0),12);
  assertEquals(test.get(2),15);
  assertEquals(test.size(),5);
  test.remove(1);
  test.remove(3);
  assertEquals(test.get(0),12);
  assertEquals(test.get(1),15);
  assertEquals(test.get(2),8);
  assertEquals(test.size(),3);
  assertTrue(test.contains(15));
  assertFalse(test.contains(10));
  assertTrue(test.contains(8));
  assertFalse(test.contains(0));
  assertFalse(test.isEmpty());
  test.clear();
  assertEquals(test.size(),0);
  assertTrue(test.isEmpty());
  test.add(0,1);
  test.add(0,5);
  test.add(2,3);
  test.add(1,4);
  test.add(0);
  test.remove(0);
  test.remove(2);
  assertEquals(test.get(0),4);
  assertEquals(test.get(1),1);
  assertEquals(test.get(2),0);
  assertEquals(test.size(),3);
  assertFalse(test.isEmpty());
  assertTrue(test.contains(1));
  assertFalse(test.contains(10));
  assertThrows(RuntimeException.class,()->test.add(10,5));
  assertEquals(test.size(),3);  
  assertThrows(RuntimeException.class,()->test.add(-2,2));
  assertThrows(RuntimeException.class,()->test.remove(10));
  assertThrows(RuntimeException.class,()->test.remove(-2));
  assertNull(test.get(10));
  test.clear();
  test.add(0, 1);
  test.add(1, 2);
  test.add(2, 3);
  test.add(3, 4);
  test.add(4, 5);
  test.add(5, 6);
  test.add(6, 7);
  test.add(7, 8);
  test.add(8, 9);
  assertEquals(test.size(),9);
  assertEquals(test.sublist(2,5).size(),3);
  assertEquals(test.get(2),3);
  assertEquals(test.sublist(2,5).get(0),3);
	}
}
