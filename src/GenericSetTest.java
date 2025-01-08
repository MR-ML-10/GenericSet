
/*
* AUTHOR: Abdulrahman Al Rajhi
* FILE: GenericSetTest.java
* ASSIGNMENT: Programming Assignment 1 - GenericSet
* COURSE: CSC 335; Fall 2023
* PURPOSE: This is a Generic Set test class, which tests different
* scenarios using class methods.
* 
*/
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GenericSetTest {

	@Test
	void testAddAndSizeWithDuplicates() {
		GenericSet<Integer> mySet = new GenericSet<>();
		mySet.add(1);
		mySet.add(3);
		mySet.add(2);
		mySet.add(2);
		mySet.add(2);
		mySet.add(2);

		assertEquals(3, mySet.size());
		assertFalse(mySet.add(3));
		assertTrue(mySet.add(4));
		assertTrue(mySet.add(44));
		assertEquals(5, mySet.size());
		assertTrue(mySet.add(223));
		assertEquals(6, mySet.size());
		mySet.add(null);
		assertEquals(7, mySet.size());

		assertTrue(mySet.add(23));
		assertTrue(mySet.add(24));

		assertFalse(mySet.add(1));
		assertFalse(mySet.add(2));
	}

	@Test
	void testNegetiveNumbersAndSize() {
		GenericSet<Integer> mySet = new GenericSet<>();

		mySet.add(-123);
		mySet.add(-123);
		mySet.add(-1);
		assertEquals(2, mySet.size());

		mySet.add(-1123);
		assertEquals(3, mySet.size());

		mySet.add(-1234);
		assertEquals(4, mySet.size());

		mySet.add(0);
		assertEquals(5, mySet.size());

		mySet.add(0);
		assertEquals(5, mySet.size());
	}

	@Test
	void testContains() {
		GenericSet<Integer> mySet = new GenericSet<>();

		mySet.add(1);
		mySet.add(1);
		mySet.add(2);
		mySet.add(3);

		assertTrue(mySet.contains(3));
		assertTrue(mySet.contains(2));
		assertFalse(mySet.contains(4523));

		mySet.add(7);
		assertTrue(mySet.contains(7));
	}

	@Test
	void testUnion() {
		GenericSet<Integer> mySet = new GenericSet<>();
		GenericSet<Integer> otherSet = new GenericSet<>();

		for (int i = 0; i < 5; i++) {
			mySet.add(i);
			otherSet.add(i);
		}
		mySet.add(8);
		mySet.add(99);
		mySet.add(00);

		otherSet.add(5);
		otherSet.add(6);
		otherSet.add(7);

		otherSet.add(8);
		otherSet.add(99);
		otherSet.add(0);

		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 99]", mySet.unionOfSets(otherSet).toString());

		mySet.add(-1);
		mySet.add(-654);

		otherSet.add(-1);
		otherSet.add(-654);

		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 99, -1, -654]", mySet.unionOfSets(otherSet).toString());
	}

	@Test
	void testIntersection() {
		GenericSet<Integer> mySet = new GenericSet<>();
		GenericSet<Integer> otherSet = new GenericSet<>();
		mySet.add(1);
		mySet.add(2);
		mySet.add(3);

		otherSet.add(1);
		otherSet.add(2);
		otherSet.add(3);

		assertEquals("[1, 2, 3]", mySet.intersectionOfSets(otherSet).toString());

		mySet.add(4);
		mySet.add(5);

		assertEquals("[1, 2, 3]", mySet.intersectionOfSets(otherSet).toString());
		otherSet.add(7);
		otherSet.add(8);
		assertEquals("[1, 2, 3]", mySet.intersectionOfSets(otherSet).toString());

		mySet.add(8);
		assertEquals("[1, 2, 3, 8]", mySet.intersectionOfSets(otherSet).toString());
	}

	@Test
	void testUnionWithEmptySets() {
		GenericSet<Integer> mySet = new GenericSet<>();
		GenericSet<Integer> otherSet = new GenericSet<>();
		assertEquals("[]", mySet.unionOfSets(otherSet).toString());
	}

	@Test
	void testIntersectionWithEmptySets() {
		GenericSet<Integer> mySet = new GenericSet<>();
		GenericSet<Integer> otherSet = new GenericSet<>();
		assertEquals("[]", mySet.intersectionOfSets(otherSet).toString());
	}
}
