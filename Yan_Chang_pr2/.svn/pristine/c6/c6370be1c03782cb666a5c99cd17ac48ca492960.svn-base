import java.util.Date;
/**
 * Runner class for linear search and binary search of array list.
 * 
 * @author Chang Yan
 * @version April 2019
 */
public class RunnerSearchingMethodsArrayList {
	
	private static ArrayListUnsorted<Integer> mylist;//array list
	final private static int LOW = 25000;
	final private static int MED = 100000;
	final private static int HIMED = 250000;
	final private static int HI = 500000;

	// best case
	public static void linearSearchArrFirstElement(int capacity) {
		mylist = new ArrayListUnsorted<Integer>(capacity);
		for (int i = 1; i <= capacity; i++)
			mylist.insert(i);
		Date startDate = new Date();
		long startTime = startDate.getTime();
		mylist.myLinearSearch(1);
		Date finishDate = new Date();
		long finishTime = finishDate.getTime();
		long totmylistTime = (finishTime - startTime);   
		System.out.println(capacity + "\t" + totmylistTime);      		
	}

	// average case
	public static void linearSearchArrMiddleElement(int capacity) {
		mylist = new ArrayListUnsorted<Integer>(capacity);
		for (int i = 1; i <= capacity; i++)
			mylist.insert(i);
		Date startDate = new Date();
		long startTime = startDate.getTime();
		mylist.myLinearSearch(capacity / 2);
		Date finishDate = new Date();
		long finishTime = finishDate.getTime();
		long totmylistTime = (finishTime - startTime);   
		System.out.println(capacity + "\t" + totmylistTime);      		
	}

	// worst case
	public static void linearSearchArrResultNotFound(int capacity) {
		mylist = new ArrayListUnsorted<Integer>(capacity);
		for (int i = 1; i <= capacity; i++)
			mylist.insert(i);
		Date startDate = new Date();
		long startTime = startDate.getTime();
		mylist.myLinearSearch(capacity + 1);
		Date finishDate = new Date();
		long finishTime = finishDate.getTime();
		long totmylistTime = (finishTime - startTime);   
		System.out.println(capacity + "\t" + totmylistTime);      		
	}

	// best case
	public static void binarySearchArrFirstElement(int capacity) {
		mylist = new ArrayListUnsorted<Integer>(capacity);
		for (int i = 1; i <= capacity; i++)
			mylist.insert(i);
		Date startDate = new Date();
		long startTime = startDate.getTime();
		mylist.mybinarySearch(1);
		Date finishDate = new Date();
		long finishTime = finishDate.getTime();
		long totmylistTime = (finishTime - startTime);   
		System.out.println(capacity + "\t" + totmylistTime);      		
	}
	
	// average case
	public static void binarySearchArrMiddleElement(int capacity) {
		mylist = new ArrayListUnsorted<Integer>(capacity);
		for (int i = 1; i <= capacity; i++)
			mylist.insert(i);
		Date startDate = new Date();
		long startTime = startDate.getTime();
		mylist.mybinarySearch(capacity / 2 - 1);
		Date finishDate = new Date();
		long finishTime = finishDate.getTime();
		long totmylistTime = (finishTime - startTime);   
		System.out.println(capacity + "\t" + totmylistTime);      		
	}
	
	// worst case
	public static void binarySearchArrResultNotFound(int capacity) {
		mylist = new ArrayListUnsorted<Integer>(capacity);
		for (int i = 1; i <= capacity; i++)
			mylist.insert(i);
		Date startDate = new Date();
		long startTime = startDate.getTime();
		mylist.mybinarySearch(capacity + 1);
		Date finishDate = new Date();
		long finishTime = finishDate.getTime();
		long totmylistTime = (finishTime - startTime);   
		System.out.println(capacity + "\t" + totmylistTime);      		
	}


	public static void main(String[] args) {
		System.out.println("Number of elements:\tTime to search (ms):");		
		System.out.println("Label: Linear Search of finding the first element");
		for (int i = 0; i < 3; i++) {
			linearSearchArrFirstElement(LOW);
			linearSearchArrFirstElement(MED);
			linearSearchArrFirstElement(HIMED);
			linearSearchArrFirstElement(HI);
		}
		System.out.println("Label: Linear Search of finding the middle element");
		for (int i = 0; i < 3; i++) {
			linearSearchArrMiddleElement(LOW);
			linearSearchArrMiddleElement(MED);
			linearSearchArrMiddleElement(HIMED);
			linearSearchArrMiddleElement(HI);
		}		
		System.out.println("Label: Linear Search of finding a non-existing element");
		for (int i = 0; i < 3; i++) {
			linearSearchArrResultNotFound(LOW);
			linearSearchArrResultNotFound(MED);
			linearSearchArrResultNotFound(HIMED);
			linearSearchArrResultNotFound(HI);
		}
		System.out.println("Label: Binary Search of finding the first element");
		for (int i = 0; i < 3; i++) {
			binarySearchArrFirstElement(LOW);
			binarySearchArrFirstElement(MED);
			binarySearchArrFirstElement(HIMED);
			binarySearchArrFirstElement(HI);
		}
		System.out.println("Label: Binary Search of finding the middle element");
		for (int i = 0; i < 3; i++) {
			binarySearchArrMiddleElement(LOW);
			binarySearchArrMiddleElement(MED);
			binarySearchArrMiddleElement(HIMED);
			binarySearchArrMiddleElement(HI);
		}
		System.out.println("Label: Binary Search of finding a non-existing element");
		for (int i = 0; i < 3; i++) {
			binarySearchArrResultNotFound(LOW);
			binarySearchArrResultNotFound(MED);
			binarySearchArrResultNotFound(HIMED);
			binarySearchArrResultNotFound(HI);
		}
	}
}
