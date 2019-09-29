package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import mybagpackage.OtherBagUnsorted;

import org.junit.Before;
import org.junit.Test;


/**
 * JUnit test of ArrayListUnsorted
 * @author Kaiyaun Shi, Monika, Chang Yan(Charlotte)
 * @version Spring 2019
 */
public class OtherBagUnsortedTest {

	private OtherBagUnsorted<String> al;//array list

	@Before
	public final void setup() {
		al = new OtherBagUnsorted<String>();
		
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
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);		
		assertEquals("size 3 fail", 3, al.getSize());	
	}

	/**
	 * test getSize with 205 elements
	 */
	@Test
	public final void getSize205() {	
		for (int i = 0; i < 205; i++) {
			String[] str = {"a", "b", "c", "d", "e"};
			al.insert(str);
		}		
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
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		assertFalse("3 empty fail", al.isEmpty());
	}

	/**
	 * test isEmpty with 205 elements
	 */
	@Test
	public final void isEmpty205() {
		for (int i = 0; i < 205; i++) {
			String[] str = {"a", "b", "c", "d", "e"};
			al.insert(str);
		}
		assertFalse("205 empty fail", al.isEmpty());
	}
	
	/**
	 * test contains with empty list
	 */
	@Test
	public final void containEmpty() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		assertFalse("contain empty fail", al.contains(str1));
	}

	/**
	 * test contains with 1 element and it exists in the list
	 */
	@Test
	public final void contain1TN() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.insert(str1);
		assertTrue("contain 1 true fail", al.contains(str1));
	}
	
	/**
	 * test contains with 1 element and it does NOT exist in the list
	 */
	@Test
	public final void contain1FN() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		al.insert(str1);
		assertFalse("contain 1 false fail", al.contains(str2));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the head of the list
	 */
	@Test
	public final void arrayContain2HT() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		al.insert(str1);
		al.insert(str2);
		assertTrue("contain 2 head true fail", al.contains(str1));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the tail of the list
	 */
	@Test
	public final void arrayContain2TT() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		al.insert(str1);
		al.insert(str2);
		assertTrue("contain 2 tail true fail", al.contains(str2));
	}
	
	/**
	 * test contains with 2 elements list and element does NOT exist
	 */
	@Test
	public final void arrayContain2F() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		al.insert(str1);
		al.insert(str2);
		assertFalse("contain 2 false fail", al.contains(str3));
	}
	
	/**
	 * test contains with 205 elements list and element exist at the head of the list
	 */
	@Test
	public final void arrayContain205HT() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] res = {"str0", "str0", "str0", "str0", "str0"};
		assertTrue("contain 205 head true fail", al.contains(res));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the tail of the list
	 */
	@Test
	public final void arrayContain205TT() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] res = {"str204", "str204", "str204", "str204", "str204"};
		assertTrue("contain 205 tail true fail", al.contains(res));
	}
	
	/**
	 * test contains with 205 elements list and element does NOT exist
	 */
	@Test
	public final void arrayContain205F() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] res = {"str", "str", "str", "str", "str"};
		assertFalse("contain 205 false fail", al.contains(res));
	}
	
	/**
	 * test insert by insert 1 element
	 */
	@Test
	public final void insert1N() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.insert(str1);
		assertEquals("insert 1 fail", "[a, b, c, d, e]", al.toString());
	}
	
	/**
	 * test insert by insert 3 elements
	 */
	@Test
	public final void insert3N() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		assertEquals("insert 3 fail", "[a, b, c, d, e], [aa, bb, cc, dd, ee]"
				+ ", [aaa, bbb, ccc, ddd, eee]", al.toString());
	}
	
	/**
	 * test insert by insert 205 elements
	 */
	@Test
	public final void insert205() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		
		String str = "";
		for (int i = 0; i < 205; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i;
			if (i < 204) 
				str += "], ";
			if (i == 204)
				str += "]";
		}
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
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.insert(str1);
		al.clear();
		assertEquals("clear 1 fail", "[]", al.toString());
	}
	
	/**
	 * test clear by clear a 3 elements list
	 */
	@Test
	public final void clear3N() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.clear();
		assertEquals("clear 3 fail", "[]", al.toString());
	}
	
	/**
	 * test clear by clear a 205 elements list
	 */
	@Test
	public final void clear205() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		al.clear();
		assertEquals("clear 205 fail", "[]", al.toString());
	}
	
	/**
	 * test remove by remove exist element from 1 element list
	 */
	@Test
	public final void remove0True() {
		
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.insert(str1);
		al.remove(str1);
		assertEquals("remove 0 True fail", "[]", al.toString());
		
	}
	
	/**
	 * test remove by remove not exist element from 1 element list
	 */
	@Test
	public final void remove0False() {		
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		al.insert(str1);
		al.remove(str2);
		assertEquals("remove 0 False fail", Arrays.toString(str1), al.toString());	
	}
	
	/**
	 * test remove by remove exist element from 5 elements list
	 */
	@Test
	public final void remove5TrueN() {		
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		String[] str4 = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
		String[] str5 = {"aaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.insert(str4);
		al.insert(str5);
		
		al.remove(str3);
		
		String res = Arrays.toString(str1) + ", " + Arrays.toString(str2) + ", " +
				Arrays.toString(str4) + ", " + Arrays.toString(str5);
		assertEquals("remove 5 True fail", res, al.toString());	
	}
	
	/**
	 * test remove by remove NOT exist element from 5 elements list
	 */
	@Test
	public final void remove5False() {		
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		String[] str4 = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
		String[] str5 = {"aaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};
		String[] str6 = {"1", "2", "3", "4", "5"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.insert(str4);
		al.insert(str5);
		
		String res = Arrays.toString(str1) + ", " + Arrays.toString(str2) + ", " +
				Arrays.toString(str3) + ", " + Arrays.toString(str4) + ", " 
				+ Arrays.toString(str5);
		
		al.remove(str6);
		assertEquals("remove 5 False fail", res, al.toString());	
	}
	
	/**
	 * test remove by remove head element from 5 elements list
	 */
	@Test
	public final void remove5HeadNext() {		
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		String[] str4 = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
		String[] str5 = {"aaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.insert(str4);
		al.insert(str5);
		
		String res = Arrays.toString(str1) + ", " +
				Arrays.toString(str3) + ", " + Arrays.toString(str4) + ", " 
				+ Arrays.toString(str5);
		
		al.remove(str2);
		
		assertEquals("remove 5 head next fail", res, al.toString());	
	}
	
	/**
	 * test remove by remove tail element from 5 elements list
	 */
	@Test
	public final void remove5TailNext() {		
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		String[] str4 = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
		String[] str5 = {"aaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.insert(str4);
		al.insert(str5);
		
		String res = Arrays.toString(str1) + ", " +
				Arrays.toString(str2) + ", " + Arrays.toString(str3) + ", " 
				+ Arrays.toString(str5);
		
		al.remove(str4);
		
		assertEquals("remove 5 tail next fail", res, al.toString());	
	}
	
	/**
	 * test remove by remove head element from 205 elements list
	 */
	@Test
	public final void remove205Head() {	
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] removeStr = {"str0", "str0", "str0", "str0", "str0"};
		al.remove(removeStr);
		
		String str = "";
		for (int i = 1; i < 205; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i;
			if (i < 204) 
				str += "], ";
			if (i == 204)
				str += "]";
		}	
		assertEquals("remove 205 head fail", str, al.toString());	
	}
	
	
	/**
	 * test remove by remove tail element from 205 elements list
	 */
	@Test
	public final void remove205Tail() {		
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] removeStr = {"str204", "str204", "str204", "str204", "str204"};
		al.remove(removeStr);
		
		String str = "";
		for (int i = 0; i < 204; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i;
			if (i < 203) 
				str += "], ";
			if (i == 203)
				str += "]";
		}		
		assertEquals("remove 205 tail fail", str, al.toString());	
	}
	
	/**
	 * test remove by remove middle element from 205 elements list
	 */
	@Test
	public final void remove205Middle() {		
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] removeStr = {"str102", "str102", "str102", "str102", "str102"};
		al.remove(removeStr);
		
		String str = "";
		for (int i = 0; i < 102; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i + "], ";
		}	
		for (int i = 103; i < 205; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i;
			if (i > 102 && i != 204) 
				str += "], ";
			if (i == 204)
				str += "]";
		}
		
		assertEquals("remove 205 middle fail", str, al.toString());	
	}
	
	/**
	 * test getIndex by get NOT exist element
	 */
	@Test
	public final void getIndex0() {		
		String[] str1 = {"a", "b", "c", "d", "e"};
		assertEquals("get 0 index fail", -1, al.getIndex(str1));	
	}
	
	/**
	 * test getIndex by get exist element from 1 element list
	 */
	@Test
	public final void getIndex1TrueN() {	
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.insert(str1);
		assertEquals("get 1 index True fail", 0, al.getIndex(str1));	
	}
	
	/**
	 * test getIndex by get NOT exist element from 1 element list
	 */
	@Test
	public final void getIndex1FalseN() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.insert(str1);
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		assertEquals("get 1 index False fail", -1, al.getIndex(str2));	
	}
	
	/**
	 * test getIndex by get head element from 205 elements list
	 */
	@Test
	public final void getIndex205Head() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] str = {"str0", "str0", "str0", "str0", "str0"};
		assertEquals("get 205 index head fail", 0, al.getIndex(str));	
	}
	
	/**
	 * test getIndex by get tail element from 205 elements list
	 */
	@Test
	public final void getIndex205Tail() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] str = {"str204", "str204", "str204", "str204", "str204"};
		assertEquals("get 1 index tail fail", 204, al.getIndex(str));	
	}
	
	/**
	 * test getIndex by get NOT exist element from 205 elements list
	 */
	@Test
	public final void getIndex205False() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] str = {"str-1", "str-1", "str-1", "str-1", "str-1"};
		assertEquals("get 1 index False fail", -1, al.getIndex(str));	
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
		String[] str = {"str-1", "str-1", "str-1", "str-1", "str-1"};
		al.insert(str);
		al.removeAtIndex(1);
	}
	
	/**
	 * test removeAtIndex by remove 0 index from 1 element list
	 */
	@Test
	public final void removeAtIndex0() {
		String[] str = {"str-1", "str-1", "str-1", "str-1", "str-1"};
		al.insert(str);
		al.removeAtIndex(0);
		assertEquals("removeAtIndex 0 fail", "[]", al.toString());
	}
	
	/**
	 * test removeAtIndex by remove head from 2 elements list
	 */
	@Test
	public final void removeAtIndex2Head() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		al.insert(str1);
		al.insert(str2);
		al.removeAtIndex(0);
		assertEquals("removeAtIndex 2 tail fail", Arrays.toString(str2), al.toString());
	}
	
	/**
	 * test removeAtIndex by remove tail from 2 elements list
	 */
	@Test
	public final void removeAtIndex2Tail() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		al.insert(str1);
		al.insert(str2);
		al.removeAtIndex(1);
		assertEquals("removeAtIndex 2 tail fail", Arrays.toString(str1), al.toString());
	}
	
	/**
	 * test removeAtIndex by remove position one next to head from 5 elements list
	 */
	@Test
	public final void removeAtIndex5HeadNextN() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		String[] str4 = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
		String[] str5 = {"aaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.insert(str4);
		al.insert(str5);
		
		String res = Arrays.toString(str1) + ", " +
				Arrays.toString(str3) + ", " + Arrays.toString(str4) + ", " 
				+ Arrays.toString(str5);
		
		al.removeAtIndex(1);
		assertEquals("removeAtIndex 5 head next fail", res, al.toString());
	}
	
	/**
	 * test removeAtIndex by remove position one next to tail from 5 elements list
	 */
	@Test
	public final void removeAtIndex5TailNextN() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		String[] str4 = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
		String[] str5 = {"aaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.insert(str4);
		al.insert(str5);
		
		String res = Arrays.toString(str1) + ", " +
				Arrays.toString(str2) + ", " + Arrays.toString(str3) + ", " 
				+ Arrays.toString(str5);
		
		al.removeAtIndex(3);
		assertEquals("removeAtIndex 5 tail next fail", res, al.toString());
	}
	
	/**
	 * test removeAtIndex by remove head from 205 elements list
	 */
	@Test
	public final void removeAtIndex205Head() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}

		al.removeAtIndex(0);
		
		String str = "";
		for (int i = 1; i < 205; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i;
			if (i < 204) 
				str += "], ";
			if (i == 204)
				str += "]";
		}	
		
		
		assertEquals("removeAtIndex 205 head fail", str, al.toString());
	}
	
	/**
	 * test removeAtIndex by remove tail from 205 elements list
	 */
	@Test
	public final void removeAtIndex205Tail() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		al.removeAtIndex(204);
		
		String str = "";
		for (int i = 0; i < 204; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i;
			if (i < 203) 
				str += "], ";
			if (i == 203)
				str += "]";
		}	
		
		assertEquals("removeAtIndex 205 tail fail", str, al.toString());
	}
	
	/**
	 * test removeAtIndex by remove middle from 205 elements list
	 */
	@Test
	public final void removeAtIndex205Middle() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		
		al.removeAtIndex(102);
		
		String str = "";
		for (int i = 0; i < 102; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i + "], ";
		}	
		for (int i = 103; i < 205; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i;
			if (i > 102 && i != 204) 
				str += "], ";
			if (i == 204)
				str += "]";
		}
		
		assertEquals("removeAtIndex 205 middle fail", str, al.toString());
	}
	
	/**
	 * test set by set negative index in an empty list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void setNegative() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.set(-1, str1);
	}
	
	/**
	 * test set by set 0 index in an empty list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void set0False() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.set(0, str1);
	}
	
	/**
	 * test set by set out of bound index in a 1 element list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void set1False() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		al.insert(str1);
		al.set(1, str2);
	}
	
	/**
	 * test set by set 0 index in a 1 element list
	 */
	@Test
	public final void set1() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		al.insert(str1);
		al.set(0, str2);
		assertEquals("set 1 fail", Arrays.toString(str2), al.toString());
	}
	
	/**
	 * test set by set one next to head index in a 5 elements list
	 */
	@Test
	public final void set5HeadNextN() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		String[] str4 = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
		String[] str5 = {"aaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};
		String[] str6 = {"1", "2", "3", "4", "5"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.insert(str4);
		al.insert(str5);
		
		String res = Arrays.toString(str1) + ", " +
				Arrays.toString(str6) + ", " + Arrays.toString(str3) + ", "
						+ Arrays.toString(str4) + ", "
				+ Arrays.toString(str5);
		
		al.set(1, str6);
		assertEquals("set 5 head next fail", res, al.toString());
	}
	
	/**
	 * test set by set one next to tail index in a 5 elements list
	 */
	@Test
	public final void set5TailNextN() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		String[] str4 = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
		String[] str5 = {"aaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};
		String[] str6 = {"1", "2", "3", "4", "5"};
		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.insert(str4);
		al.insert(str5);
		
		String res = Arrays.toString(str1) + ", " +
				Arrays.toString(str2) + ", " + Arrays.toString(str3) + ", "
						+ Arrays.toString(str6) + ", "
				+ Arrays.toString(str5);
		al.set(3, str6);
		assertEquals("set 5 tail next fail", res, al.toString());
	}
	
	/**
	 * test set by set head index in a 205 elements list
	 */
	@Test 
	public final void set205Head() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.set(0, str1);
		
		String str = Arrays.toString(str1) + ", ";
		for (int i = 1; i < 205; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i;
			if (i < 204) 
				str += "], ";
			if (i == 204)
				str += "]";
		}	
		
		assertEquals("set 205 head fail", str, al.toString());
	}
	
	/**
	 * test set by set tail index in a 205 elements list
	 */
	@Test 
	public final void set205Tail() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.set(204, str1);
		
		String str = "";
		for (int i = 0; i < 204; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i;
			if (i < 203) 
				str += "], ";
			if (i == 203)
				str += "]";
		}	
		str += ", " + Arrays.toString(str1);
			
		assertEquals("set 205 tail fail", str, al.toString());
	}
	
	/**
	 * test set by set middle index in a 205 elements list
	 */
	@Test 
	public final void set205Middle() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.set(102, str1);
		
		String str = "";
		for (int i = 0; i < 102; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i + "], ";
		}	
		str +=  Arrays.toString(str1) + ", ";
		for (int i = 103; i < 205; i++) {
			str += "[";
			for (int j = 0; j < 4; j++) {
				str += "str" + i + ", ";
			}
			str += "str" + i;
			if (i > 102 && i != 204) 
				str += "], ";
			if (i == 204)
				str += "]";
		}

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
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.insert(str1);
		al.get(1);
	}
	
	/**
	 * test get by get 0 index from a 1 element list
	 */
	@Test
	public final void get1N() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		al.insert(str1);
		assertEquals("get 1 fail", "[a, b, c, d, e]", Arrays.toString(al.get(0)));
	}
	
	/**
	 * test get by get head index from a 2 elements list
	 */
	@Test
	public final void get2Head() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};

		al.insert(str1);
		al.insert(str2);

		assertEquals("get 2 head fail", "[a, b, c, d, e]", Arrays.toString(al.get(0)));
	}
	
	/**
	 * test get by get tail index from a 2 elements list
	 */
	@Test
	public final void get2Tail() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};

		al.insert(str1);
		al.insert(str2);
		assertEquals("get 2 tail fail", Arrays.toString(str1), Arrays.toString(al.get(0)));
	}

	/**
	 * test get by get one next to head index from a 5 elements list
	 */
	@Test
	public final void get5HeadNextN() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		String[] str4 = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
		String[] str5 = {"aaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};

		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.insert(str4);
		al.insert(str5);
		
		assertEquals("get 5 head next fail", Arrays.toString(str2), Arrays.toString(al.get(1)));
	}
	
	/**
	 * test get by get one next to tail index from a 5 elements list
	 */
	@Test
	public final void get5TailNextN() {
		String[] str1 = {"a", "b", "c", "d", "e"};
		String[] str2 = {"aa", "bb", "cc", "dd", "ee"};
		String[] str3 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		String[] str4 = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
		String[] str5 = {"aaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};

		al.insert(str1);
		al.insert(str2);
		al.insert(str3);
		al.insert(str4);
		al.insert(str5);
		
		assertEquals("get 5 tail next fail", Arrays.toString(str4), Arrays.toString(al.get(3)));
	}
	
	/**
	 * test get by get head index from a 205 elements list
	 */
	@Test
	public final void get205Head() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		
		String[] str1 = {"str0", "str0", "str0", "str0", "str0"};	
		
		assertEquals("get 205 head fail", Arrays.toString(str1), Arrays.toString(al.get(0)));
	}

	/**
	 * test get by get tail index from a 205 elements list
	 */
	@Test
	public final void get205Tail() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] str1 = {"str204", "str204", "str204", "str204", "str204"};	
		assertEquals("get 205 tail fail", Arrays.toString(str1), Arrays.toString(al.get(204)));
	}

	/**
	 * test get by get middle index from a 205 elements list
	 */
	@Test
	public final void get205Middle() {
		for (int i = 0; i < 205; i++) {
			String s = "str" + i;
			String[] str = {s, s, s, s, s};
			al.insert(str);
		}
		String[] str1 = {"str102", "str102", "str102", "str102", "str102"};	
		assertEquals("get 205 middle fail", Arrays.toString(str1), Arrays.toString(al.get(102)));
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
	
//	/**
//	 * test iterator by iterate 1 element list
//	 */
//	@Test
//	public final void iterator1N() {
//		String[] str1 = {"a", "b", "c", "d", "e"};
//		al.insert(str1);
//		Iterator<String> itr = al.iterator();
//		String str = "[" + itr.next();
//		while (itr.hasNext()) {
//			str += ", " + itr.next();
//		}
//		str += "]";
//		assertEquals("iterator 1 fail", str, al.toString());
//	}
//	
//	/**
//	 * test iterator by iterate 205 elements list
//	 */
//	@Test
//	public final void iterator205() {
//		for (int i = 0; i < 205; i++)
//			al.insert("str" + i);
//		Iterator<String> itr = al.iterator();
//		String str = "[" + itr.next();
//		while (itr.hasNext()) {
//			str += ", " + itr.next();
//		}
//		str += "]";
//		assertEquals("iterator 205 fail", str, al.toString());
//	}
//	
//	/**
//	 * test remove method of iterator
//	 */
//	@Test
//	public final void iteratorRemove() {
//		for (int i = 0; i < 205; i++)
//			al.insert("str" + i);
//		Iterator<String> itr = al.iterator();
//		while (itr.hasNext()) {
//			String temp = itr.next();
//			if (temp.equals("str101"))
//				itr.remove();
//		}
//		
//		itr = al.iterator();
//		// expected
//		String str = "[" + "str0";
//		for (int i = 1; i < 101; i++) {
//			str += ", str" + i;
//		}
//		for (int i = 102; i < 205; i++) {
//			str += ", str" + i;
//		}
//		str += "]";
//		
//		
//		String testStr = "[str0";
//		for (int i = 1; i < 205; i++) {
//			if (i != 101)
//				testStr += ", str" + i;
//		}
//		testStr += "]";
//		
//		assertEquals("iterator remove fail", str, testStr);
//	}
//	
//	
//	/**
//	 * test NoSuchElementException in iterator next().
//	 */
//	@Test (expected = NoSuchElementException.class)
//	public final void iterator205Exception() {
//		for (int i = 0; i < 205; i++)
//			al.insert("str" + i);
//		Iterator<String> itr = al.iterator();
//		for (int i = 0; i < 206; i++) {
//			itr.next();
//		}
//	}
}

