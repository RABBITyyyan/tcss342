package tests;

import static org.junit.Assert.*;

import java.util.Iterator;

import mybagpackage.ArrayBagUnsorted;

import org.junit.Before;
import org.junit.Test;


/**
 * JUnit test of ArrayListUnsorted
 * @author Kaiyaun Shi, Monika, Chang Yan(Charlotte)
 * @version Autumn 2016
 */
public class ArrayBagUnsortedTest {

	private ArrayBagUnsorted<String> al;//array list
	private ArrayBagUnsorted<String> bl;
	private ArrayBagUnsorted<String> cl;
	@Before
	public final void setup() {
		al = new ArrayBagUnsorted<String>(1);
		bl = new ArrayBagUnsorted<String>(150);
		cl = new ArrayBagUnsorted<String>(200);
		
	}
	
	/**
	 * test constructor with illegal 0 input
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void zeroCapacity() {
		al = new ArrayBagUnsorted<String>(0);
	}
	
	/**
	 * test constructor with illegal negative input
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void negativeCapacity() {
		al = new ArrayBagUnsorted<String>(-1);
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
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		assertEquals("size 3 fail", 3, al.getSize());
		
	}

	/**
	 * test getSize with 205 elements
	 */
	@Test
	public final void getSize205() {
	
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		
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
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		assertFalse("3 empty fail", al.isEmpty());
	}

