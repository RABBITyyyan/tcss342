package mybagpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * An abstract class represents array-based bag that implements MyBag.
 * 
 * @author Chang Yan (Charlotte)
 * @version April 2019
 * @param <E> is of any object type
 */
public abstract class AbstractArrayBag<E> implements MyBag<E> {
	
	/**
     * default list capacity.
     */
    protected static final int DEFAULT_CAPACITY = 150;

    /**
     * list of values
     */
    protected E[] elementData;

    /**
     * index of the last element in the list
     */
    protected int size;
    
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
     * Returns a boolean that determines whether we can remove the node.
     * 
     * @param an array, value assigned.
     * @return a boolean that determines whether we can remove the node.
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
     * @param index < length and index >= 0
     * @value is assigned
     * @throws IndexOutOfBoundsException if index < 0 or index >= length
     */
    @Override
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

    }

    /*********************************************
     * Iterator list class / methods end
     *********************************************/



}
