import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents basic unsorted array-based list.
 * 
 * @author modified from Building Java Programs 3rd ed, Chang Yan.
 * @version April 2019
 * @param <E> is of any object type
 */
public class ArrayListUnsorted<E extends Comparable<? super E>> {

    /**
     * default list capacity.
     */
    private static final int DEFAULT_CAPACITY = 150;

    /**
     * list of values
     */
    private E[] elementData;

    /**
     * index of the last element in the list
     */
    private int size;

    /**
     * Constructs an empty list of default capacity.
     */
    public ArrayListUnsorted() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty list of the given capacity.
     * 
     * @param capacity > 0
     * @throws IllegalArgumentException if capacity <= 0
     */
    @SuppressWarnings("unchecked")
    public ArrayListUnsorted(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Comparable[capacity];
        size = -1;
    }
    
    /******************************************************************************************
     * Sorting methods follow
     ******************************************************************************************/
    
    /**
     * Sort an array of Comparable objects by odd and even. 
     */
    public void myOddEven() { 
    	boolean isSorted = false; // Initially array is unsorted 

    	while (!isSorted) { 
    		isSorted = true; 
    		E temp; 

    		// Perform Bubble sort on odd indexed element 
    		for (int i = 1; i <= size - 1; i = i + 2) { 
    			if (elementData[i].compareTo(elementData[i+1]) > 0) { 
    				temp = elementData[i]; 
    				elementData[i] = elementData[i + 1]; 
    				elementData[i + 1] = temp; 
    				isSorted = false; 
    			} 
    		} 

    		// Perform Bubble sort on even indexed element 
    		for (int i = 0; i <= size - 1; i = i + 2) { 
    			if (elementData[i].compareTo(elementData[i + 1]) > 0) { 
    				temp = elementData[i]; 
    				elementData[i] = elementData[i + 1]; 
    				elementData[i + 1] = temp; 
    				isSorted = false; 
    			} 
    		} 
    	}
    }
    
    /**
     * Sort an array of Comparable objects by insertion.
     */
    public void myinsertion() {
    	for (int i = 1; i < size + 1; i++) {
    		E temp = elementData[i];
    		int j = i;

    		for( ; j > 0 && temp.compareTo(elementData[j - 1]) < 0; j--)
    			elementData[ j ] = elementData[j - 1];
    		elementData[j] = temp;
    	}
    }
    
    /**
     * Sort an array of Comparable objects by merge sort.
     */
    public void mymerge() {
    	@SuppressWarnings("unchecked")
		E[] tmpArray = (E[]) new Comparable[size + 1];
    	int left = 0;
    	int right = size;
    	mergeSort(elementData, tmpArray, left, right);
    }
    