	/**
	 * test isEmpty with 205 elements
	 */
	@Test
	public final void isEmpty205() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		assertFalse("205 empty fail", al.isEmpty());
	}
	
	/**
	 * test contains with empty list
	 */
	@Test
	public final void containEmpty() {
		assertFalse("contain empty fail", al.contains("aaa"));
	}

	/**
	 * test contains with 1 element and it exists in the list
	 */
	@Test
	public final void contain1TN() {
		al.insert("aaa");
		assertTrue("contain 1 true fail", al.contains("aaa"));
	}
	
	/**
	 * test contains with 1 element and it does NOT exist in the list
	 */
	@Test
	public final void contain1FN() {
		al.insert("aaa");
		assertFalse("contain 1 false fail", al.contains("bbb"));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the head of the list
	 */
	@Test
	public final void arrayContain2HT() {
		al.insert("aaa");
		al.insert("bbb");
		assertTrue("contain 2 head true fail", al.contains("aaa"));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the tail of the list
	 */
	@Test
	public final void arrayContain2TT() {
		al.insert("aaa");
		al.insert("bbb");
		assertTrue("contain 2 tail true fail", al.contains("bbb"));
	}
	
	/**
	 * test contains with 2 elements list and element does NOT exist
	 */
	@Test
	public final void arrayContain2F() {
		al.insert("aaa");
		al.insert("bbb");
		assertFalse("contain 2 false fail", al.contains("ccc"));
	}
	
	/**
	 * test contains with 205 elements list and element exist at the head of the list
	 */
	@Test
	public final void arrayContain205HT() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		
		assertTrue("contain 205 head true fail", al.contains("str0"));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the tail of the list
	 */
	@Test
	public final void arrayContain205TT() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		
		assertTrue("contain 205 tail true fail", al.contains("str204"));
	}
	
	/**
	 * test contains with 205 elements list and element does NOT exist
	 */
	@Test
	public final void arrayContain205F() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		
		assertFalse("contain 205 false fail", al.contains("str"));
	}
	
	/**
	 * test insert by insert 1 element
	 */
	@Test
	public final void insert1N() {
		al.insert("aaa");
		assertEquals("insert 1 fail", "[aaa]", al.toString());
	}
	
	/**
	 * test insert by insert 3 elements
	 */
	@Test
	public final void insert3N() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		assertEquals("insert 3 fail", "[aaa, bbb, ccc]", al.toString());
	}
	
	/**
	 * test insert by insert 205 elements
	 */
	@Test
	public final void insert205() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		
		String str = "[str0";
		for (int i = 1; i < 205; i++)
			str += ", str" + i;
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
		al.insert("aaa");
		al.clear();
		assertEquals("clear 1 fail", "[]", al.toString());
	}
	
	/**
	 * test clear by clear a 3 elements list
	 */
	@Test
	public final void clear3N() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.clear();
		assertEquals("clear 3 fail", "[]", al.toString());
	}
	
	/**
	 * test clear by clear a 205 elements list
	 */
	@Test
	public final void clear205() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		al.clear();
		assertEquals("clear 205 fail", "[]", al.toString());
	}
	
	/**
	 * test remove by remove exist element from 1 element list
	 */
	@Test
	public final void remove0True() {
		
		al.insert("aaa");
		al.remove("aaa");
		assertEquals("remove 0 True fail", "[]", al.toString());
		
	}
	
	/**
	 * test remove by remove not exist element from 1 element list
	 */
	@Test
	public final void remove0False() {		
		al.insert("aaa");
		al.remove("bbb");
		assertEquals("remove 0 False fail", "[aaa]", al.toString());	
	}
	
	/**
	 * test remove by remove exist element from 5 elements list
	 */
	@Test
	public final void remove5TrueN() {		
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.remove("ccc");
		assertEquals("remove 5 True fail", "[aaa, bbb, eee, ddd]", al.toString());	
	}
	
	/**
	 * test remove by remove NOT exist element from 5 elements list
	 */
	@Test
	public final void remove5False() {		
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.remove("fff");
		assertEquals("remove 5 False fail", "[aaa, bbb, ccc, ddd, eee]", al.toString());	
	}
	
	/**
	 * test remove by remove head element from 5 elements list
	 */
	@Test
	public final void remove5HeadNext() {		
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.remove("bbb");
		assertEquals("remove 5 head next fail", "[aaa, eee, ccc, ddd]", al.toString());	
	}
	
	/**
	 * test remove by remove tail element from 5 elements list
	 */
	@Test
	public final void remove5TailNext() {		
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.remove("ddd");
		assertEquals("remove 5 tail next fail", "[aaa, bbb, ccc, eee]", al.toString());	
	}
	
	/**
	 * test remove by remove head element from 205 elements list
	 */
	@Test
	public final void remove205Head() {		
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		al.remove("str0");
		
		String str = "[str204";
		for (int i = 1; i < 204; i++) {
			str += ", str" + i;
		}
		str += "]";
		
		assertEquals("remove 205 head fail", str, al.toString());	
	}
	
	/**
	 * test remove by remove tail element from 205 elements list
	 */
	@Test
	public final void remove205Tail() {		
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		al.remove("str204");
		
		String str = "[str0";
		for (int i = 1; i < 204; i++) {
				str += ", str" + i;
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
			al.insert("str" + i);
		al.remove("str101");
		
		String str = "[str0";
		
		for (int i = 1; i < 101; i++) {
			str += ", str" + i;
		}
		
		str += ", str204";
		
		for (int i = 102; i < 204; i++) {
			str += ", str" + i;
		}
		
		
		str += "]";
		
		assertEquals("remove 205 middle fail", str, al.toString());	
	}
	
	/**
	 * test getIndex by get NOT exist element
	 */
	@Test
	public final void getIndex0() {		
		assertEquals("get 0 index fail", -1, al.getIndex("aaa"));	
	}
	
	/**
	 * test getIndex by get exist element from 1 element list
	 */
	@Test
	public final void getIndex1TrueN() {	
		al.insert("aaa");
		assertEquals("get 1 index True fail", 0, al.getIndex("aaa"));	
	}
	
	/**
	 * test getIndex by get NOT exist element from 1 element list
	 */
	@Test
	public final void getIndex1FalseN() {
		al.insert("aaa");
		assertEquals("get 1 index False fail", -1, al.getIndex("bbb"));	
	}
	
	/**
	 * test getIndex by get head element from 205 elements list
	 */
	@Test
	public final void getIndex205Head() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		assertEquals("get 205 index head fail", 0, al.getIndex("str0"));	
	}
	
	/**
	 * test getIndex by get tail element from 205 elements list
	 */
	@Test
	public final void getIndex205Tail() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		assertEquals("get 1 index tail fail", 204, al.getIndex("str204"));	
	}
	
	/**
	 * test getIndex by get NOT exist element from 205 elements list
	 */
	@Test
	public final void getIndex205False() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		assertEquals("get 1 index False fail", -1, al.getIndex("str-1"));	
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
		al.insert("aaa");
		al.removeAtIndex(1);
	}
	
	/**
	 * test removeAtIndex by remove 0 index from 1 element list
	 */
	@Test
	public final void removeAtIndex0() {
		al.insert("aaa");
		al.removeAtIndex(0);
		assertEquals("removeAtIndex 0 fail", "[]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove head from 2 elements list
	 */
	@Test
	public final void removeAtIndex2Head() {
		al.insert("aaa");
		al.insert("bbb");
		al.removeAtIndex(0);
		assertEquals("removeAtIndex 2 tail fail", "[bbb]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove tail from 2 elements list
	 */
	@Test
	public final void removeAtIndex2Tail() {
		al.insert("aaa");
		al.insert("bbb");
		al.removeAtIndex(1);
		assertEquals("removeAtIndex 2 tail fail", "[aaa]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove position one next to head from 5 elements list
	 */
	@Test
	public final void removeAtIndex5HeadNextN() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.removeAtIndex(1);
		assertEquals("removeAtIndex 5 head next fail", "[aaa, eee, ccc, ddd]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove position one next to tail from 5 elements list
	 */
	@Test
	public final void removeAtIndex5TailNextN() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.removeAtIndex(3);
		assertEquals("removeAtIndex 5 tail next fail", "[aaa, bbb, ccc, eee]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove head from 205 elements list
	 */
	@Test
	public final void removeAtIndex205Head() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		al.removeAtIndex(0);
		String str = "[str204";
		for (int i = 1; i < 204; i++)
			str += ", str" + i;
		str += "]";
		
		
		assertEquals("removeAtIndex 205 head fail", str, al.toString());
	}
	
	/**
	 * test removeAtIndex by remove tail from 205 elements list
	 */
	@Test
	public final void removeAtIndex205Tail() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		al.removeAtIndex(204);
		String str = "[str0";
		for (int i = 1; i < 204; i++)
			str += ", str" + i;
		str += "]";
		assertEquals("removeAtIndex 205 tail fail", str, al.toString());
	}
	
	/**
	 * test removeAtIndex by remove middle from 205 elements list
	 */
	@Test
	public final void removeAtIndex205Middle() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		al.removeAtIndex(101);
//		String str = "[str0";
//		for (int i = 1; i < 205; i++) {
//			if (i != 101) {
//				str += ", str" + i;
//			}
//		}
//		str += "]";
		String str = "[str0";
//		for (int i = 0; i < 205; i++) {
//			if (i != 101)
//				str += ", str" + i;
//		}
		
		for (int i = 1; i < 101; i++) {
			str += ", str" + i;
		}
		
		str += ", str204";
		
		for (int i = 102; i < 204; i++) {
			str += ", str" + i;
		}
		
		
		str += "]";
		
		assertEquals("removeAtIndex 205 middle fail", str, al.toString());
	}
	
	/**
	 * test set by set negative index in an empty list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void setNegative() {
		al.set(-1, "aaa");
	}
	
	/**
	 * test set by set 0 index in an empty list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void set0False() {
		al.set(0, "aaa");
	}
	
	/**
	 * test set by set out of bound index in a 1 element list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void set1False() {
		al.insert("aaa");
		al.set(1, "bbb");
	}
	
	/**
	 * test set by set 0 index in a 1 element list
	 */
	@Test
	public final void set1() {
		al.insert("aaa");
		al.set(0, "bbb");
		assertEquals("set 1 fail", "[bbb]", al.toString());
	}
	
	/**
	 * test set by set one next to head index in a 5 elements list
	 */
	@Test
	public final void set5HeadNextN() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.set(1, "fff");
		assertEquals("set 5 head next fail", "[aaa, fff, ccc, ddd, eee]", al.toString());
	}
	
	/**
	 * test set by set one next to tail index in a 5 elements list
	 */
	@Test
	public final void set5TailNextN() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.set(3, "fff");
		assertEquals("set 5 tail next fail", "[aaa, bbb, ccc, fff, eee]", al.toString());
	}
	
	/**
	 * test set by set head index in a 205 elements list
	 */
	@Test 
	public final void set205Head() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		al.set(0, "new");
		
		String str = "[new";
		for (int i = 1; i < 205; i++) {
			str += ", str" + i;
		}
		str += "]";
		
		assertEquals("set 205 head fail", str, al.toString());
	}
	
	/**
	 * test set by set tail index in a 205 elements list
	 */
	@Test 
	public final void set205Tail() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		al.set(204, "new");
		String str = "[str0";
		for (int i = 1; i < 204; i++) {
				str += ", str" + i;	
		}
		str += ", new]";
		assertEquals("set 205 tail fail", str, al.toString());
	}
	
	/**
	 * test set by set middle index in a 205 elements list
	 */
	@Test 
	public final void set205Middle() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		al.set(101, "new");
		
		String str = "[str0";
		for (int i = 1; i < 205; i++) {
			if (i == 101)
				str += ", new";
			else
				str += ", str" + i;
			
		}
		str += "]";
		assertEquals("set 205 middle fail", str, al.toString());
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
		al.insert("aaa");
		al.get(1);
	}
	
	/**
	 * test get by get 0 index from a 1 element list
	 */
	@Test
	public final void get1N() {
		al.insert("aaa");
		assertEquals("get 1 fail", "aaa", al.get(0));
	}
	
	/**
	 * test get by get head index from a 2 elements list
	 */
	@Test
	public final void get2Head() {
		al.insert("aaa");
		al.insert("bbb");
		assertEquals("get 2 head fail", "aaa", al.get(0));
	}
	
	/**
	 * test get by get tail index from a 2 elements list
	 */
	@Test
	public final void get2Tail() {
		al.insert("aaa");
		al.insert("bbb");
		assertEquals("get 2 tail fail", "bbb", al.get(1));
	}

	/**
	 * test get by get one next to head index from a 5 elements list
	 */
	@Test
	public final void get5HeadNextN() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		assertEquals("get 5 head next fail", "bbb", al.get(1));
	}
	
	/**
	 * test get by get one next to tail index from a 5 elements list
	 */
	@Test
	public final void get5TailNextN() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		assertEquals("get 5 tail next fail", "ddd", al.get(3));
	}
	
	/**
	 * test get by get head index from a 205 elements list
	 */
	@Test
	public final void get205Head() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		assertEquals("get 205 head fail", "str0", al.get(0));
	}

	/**
	 * test get by get tail index from a 205 elements list
	 */
	@Test
	public final void get205Tail() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		assertEquals("get 205 tail fail", "str204", al.get(204));
	}

	/**
	 * test get by get middle index from a 205 elements list
	 */
	@Test
	public final void get205Middle() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		assertEquals("get 205 middle fail", "str101", al.get(101));
	}
	
	/**
	 * test iterator by iterate empty list
	 */
	@Test
	public final void iterator0() {
		Iterator<String> itr = al.iterator();
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
		al.insert("aaa");
		Iterator<String> itr = al.iterator();
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
			al.insert("str" + i);
		Iterator<String> itr = al.iterator();
		String str = "[" + itr.next();
		while (itr.hasNext()) {
			str += ", " + itr.next();
		}
		str += "]";
		System.out.println(str);
		assertEquals("iterator 205 fail", str, al.toString());
	}
	
	/**
	 * test remove method of iterator
	 */
	@Test
	public final void iteratorRemove() {
		for (int i = 0; i < 205; i++)
			al.insert("str" + i);
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			String temp = itr.next();
			if (temp.equals("str101"))
				itr.remove();
		}
		
		itr = al.iterator();
		// expected
		String str = "[" + "str0";
		for (int i = 1; i < 101; i++) {
			str += ", str" + i;
		}
		for (int i = 102; i < 205; i++) {
			str += ", str" + i;
		}
		str += "]";
		
		
		String testStr = "[str0";
		for (int i = 1; i < 205; i++) {
			if (i != 101)
				testStr += ", str" + i;
		}
		testStr += "]";
		
		assertEquals("iterator remove fail", str, testStr);
	}
	
	/**
	 * Test when capacity of a bag > default and less than 1/4 of the current
	 * capacity is used, the array is shrunk either half of its current 
     * capacity (if half capacity > default capacity).    
	 */
	@Test
	public final void testShrunkDeleteMethod1() {
		// insert 400 elements 
		for (int i = 0; i < 400; i++) {
			bl.insert("str " + i);
		}	
		// remove 251 elements
		// In this case, the capacity becomes 600, so we are going to shrunk the array to half.
		for (int i = 0; i < 251; i++) {
			bl.remove("str " + i);
		}		
		assertEquals("shrunk fail when remove", 300, bl.getCapacity());


	}
	
	/**
	 * Test when capacity of a bag > default and less than 1/4 of the current
	 * capacity is used, the array is shrunk either half of its current 
     * capacity (if half capacity > default capacity).    
	 */
	@Test
	public final void testShrunkDeleteMethod2() { 
		// insert 199 elements 
		for (int i = 0; i < 199; i++) {
			cl.insert("str " + i);
		}	
		// remove 190 elements
		// In this case, the capacity is 200, so we are going to shrunk the array to default.
		for (int i = 0; i < 190; i++) {
			cl.remove("str " + i);
		}	
		assertEquals("shrunk fail when remove", 150, bl.getCapacity());
		
	}
}

