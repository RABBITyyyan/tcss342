package tests;

import static org.junit.Assert.*;

import java.util.Iterator;

import mybagpackage.LinkedBagSorted;

import org.junit.Before;
import org.junit.Test;


/**
 * JUnit test of ArrayListUnsorted
 * @author Kaiyaun Shi, Monika, Chang Yan (Charlotte)
 * @version Autumn 2016
 */
public class LinkedBagSortedTest {

	private LinkedBagSorted<Integer> al;//array list
//	private ArrayBagUnsorted<String> bl;
//	private ArrayBagUnsorted<String> cl;
	@Before
	public final void setup() {
		//al = new ArrayListUnsorted<String>();
		al = new LinkedBagSorted<Integer>();
	}
	
	/**
	 * test getSize with 0 element
	 */
	@Test
	public final void getSize0() {
		assertEquals("empty size fail", 0, al.getSize());	
	}

	/**
	 * test getSize with 3 elements
	 */
	@Test
	public final void getSize3N() {
		al.insert(1);
		al.insert(2);
		al.insert(3);
		assertEquals("size 3 fail", 3, al.getSize());
		
	}

	/**
	 * test getSize with 205 elements
	 */
	@Test
	public final void getSize205() {
	
		for (int i = 0; i < 205; i++)
			al.insert(i);
		
		assertEquals("size 205 fail", 205, al.getSize());
	}

	/**
	 * test isEmpty with empty list
	 */
	@Test
	public final void isEmpty0() {
		assertTrue("0 empty fail", al.isEmpty());
	}

	/**
	 * test isEmpty with 3 elements
	 */
	@Test
	public final void isEmpty3N() {
		al.insert(1);
		al.insert(2);
		al.insert(3);
		assertFalse("3 empty fail", al.isEmpty());
	}