    /**
     * Internal method that makes recursive calls.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    public void mergeSort(E[] a, E[] tmpArray, int left, int right) {
        if(left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center );
            mergeSort(a, tmpArray, center + 1, right );
            merge(a, tmpArray, left, center + 1, right );
        }
    }
    
    /**
     * Internal method that merges two sorted halves of a subarray.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
    private void merge(E[] a, E[] tmpArray, int leftPos, int rightPos, int rightEnd) {
    	int leftEnd = rightPos - 1;
    	int tmpPos = leftPos;
    	int numElements = rightEnd - leftPos + 1;
    	// Main loop
    	while(leftPos <= leftEnd && rightPos <= rightEnd) {
    		if (a[leftPos].compareTo(a[rightPos]) <= 0) {
    			tmpArray[tmpPos++] = a[leftPos++];
    		} else {
    			tmpArray[tmpPos++] = a[rightPos++];
    		}
    	}

    	while (leftPos <= leftEnd)    // Copy rest of first half
    		tmpArray[tmpPos++] = a[leftPos++];

    	while(rightPos <= rightEnd)  // Copy rest of right half
    		tmpArray[tmpPos++] = a[rightPos++];

    	// Copy tmpArray back
    	for( int i = 0; i < numElements; i++, rightEnd-- )
    		a[rightEnd] = tmpArray[rightEnd];
    }
    
    /**
     * Quicksort algorithm.
     */
    public void myquick() {
        quicksort(elementData, 0, size);       
    }
    
    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning
     * @param a an array of Comparable items.
     * @param low the left-most index of the subarray.
     * @param high the right-most index of the subarray.
     */
    private void quicksort(E[] a, int low, int high) {
    	
    	// base case
    	if( low + 2 > high ) {
    		if (a[low].compareTo(a[high]) > 0) {
    			E temp = a[low]; 
				a[low] = a[high]; 
				a[high] = temp; 
    		}
    	} else {
             // Sort low, middle, high
            int middle = ( low + high ) / 2;
            if( a[ middle ].compareTo( a[ low ] ) < 0 )
                swapReferences( a, low, middle );
            if( a[ high ].compareTo( a[ low ] ) < 0 )
                swapReferences( a, low, high );
            if( a[ high ].compareTo( a[ middle ] ) < 0 )
                swapReferences( a, middle, high );

            // Place pivot at position high - 1
            swapReferences( a, middle, high - 1 );
            E pivot = a[ high - 1 ];

                // Begin partitioning
            int i, j;
            for( i = low, j = high - 1; ; )
            {
                while( a[ ++i ].compareTo( pivot ) < 0 )
                    ;
                while( pivot.compareTo( a[ --j ] ) < 0 )
                    ;
                if( i >= j )
                    break;
                swapReferences( a, i, j );
            }

                // Restore pivot
            swapReferences( a, i, high - 1 );

            quicksort( a, low, i - 1 );    // Sort small elements
            quicksort( a, i + 1, high );   // Sort large elements
            
        }
    }
    
    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    private final void swapReferences(E[] a, int index1, int index2 ) {
        E tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
    
    @SuppressWarnings({ "unchecked", "deprecation" })
	public void myCountingSort() {
    	E maxVal = getMax(elementData, getSize());
    	
    	int[] count = new int[(int) maxVal + 1];
    	for (int i = 0; i < getSize(); i++) {
    		count[(int) elementData[i]]++;
    	}
    	int index = 0;
    	for (int i = 0; i < count.length; i++) {
    		for (int j = 0; j < count[i]; j++) {
    			elementData[index++] = (E) new Integer(i);
    		}
    	}
    }
    
    /**
     * method to get the maximum element from the array.
     * @param an array of Comparable objects.
     * @param size of the array.
     */
  	private E getMax(E[] a, int size) {
  		E  max = a[0];
  		for (int i = 1; i < size; i++) {
  			if (a[i].compareTo(max) > 0)
  				max=a[i];
  		}
  		return max;
  	}

  	/******************************************************************************************
     * Sorting methods end
     ******************************************************************************************/
  	
  	
  	/******************************************************************************************
     * Searching methods start
     ******************************************************************************************/
  	
  	/**
     * The linear search algorithm of finding the "key" value in elementData[].
     * @param key - value to be searched.
     * @return the index of the value to be searched. 
     */
  	public int myLinearSearch(E key) {
		for (int i =0; i < getSize(); i++) {
			if (elementData[i].equals(key)) return i;
		}
		return -1;
	}
  	
  	/**
     * The binary search algorithm of finding the "key" value in elementData[]..
     * @param key - value to be searched.
     * @return the index of the value to be searched. 
     */
    public int mybinarySearch(E key) {
    	
    	int start = 0;
    	int end = size;
    	int mid = 0;

    	while (start <= end) {
    		mid = (start + (end - start) / 2);
    		// Check if value is present at mid 
    		if (key.equals(elementData[mid])) {
    			return mid;
    		}
    		if (key.compareTo(elementData[mid]) < 0) {
    			end = mid - 1;
    			
    		} else {
    			start = mid + 1;
    		}
    	}
    	return start;
    }
  	/******************************************************************************************
     * Searching methods end
     ******************************************************************************************/
    
    /**
     * Returns the current number of elements in the list.
     * 
     * @return the current number of elements in the list >= 0
     */
    public int getSize() {
        return size + 1;
    }

     /**
     * Returns whether the list is empty.
     * 
     * @return true if list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == -1;
    }

    /**
     * Returns whether value is in the list.
     * 
     * @param value assigned
     * @return true if value in the list, false otherwise.
     */
    public boolean contains(E value) {
        for (int i = 0; i <= size; i++) {
            if (elementData[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

   /**
     * Inserts an element into the list.
     * 
     * @param value assigned
     */
    public void insert(E value) {
        ensureCapacity(size + 2);
        size++;
        elementData[size] = value;       
    }

    /**
     * Clears the list.
     */
    @SuppressWarnings("unchecked")
	public void clear() {
	if (size > DEFAULT_CAPACITY) 
    	    elementData = (E[]) new Object[DEFAULT_CAPACITY];
        size = -1;
    }

    /**
     * Returns a string representation of list contents.
     * 
     * @return a string representation of list contents.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        if (size == -1) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i <= size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    /**
     * Removes first element occurence from the list.
     * 
     * @param value assigned
     */
    public void remove(E value) {
        int index = getIndex(value);
        if (size >= 0 && index >= 0) {
            for (int i = index; i < size; i++)
            	elementData[i] = elementData[i + 1];
            size--;
        }
    }

    /**
     * Ensures that the underlying array has the given capacity; if not,
     * increases the size by doubling it.
     * 
     * @param capacity > elementData.length.
     */
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    /*********************************************
     * Index list methods follow
     *********************************************/

    /**
     * Returns the index of value.
     * 
     * @param value assigned.
     * @return index of value if in the list, -1 otherwise.
     */
    public int getIndex(E value) {
        for (int i = 0; i <= size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Removes value at the given index, shifting subsequent values up.
     * 
     * @param index < length and index >= 0
     * @throws IndexOutOfBoundsException if index < 0 or index >= length
     */
    public void removeAtIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size; i++)
        	elementData[i] = elementData[i + 1];
        size--;
    }

    /**
     * Replaces the value at the given index with the given value.
     * 
     * @param index < length and index >= 0
     * @value is assigned
     * @throws IndexOutOfBoundsException if index < 0 or index >= length
     */
    public void set(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        elementData[index] = value;
    }

    /**
     * Returns the value at the given index in the list.
     * 
     * @param index < length and index >= 0
     * @throws IndexOutOfBoundsException if index < 0 or index >= length
     * @return the value at the given index in the list.
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return elementData[index];
    }

    /*********************************************
     * Index list methods end
     *********************************************/

    /*********************************************
     * Iterator list class / methods follow
     *********************************************/

    /**
     * Returns an iterator for this list.
     * 
     * @return an iterator for the list.
     */
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Represents an iterator for the list.
     * 
     * @author BuildingJavaPrograms 3rd Edition
     */
    private class ArrayListIterator implements Iterator<E> {

        /**
         * current position within the list.
         */
        private int position;

        /**
         * flag that indicates whether list element can be removed.
         */
        private boolean removeOK;

        /**
         * Constructs an iterator for the given list
         */
        public ArrayListIterator() {
            position = 0;
            removeOK = false;
        }

        /**
         * Returns whether there are more list elements.
         * 
         * @return true if there are more elements left, false otherwise
         * @see java.util.Iterator#hasNext()
         */
        public boolean hasNext() {
            return position <= size;
        }

        /**
         * Returns the next element in the iteration.
         * 
         * @throws NoSuchElementException if no more elements.
         * @return the next element in the iteration.
         * @see java.util.Iterator#next()
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = elementData[position];
            position++;
            removeOK = true;
            return result;
        }

        /**
         * Removes the last element returned by the iterator.
         * 
         * @throws IllegalStateException if a call to next has not been made
         *             before call to remove.
         * @see java.util.Iterator#remove()
         */
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ArrayListUnsorted.this.removeAtIndex(position - 1);
            position--;
            removeOK = false;
        }
    }

    /*********************************************
     * Iterator list class / methods end
     *********************************************/

}
