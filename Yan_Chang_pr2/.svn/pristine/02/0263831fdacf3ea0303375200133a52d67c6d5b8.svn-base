
import java.util.Date;
import java.util.Random;

public class MyRunnerGrading1 {
	
	
		private static ArrayListUnsorted<Integer> mylist;//array list
		private static LinkedListUnsorted<Integer> mylist2;// linked list

		final private static int ELS = 25;  // test on this value and on even-numbered list
		final private static int SIZE = 30; 
		static int passes = 0;
		
			
		public static void sortInsertionRandom(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			Random myrandom = new Random();
			int r, i = 1;
			while (mylist.getSize() < ELS) {
			
				r = myrandom.nextInt(ELS) + 1;
				if (!mylist.contains(r)) {
					mylist.insert(r);
					i++;
				}
			}
			
			System.out.println("Before: " + mylist);	
			mylist.myinsertion();		
			System.out.println("After: " + mylist);	
			
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");
			
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
		
		public static void sortInsertionRandom2(String result) {
			mylist2 = new LinkedListUnsorted<Integer>();
			Random myrandom = new Random();
			int r, i = 1;
			while (mylist2.getSize() < ELS) {
			
				r = myrandom.nextInt(ELS) + 1;
				if (!mylist2.contains(r)) {
					mylist2.insert(r);
					i++;
				}
			}
			
			System.out.println("Before: " + mylist2);	
			mylist2.myinsertion();
			System.out.println("After: " + mylist2);	
			
			if (result.equals(mylist2.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");
			
			mylist2.insert(100);
			mylist2.insert(101);
			mylist2.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist2);
			  		
		}
		
		public static void sortOddEvenRandom(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			Random myrandom = new Random();
			int r, i = 1;
			while (mylist.getSize() < ELS) {
			
				r = myrandom.nextInt(ELS) + 1;
				if (!mylist.contains(r)) {
					mylist.insert(r);
					i++;
				}
			}
			System.out.println("Before: " + mylist);	
			mylist.myOddEven();	
			System.out.println("After: " + mylist);			
								
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");  	
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
			
		
		public static void sortOddEvenRandom2(String result) {
			mylist2 = new LinkedListUnsorted<Integer>();
			Random myrandom = new Random();
			int r, i = 1;
			while (mylist2.getSize() < ELS) {
			
				r = myrandom.nextInt(ELS) + 1;
				if (!mylist2.contains(r)) {
					mylist2.insert(r);
					i++;
				}
			}
			
			System.out.println("Before: " + mylist2);	
			mylist2.myOddEven();	
			System.out.println("After: " + mylist2);							
			
			if (result.equals(mylist2.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");
			mylist2.insert(100);
			mylist2.insert(101);
			mylist2.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist2);
					
		}
		
		public static void sortCountSortRandom(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			Random myrandom = new Random();
			int r, i = 1;
			while (mylist.getSize() < ELS) {
			
				r = myrandom.nextInt(ELS) + 1;
				if (!mylist.contains(r)) {
					mylist.insert(r);
					i++;
				}
			}
			
			System.out.println("Before: " + mylist);	
			mylist.myCountingSort();	
			System.out.println("After: " + mylist);			
								
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");  	
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
		
					
		public static void sortQuickRandom(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			Random myrandom = new Random();
			int r, i = 1;
			while (mylist.getSize() < ELS) {
			
				r = myrandom.nextInt(ELS) + 1;
				if (!mylist.contains(r)) {
					mylist.insert(r);
					i++;
				}
			}

			System.out.println("Before: " + mylist);	
			mylist.myquick();
			System.out.println("After: " + mylist);	
			
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");  
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
			
		public static void sortMergeRandom(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			Random myrandom = new Random();
			int r, i = 1;
			while (mylist.getSize() < ELS) {
			
				r = myrandom.nextInt(ELS) + 1;
				if (!mylist.contains(r)) {
					mylist.insert(r);
					i++;
				}
			}

			System.out.println("Before: " + mylist);	
			mylist.mymerge();	
			System.out.println("After: " + mylist);	
					
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");  	
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
		
		public static void sortInsertionOppositeSorted(String result) {
			mylist = new ArrayListUnsorted<Integer>(ELS);
			for (int i = ELS; i > 0; i--)
				mylist.insert( i );
			
			System.out.println("Before: " + mylist);	
			mylist.myinsertion();		
			System.out.println("After: " + mylist);	
			
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
		
		public static void sortInsertionOppositeSorted2(String result) {
			mylist2 = new LinkedListUnsorted<Integer>();
			for (int i = ELS; i > 0; i--)
				mylist2.insert(i);
			
			System.out.println("Before: " + mylist2);	
			mylist2.myinsertion();
			System.out.println("After: " + mylist2);	
			
			if (result.equals(mylist2.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");
			mylist2.insert(100);
			mylist2.insert(101);
			mylist2.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist2);
			  		
		}
		
		public static void sortOddEvenOppositeSorted(String result) {
			mylist = new ArrayListUnsorted<Integer>(ELS);
			for (int i = ELS; i > 0; i--)
				mylist.insert(i);
			
			System.out.println("Before: " + mylist);	
			mylist.myOddEven();	
			System.out.println("After: " + mylist);			
								
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");  		
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
			
		
		public static void sortOddEvenOppositeSorted2(String result) {
			mylist2 = new LinkedListUnsorted<Integer>();
			for (int i = ELS; i > 0; i--)
				mylist2.insert(i);
			
			System.out.println("Before: " + mylist2);	
			mylist2.myOddEven();	
			System.out.println("After: " + mylist2);							
			
			if (result.equals(mylist2.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");
			mylist2.insert(100);
			mylist2.insert(101);
			mylist2.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist2);
					
		}
		
		public static void sortCountSortOppositeSorted(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			for (int i = ELS; i > 0; i--)
				mylist.insert(i);
			
			System.out.println("Before: " + mylist);	
			mylist.myCountingSort();	
			System.out.println("After: " + mylist);			
								
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");  
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
		
					
		public static void sortQuickOppositeSorted(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			for (int i = ELS; i > 0; i--)
				mylist.insert(i);

			System.out.println("Before: " + mylist);	
			mylist.myquick();;	
			System.out.println("After: " + mylist);	
			
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");   		
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
			
		public static void sortMergeOppositeSorted(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			for (int i = ELS; i > 0; i--)
				mylist.insert(i);

			System.out.println("Before: " + mylist);	
			mylist.mymerge();	
			System.out.println("After: " + mylist);	
					
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");  		
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
		
		
		public static void sortInsertionSorted(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			for (int i = 1; i <= ELS; i++)
				mylist.insert( i );
			
			System.out.println("Before: " + mylist);	
			mylist.myinsertion();		
			System.out.println("After: " + mylist);	
			
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
		
		public static void sortInsertionSorted2(String result) {
			mylist2 = new LinkedListUnsorted<Integer>();
			for (int i = 1; i <= ELS; i++)
				mylist2.insert( i );
			
			System.out.println("Before: " + mylist2);	
			mylist2.myinsertion();
			System.out.println("After: " + mylist2);	
			
			if (result.equals(mylist2.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");
			mylist2.insert(100);
			mylist2.insert(101);
			mylist2.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist2);
			  		
		}
		
		public static void sortOddEvenSorted(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			for (int i = 1; i <= ELS; i++)
				mylist.insert( i );
			
			System.out.println("Before: " + mylist);	
			mylist.myOddEven();	
			System.out.println("After: " + mylist);			
								
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");  	
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
			
		
		public static void sortOddEvenSorted2(String result) {
			mylist2 = new LinkedListUnsorted<Integer>();
			for (int i = 1; i <= ELS; i++)
				mylist2.insert( i );
			
			System.out.println("Before: " + mylist2);	
			mylist2.myOddEven();	
			System.out.println("After: " + mylist2);							
			
			if (result.equals(mylist2.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");
			mylist2.insert(100);
			mylist2.insert(101);
			mylist2.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist2);
					
		}
		
		public static void sortCountSortSorted(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			for (int i = 1; i <= ELS; i++)
				mylist.insert(i);
			
			System.out.println("Before: " + mylist);	
			mylist.myCountingSort();	
			System.out.println("After: " + mylist);			
								
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");  		
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
		
					
		public static void sortQuickSorted(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			for (int i = 1; i <= ELS; i++)
				mylist.insert(i);

			System.out.println("Before: " + mylist);	
			mylist.myquick();;	
			System.out.println("After: " + mylist);	
			
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");   	
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
			
		public static void sortMergeSorted(String result) {
			mylist = new ArrayListUnsorted<Integer>(SIZE);
			for (int i = 1; i <= ELS; i++)
				mylist.insert(i);

			System.out.println("Before: " + mylist);	
			mylist.mymerge();	
			System.out.println("After: " + mylist);	
					
			if (result.equals(mylist.toString())) {
				passes++;
				System.out.println("PASSED");
			}
			else
				System.out.println("FAILED");  	
			mylist.insert(100);
			mylist.insert(101);
			mylist.insert(102);
			System.out.println("insertion of extra elements after sorting");
			System.out.println(mylist);
		}
		
		public static void main(String[] args) {
			String result = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]";	
//			String result = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]";  // uncomment for even test
			
			System.out.println("Tests:");
			System.out.println("Label: insertion sort of array: opposite, sorted, random");
			sortInsertionOppositeSorted(result);
			sortInsertionSorted(result);
			sortInsertionRandom(result);
			
			System.out.println("Label: insertion sort of linked: opposite, sorted, random");
			sortInsertionOppositeSorted2(result);
			sortInsertionSorted2(result);
			sortInsertionRandom2(result);
			
			System.out.println("Label: odd-even sort of array: opposite, sorted, random");
			sortOddEvenOppositeSorted(result);
			sortOddEvenSorted(result);
			sortOddEvenRandom(result);
			
			System.out.println("Label: odd-even sort of linked: opposite, sorted, random");
			sortOddEvenOppositeSorted2(result);
			sortOddEvenSorted2(result);
			sortOddEvenRandom2(result);
			
			System.out.println("Label: count sort of data: opposite, sorted, random");			
			sortCountSortOppositeSorted(result);
			sortCountSortSorted(result);
			sortCountSortRandom(result);
						
			System.out.println("Label: quick sort of data: opposite, sorted, random");			
			sortQuickOppositeSorted(result);
			sortQuickSorted(result);
			sortQuickRandom(result);
						
			System.out.println("Label: merge sort of data: opposite, sorted, random");
			sortMergeOppositeSorted(result);
			sortMergeSorted(result);
			sortMergeRandom(result);
			
			System.out.println("\n\npasses (out of 21): " + passes);
			
		}

}
