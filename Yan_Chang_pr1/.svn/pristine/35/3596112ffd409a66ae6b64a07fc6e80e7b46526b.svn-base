package mybagpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Represents sorted array-based bag.
 * 
 * @author Chang Yan (Charlotte)
 * @version April 2019
 * @param <E> is of any object type
 */
public class ArrayBagSorted<E extends Comparable<? super E>> extends AbstractArrayBag<E> {
	
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
    public ArrayBagSorted() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty list of the given capacity.
     * 
     * @param capacity > 0
     * @throws IllegalArgumentException if capacity <= 0
     */
    @SuppressWarnings("unchecked")
	public ArrayBagSorted(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Comparable[capacity];
        size = -1;
    }
    
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
     * Inserts an element into the list using binary search.
     * 
     * @param value assigned
     */
    public void insert(E value) {
    	ensureCapacity(size + 2);
    	int index_found = binarySearch(value);
    	for (int i = index_found + 1; i <= size; i++) {
    		if (elementData[i].compareTo(value) > 0) {
    			E tmp = elementData[i];
    			elementData[i] = tmp;

    		}
    	}
    	elementData[index_found] = value;
    	size++;      
    }
    
    /**
     * Clears the list.
     */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		if (size > DEFAULT_CAPACITY) 
    		elementData = (E[]) new Comparable[DEFAULT_CAPACITY];
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
     * Removes first element occurrence from the list.
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
    	shrunkCapacity(size);
    }
    
    /**
     * Ensures that the capacity of a bag > default capacity and less than 1/4
     * of the current capacity is used. The array is shrunk either half of its current 
     * capacity or to default capacity (if half capacity < default capacity).    
     * 
     * @param capacity - the capacity of a bag.
     */
    private void shrunkCapacity(int capacity) {
    	if (elementData.length > DEFAULT_CAPACITY && size < 0.25 * elementData.length) {   		    		
    		if (0.5 * elementData.length < DEFAULT_CAPACITY) {
    			int newCapacity = elementData.length / 2;
    			elementData = Arrays.copyOf(elementData, newCapacity);	
    		} else {
    			elementData = Arrays.copyOf(elementData, DEFAULT_CAPACITY);
    		}
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
    	shrunkCapacity(size);
    }
    
    /**
     * Determines if a value can be removed in a given array.
     * @param myArray - an array, value - a value to be checked
     * @return a boolean that determines if the value can be removed in the given array.
     */
    public boolean canRemove(E[] myArray, E value) {
    	List<E> list = Arrays.asList(myArray);
    	if(list.contains(value)){
            return true;
        }
    	return false;
    }

    /**
     * Replaces the value at the given index with the given value.
     * 
     * @param index < length and index >= 0, value is assigned
     * @throws IllegalArgumentException if index < 0 or index >= length
     */
    public void set(int index, E value) {
    	
    	if (index < 0 || index > size) {
    		throw new IllegalArgumentException();
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
    
    /**
     * @return the capacity of the bag.
     */
    public int getCapacity() {
    	return elementData.length;
    }

    /**
     * The binary search process utilizes the concept of splitting intervals
     * in half as a means of finding the "key" value in elementData[].
     * @param key - value to be searched.
     * @return the index of the value to be inserted. 
     */
    public int binarySearch(E key) {
    	
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
            E result = (E) elementData[position];
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
            ArrayBagSorted.this.removeAtIndex(position - 1);
            position--;
            removeOK = false;
        }
    }

    /*********************************************
     * Iterator list class / methods end
     *********************************************/
	

}