	/**
	 * test isEmpty with 205 elements
	 */
	@Test
	public final void isEmpty205() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		assertFalse("205 empty fail", al.isEmpty());
	}
	
	/**
	 * test contains with empty list
	 */
	@Test
	public final void containEmpty() {
		assertFalse("contain empty fail", al.contains(1));
	}

	/**
	 * test contains with 1 element and it exists in the list
	 */
	@Test
	public final void contain1TN() {
		al.insert(1);
		assertTrue("contain 1 true fail", al.contains(1));
	}
	
	/**
	 * test contains with 1 element and it does NOT exist in the list
	 */
	@Test
	public final void contain1FN() {
		al.insert(1);
		assertFalse("contain 1 false fail", al.contains(2));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the head of the list
	 */
	@Test
	public final void arrayContain2HT() {
		al.insert(1);
		al.insert(2);
		assertTrue("contain 2 head true fail", al.contains(1));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the tail of the list
	 */
	@Test
	public final void arrayContain2TT() {
		al.insert(1);
		al.insert(2);
		assertTrue("contain 2 tail true fail", al.contains(2));
	}
	
	/**
	 * test contains with 2 elements list and element does NOT exist
	 */
	@Test
	public final void arrayContain2F() {
		al.insert(1);
		al.insert(2);
		assertFalse("contain 2 false fail", al.contains(3));
	}
	
	/**
	 * test contains with 205 elements list and element exist at the head of the list
	 */
	@Test
	public final void arrayContain205HT() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		
		assertTrue("contain 205 head true fail", al.contains(0));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the tail of the list
	 */
	@Test
	public final void arrayContain205TT() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		
		assertTrue("contain 205 tail true fail", al.contains(204));
	}
	
	/**
	 * test contains with 205 elements list and element does NOT exist
	 */
	@Test
	public final void arrayContain205F() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		assertFalse("contain 205 false fail", al.contains(206));
	}
	
	/**
	 * test insert by insert 1 element
	 */
	@Test
	public final void insert1N() {
		al.insert(1);
		assertEquals("insert 1 fail", "[1]", al.toString());
	}
	
	/**
	 * test insert by insert 3 elements
	 */
	@Test
	public final void insert3N() {
		al.insert(1);
		al.insert(2);
		al.insert(3);
		assertEquals("insert 3 fail", "[1, 2, 3]", al.toString());
	}
	
	/**
	 * test insert by insert 4 elements in different order
	 */
	@Test
	public final void insert4N() {
		al.insert(4);
		al.insert(3);
		al.insert(2);
		al.insert(1);
		assertEquals("insert 3 fail", "[1, 2, 3, 4]", al.toString());
	}
	
	/**
	 * test insert by insert 5 elements in different order
	 */
	@Test
	public final void insert5N() {
		al.insert(2);
		al.insert(5);
		al.insert(4);
		al.insert(1);
		al.insert(3);
		assertEquals("insert 3 fail", "[1, 2, 3, 4, 5]", al.toString());
	}
	
	/**
	 * test insert by insert 205 elements
	 */
	@Test
	public final void insert205() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		
		String str = "[0";
		for (int i = 1; i < 205; i++)
			str += ", " + i;
		str += "]";
		assertEquals("insert 205 fail", str, al.toString());
	}
	
	
	
	/**
	 * test clear by clear an empty list
	 */
	@Test
	public final void clear0() {
		al.clear();
		assertEquals("clear 0 fail", "[]", al.toString());
	}
	
	/**
	 * test clear by clear a 1 element list
	 */
	@Test
	public final void clear1() {
		al.insert(1);
		al.clear();
		assertEquals("clear 1 fail", "[]", al.toString());
	}
	
	/**
	 * test clear by clear a 3 elements list
	 */
	@Test
	public final void clear3N() {
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.clear();
		assertEquals("clear 3 fail", "[]", al.toString());
	}
	
	/**
	 * test clear by clear a 205 elements list
	 */
	@Test
	public final void clear205() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.clear();
		assertEquals("clear 205 fail", "[]", al.toString());
	}
	
	/**
	 * test remove by remove exist element from 1 element list
	 */
	@Test
	public final void remove0True() {
		
		al.insert(1);
		al.remove(1);
		assertEquals("remove 0 True fail", "[]", al.toString());
		
	}
	
	/**
	 * test remove by remove not exist element from 1 element list
	 */
	@Test
	public final void remove0False() {		
		al.insert(1);
		al.remove(2);
		assertEquals("remove 0 False fail", "[1]", al.toString());	
	}
	
	/**
	 * test remove by remove exist element from 5 elements list
	 */
	@Test
	public final void remove5TrueN() {		
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.insert(4);
		al.insert(5);
		al.remove(3);
		assertEquals("remove 5 True fail", "[1, 2, 4, 5]", al.toString());	
	}
	
	/**
	 * test remove by remove NOT exist element from 5 elements list
	 */
	@Test
	public final void remove5False() {		
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.insert(4);
		al.insert(5);
		al.remove(6);
		assertEquals("remove 5 False fail", "[1, 2, 3, 4, 5]", al.toString());	
	}
	
	/**
	 * test remove by remove head element from 5 elements list
	 */
	@Test
	public final void remove5HeadNext() {		
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.insert(4);
		al.insert(5);
		al.remove(2);
		assertEquals("remove 5 head next fail", "[1, 3, 4, 5]", al.toString());	
	}
	
	/**
	 * test remove by remove tail element from 5 elements list
	 */
	@Test
	public final void remove5TailNext() {		
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.insert(4);
		al.insert(5);
		al.remove(4);
		assertEquals("remove 5 tail next fail", "[1, 2, 3, 5]", al.toString());	
	}
	
	/**
	 * test remove by remove head element from 205 elements list
	 */
	@Test
	public final void remove205Head() {		
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.remove(0);
		
		String str = "[";
		for (int i = 1; i < 204; i++) {
			str += i + ", ";
		}
		str += "204]";
		
		assertEquals("remove 205 head fail", str, al.toString());	
	}
	
	/**
	 * test remove by remove tail element from 205 elements list
	 */
	@Test
	public final void remove205Tail() {		
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.remove(204);
		
		String str = "[0";
		for (int i = 1; i < 204; i++) {
				str += ", " + i;
		}
		str += "]";
		
		assertEquals("remove 205 tail fail", str, al.toString());	
	}
	
	/**
	 * test remove by remove middle element from 205 elements list
	 */
	@Test
	public final void remove205Middle() {		
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.remove(101);
		
		String str = "[0";

		
		for (int i = 1; i < 101; i++) {
			str += ", " + i;
		}
		
		for (int i = 102; i < 205; i++) {
			str += ", " + i;
		}
		
		str += "]";
		
		assertEquals("remove 205 middle fail", str, al.toString());	
	}
	
	/**
	 * test getIndex by get NOT exist element
	 */
	@Test
	public final void getIndex0() {		
		assertEquals("get 0 index fail", -1, al.getIndex(1));	
	}
	
	/**
	 * test getIndex by get exist element from 1 element list
	 */
	@Test
	public final void getIndex1TrueN() {	
		al.insert(1);
		assertEquals("get 1 index True fail", 0, al.getIndex(1));	
	}
	
	/**
	 * test getIndex by get NOT exist element from 1 element list
	 */
	@Test
	public final void getIndex1FalseN() {
		al.insert(1);
		assertEquals("get 1 index False fail", -1, al.getIndex(2));	
	}
	
	/**
	 * test getIndex by get head element from 205 elements list
	 */
	@Test
	public final void getIndex205Head() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		assertEquals("get 205 index head fail", 0, al.getIndex(0));	
	}
	
	/**
	 * test getIndex by get tail element from 205 elements list
	 */
	@Test
	public final void getIndex205Tail() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		assertEquals("get 1 index tail fail", 204, al.getIndex(204));	
	}
	
	/**
	 * test getIndex by get NOT exist element from 205 elements list
	 */
	@Test
	public final void getIndex205False() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		assertEquals("get 1 index False fail", -1, al.getIndex(-1));	
	}
	
	
	/**
	 * test removeAtIndex by remove negative index
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void removeAtIndexNegative() {
		al.removeAtIndex(-1);
	}
	
	/**
	 * test removeAtIndex by remove 0 index from empty list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void removeAtIndex0False() {
		al.removeAtIndex(0);
	}
	
	/**
	 * test removeAtIndex by remove out of bound index from 1 element list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void removeAtIndex1False() {
		al.insert(1);
		al.removeAtIndex(1);
	}
	
	/**
	 * test removeAtIndex by remove 0 index from 1 element list
	 */
	@Test
	public final void removeAtIndex0() {
		al.insert(1);
		al.removeAtIndex(0);
		assertEquals("removeAtIndex 0 fail", "[]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove head from 2 elements list
	 */
	@Test
	public final void removeAtIndex2Head() {
		al.insert(1);
		al.insert(2);
		al.removeAtIndex(0);
		assertEquals("removeAtIndex 2 tail fail", "[2]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove tail from 2 elements list
	 */
	@Test
	public final void removeAtIndex2Tail() {
		al.insert(1);
		al.insert(2);
		al.removeAtIndex(1);
		assertEquals("removeAtIndex 2 tail fail", "[1]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove position one next to head from 5 elements list
	 */
	@Test
	public final void removeAtIndex5HeadNextN() {
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.insert(4);
		al.insert(5);
		al.removeAtIndex(1);
		assertEquals("removeAtIndex 5 head next fail", "[1, 3, 4, 5]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove position one next to tail from 5 elements list
	 */
	@Test
	public final void removeAtIndex5TailNextN() {
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.insert(4);
		al.insert(5);
		al.removeAtIndex(3);
		assertEquals("removeAtIndex 5 tail next fail", "[1, 2, 3, 5]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove head from 205 elements list
	 */
	@Test
	public final void removeAtIndex205Head() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.removeAtIndex(0);
		String str = "[";
		for (int i = 1; i < 204; i++)
			str += i + ", ";
		str += "204]";
		
		
		assertEquals("removeAtIndex 205 head fail", str, al.toString());
	}
	
	/**
	 * test removeAtIndex by remove tail from 205 elements list
	 */
	@Test
	public final void removeAtIndex205Tail() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.removeAtIndex(204);
		String str = "[0";
		for (int i = 1; i < 204; i++)
			str += ", " + i;
		str += "]";
		assertEquals("removeAtIndex 205 tail fail", str, al.toString());
	}
	
	/**
	 * test removeAtIndex by remove middle from 205 elements list
	 */
	@Test
	public final void removeAtIndex205Middle() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.removeAtIndex(101);
		String str = "[0";
		for (int i = 1; i < 205; i++) {
			if (i != 101) {
				str += ", " + i;
			}
		}
		str += "]";
		
		assertEquals("removeAtIndex 205 middle fail", str, al.toString());
	}
	
	/**
	 * test set by set negative index in an empty list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void setNegative() {
		al.set(-1, 1);
	}
	
	/**
	 * test set by set 0 index in an empty list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void set0False() {
		al.set(0, 1);
	}
	
	/**
	 * test set by set out of bound index in a 1 element list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void set1False() {
		al.insert(1);
		al.set(1, 2);
	}
	
	/**
	 * test set by set 0 index in a 1 element list
	 */
	@Test
	public final void set1() {
		al.insert(1);
		al.set(0, 2);
		assertEquals("set 1 fail", "[2]", al.toString());
	}
	
	/**
	 * test set by set one next to head index in a 5 elements list
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void set5HeadNextN() {
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.insert(4);
		al.insert(5);
		al.set(1, 6);
	}
	
	/**
	 * test set by set one next to tail index in a 5 elements list
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void set5TailNextN() {
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.insert(4);
		al.insert(5);
		al.set(3, 6);
	}
	
	/**
	 * test set by set head index in a 205 elements list
	 */
	@Test
	public final void set205Head() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.set(0, -1);
		String str = "[-1";
		for (int i = 1; i < 204; i++) {
			str += ", " + i;	
		}
		str += ", 204]";
		assertEquals("set 205 tail fail", str, al.toString());
	}
	
	/**
	 * test set by set head index in a 205 elements list
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void set205HeadIllegal() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.set(0, 500);
	}
	
	/**
	 * test set by set tail index in a 205 elements list
	 */
	@Test 
	public final void set205Tail() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.set(204, 500);
		String str = "[0";
		for (int i = 1; i < 204; i++) {
				str += ", " + i;	
		}
		str += ", 500]";
		assertEquals("set 205 tail fail", str, al.toString());
	}
	
	/**
	 * test set by set tail index in a 205 elements list
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void set205TailIllegal() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.set(204, 0);
	}
	
	/**
	 * test set by set middle index in a 205 elements list
	 */
	@Test 
	public final void set10Middle() {
		for (int i = 0; i < 4; i++)
			al.insert(i);
		
		for (int i = 5; i < 10; i++)
			al.insert(i);
		
		al.set(4, 4);
		
		String str = "[0";
		for (int i = 1; i < 5; i++) {
				str += ", " + i;
		}
		for (int i = 6; i < 10; i++) {
			str += ", " + i;
	}
		str += "]";
		assertEquals("set 10 middle fail", str, al.toString());
	}
	
	/**
	 * test set by set middle index in a 205 elements list
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void set205MiddleIllegal() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		al.set(101, 500);
	}
	
	/**
	 * test get by get negative index from an empty list
	 */
	@Test  (expected = IndexOutOfBoundsException.class)
	public final void getNegative() {
		al.get(-1);
	}
	
	/**
	 * test get by get 0 index from an empty list
	 */
	@Test  (expected = IndexOutOfBoundsException.class)
	public final void get0False() {
		al.get(0);
	}
	
	/**
	 * test get by get out of bound index from a 1 element list
	 */
	@Test  (expected = IndexOutOfBoundsException.class)
	public final void get1False() {
		al.insert(1);
		al.get(1);
	}
	
	/**
	 * test get by get 0 index from a 1 element list
	 */
	@Test
	public final void get1N() {
		al.insert(1);
		assertEquals("get 1 fail", "1", al.get(0).toString());
	}
	
	/**
	 * test get by get head index from a 2 elements list
	 */
	@Test
	public final void get2Head() {
		al.insert(1);
		al.insert(2);
		assertEquals("get 2 head fail", "1", al.get(0).toString());
	}
	
	/**
	 * test get by get tail index from a 2 elements list
	 */
	@Test
	public final void get2Tail() {
		al.insert(1);
		al.insert(2);
		assertEquals("get 2 tail fail", "2", al.get(1).toString());
	}

	/**
	 * test get by get one next to head index from a 5 elements list
	 */
	@Test
	public final void get5HeadNextN() {
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.insert(4);
		al.insert(5);
		assertEquals("get 5 head next fail", "2", al.get(1).toString());
	}
	
	/**
	 * test get by get one next to tail index from a 5 elements list
	 */
	@Test
	public final void get5TailNextN() {
		al.insert(1);
		al.insert(2);
		al.insert(3);
		al.insert(4);
		al.insert(5);
		assertEquals("get 5 tail next fail", "4", al.get(3).toString());
	}
	
	/**
	 * test get by get head index from a 205 elements list
	 */
	@Test
	public final void get205Head() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		assertEquals("get 205 head fail", "0", al.get(0).toString());
	}

	/**
	 * test get by get tail index from a 205 elements list
	 */
	@Test
	public final void get205Tail() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		assertEquals("get 205 tail fail", "204", al.get(204).toString());
	}

	/**
	 * test get by get middle index from a 205 elements list
	 */
	@Test
	public final void get205Middle() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		assertEquals("get 205 middle fail", "101", al.get(101).toString());
	}
	
	/**
	 * test iterator by iterate empty list
	 */
	@Test
	public final void iterator0() {
		Iterator<Integer> itr = al.iterator();
		String str = "[";
		while (itr.hasNext()) {
			str += ", " + itr.next();
		}
		str += "]";
		assertEquals("iterator 0 fail", str, al.toString());
	}
	
	/**
	 * test iterator by iterate 1 element list
	 */
	@Test
	public final void iterator1N() {
		al.insert(1);
		Iterator<Integer> itr = al.iterator();
		String str = "[" + itr.next();
		while (itr.hasNext()) {
			str += ", " + itr.next();
		}
		str += "]";
		assertEquals("iterator 1 fail", str, al.toString());
	}
	
	/**
	 * test iterator by iterate 205 elements list
	 */
	@Test
	public final void iterator205() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		Iterator<Integer> itr = al.iterator();
		String str = "[" + itr.next();
		while (itr.hasNext()) {
			str += ", " + itr.next();
		}
		str += "]";
		assertEquals("iterator 205 fail", str, al.toString());
	}
	
	/**
	 * test remove method of iterator
	 */
	@Test
	public final void iteratorRemove() {
		for (int i = 0; i < 205; i++)
			al.insert(i);
		Iterator<Integer> itr = al.iterator();
		while (itr.hasNext()) {
			Integer temp = itr.next();
			if (temp.toString().equals("101"))
				itr.remove();
		}
	
		
		itr = al.iterator();
		// expected
		String str = "[" + "0";
		for (int i = 1; i < 101; i++) {
			str += ", " + i;
		}
		for (int i = 102; i < 205; i++) {
			str += ", " + i;
		}
		str += "]";
		
		
		String testStr = "[0";
		for (int i = 1; i < 205; i++) {
			if (i != 101)
				testStr += ", " + i;
		}
		testStr += "]";
		
		assertEquals("iterator remove fail", str, testStr);
	}
	
}

