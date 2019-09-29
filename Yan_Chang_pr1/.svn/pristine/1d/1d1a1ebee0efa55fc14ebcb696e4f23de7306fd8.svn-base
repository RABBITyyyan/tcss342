package mybagpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Represents unsorted array-based bag.
 * 
 * @author Chang Yan (Charlotte)
 * @version April 2019
 * @param <E> is of any object type
 */
public class ArrayBagUnsorted<E> extends AbstractArrayBag<E> {

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
    public ArrayBagUnsorted() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty list of the given capacity.
     * 
     * @param capacity > 0
     * @throws IllegalArgumentException if capacity <= 0
     */
    @SuppressWarnings("unchecked")
    public ArrayBagUnsorted(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Object[capacity];
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
     * Removes first element occurrence from the list.
     * 
     * @param value assigned
     */
    public void remove(E value) {
    	
    	int index = getIndex(value);
    	if (size >= 0 && index >= 0) {
    		elementData[index] = elementData[size];
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
    			elementData = Arrays.copyOf(elementData, DEFAULT_CAPACITY);
    		} else {    			
    			int newCapacity = elementData.length / 2;
    			elementData = Arrays.copyOf(elementData, newCapacity);	
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
     * Removes value at the given index, use the last element in the array 
     * to replace the value removed.
     * 
     * @param index < length and index >= 0
     * @throws IndexOutOfBoundsException if index < 0 or index >= length
     */
    public void removeAtIndex(int index) {
  
    	if (index < 0 || index > size) {
    		throw new IndexOutOfBoundsException();
    	}
    	elementData[index] = elementData[size];
    	size--;
    	shrunkCapacity(size);
    }
    
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
    
    public int getCapacity() {
    	return elementData.length;
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
            ArrayBagUnsorted.this.removeAtIndex(position - 1);
            position--;
            removeOK = false;
        }
    }

    /*********************************************
     * Iterator list class / methods end
     *********************************************/

}
