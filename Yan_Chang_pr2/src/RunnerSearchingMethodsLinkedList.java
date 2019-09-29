import java.util.Date;
/**
 * Runner class for linear search and binary search of linked list.
 * 
 * @author Chang Yan
 * @version April 2019
 */
public class RunnerSearchingMethodsLinkedList {

	private static LinkedListUnsorted<Integer> mylist;
	final private static int LOW = 25000;
	final private static int MED = 100000;
	final private static int HIMED = 250000;
	final private static int HI = 500000;

	// best case
	public static void linearSearchLinkedFirstElement(int capacity) {
		mylist = new LinkedListUnsorted<Integer>();
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
	public static void linearSearchLinkedMiddleElement(int capacity) {
		mylist = new LinkedListUnsorted<Integer>();
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
	public static void linearSearchLinkedResultNotFound(int capacity) {
		mylist = new LinkedListUnsorted<Integer>();
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
	public static void binarySearchLinkedFirstElement(int capacity) {
		mylist = new LinkedListUnsorted<Integer>();
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
	public static void binarySearchLinkedMiddleElement(int capacity) {
		mylist = new LinkedListUnsorted<Integer>();
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
	public static void binarySearchLinkedResultNotFound(int capacity) {
		mylist = new LinkedListUnsorted<Integer>();
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
			linearSearchLinkedFirstElement(LOW);
			linearSearchLinkedFirstElement(MED);
			linearSearchLinkedFirstElement(HIMED);
			linearSearchLinkedFirstElement(HI);
		}
		System.out.println("Label: Linear Search of finding the middle element");
		for (int i = 0; i < 3; i++) {
			linearSearchLinkedMiddleElement(LOW);
			linearSearchLinkedMiddleElement(MED);
			linearSearchLinkedMiddleElement(HIMED);
			linearSearchLinkedMiddleElement(HI);
		}		
		System.out.println("Label: Linear Search of finding a non-existing element");
		for (int i = 0; i < 3; i++) {
			linearSearchLinkedResultNotFound(LOW);
			linearSearchLinkedResultNotFound(MED);
			linearSearchLinkedResultNotFound(HIMED);
			linearSearchLinkedResultNotFound(HI);
		}
		System.out.println("Label: Binary Search of finding the first element");
		for (int i = 0; i < 3; i++) {
			binarySearchLinkedFirstElement(LOW);
			binarySearchLinkedFirstElement(MED);
			binarySearchLinkedFirstElement(HIMED);
			binarySearchLinkedFirstElement(HI);
		}
		System.out.println("Label: Binary Search of finding the middle element");
		for (int i = 0; i < 3; i++) {
			binarySearchLinkedMiddleElement(LOW);
			binarySearchLinkedMiddleElement(MED);
			binarySearchLinkedMiddleElement(HIMED);
			binarySearchLinkedMiddleElement(HI);
		}
		System.out.println("Label: Binary Search of finding a non-existing element");
		for (int i = 0; i < 3; i++) {
			binarySearchLinkedResultNotFound(LOW);
			binarySearchLinkedResultNotFound(MED);
			binarySearchLinkedResultNotFound(HIMED);
			binarySearchLinkedResultNotFound(HI);
		}
	}
}
