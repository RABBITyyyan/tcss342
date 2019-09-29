package mybagpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents basic unsorted node-based list.
 * 
 * @author modified from Building Java Programs 3rd ed, Chang Yan (Charlotte).
 * @version Spring 2019
 * @param <E> is of any object type
 */
public class OtherBagUnsorted<E> extends AbstractOtherBag<E> {

    /**
     * Reference to the first node in the list.
     */
    private ListNode<E> front; 
    
    /**
     * Reference to the last node in the list.
     */
    private ListNode<E> back; 

    /**
     * index of the last list element
     */
    private int size;  

    /**
     * Constructs an empty list.
     */
    public OtherBagUnsorted() {
        front = null;
        back = null;
        size = -1;
    }

    /**
     * @see mylistpackage.MyList#getSize()
     */
    @Override
    public int getSize() {
        return size + 1;
    }

    /**
     * @see mylistpackage.MyList#isEmpty()
     */
    public boolean isEmpty() {
        return size == -1;
    }

    /**
     * @see mylistpackage.MyList#contains(java.lang.Object)
     */
    public boolean contains(E[] value) {
        return getIndex(value) >= 0;
    }

    /**
     * @see mylistpackage.MyList#insert(java.lang.Object)
     */
    public void insert(E[] value) {
    	ListNode<E> valueNode = new ListNode<E>(value);
        if (size == -1) {
        	front = valueNode;
        	back = front;
        } else {
        	back.next = valueNode;
        	back = back.next;
        }
        size++;
    }  

    /**
     * @see mylistpackage.MyList#clear()
     */
    public void clear() {
        front = null;
        back = null;
        size = -1;
    }


    /**
     * Creates a comma-separated, bracketed version of the list.
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        if (size == -1) {
            return "[]";
        } else {
            String result = Arrays.toString(front.data);
            ListNode<E> current = front.next;
            while (current != null) {
                result += ", " + Arrays.toString(current.data);
                current = current.next;
            }
            return result;
        }
    }
    
    /**
     * @see mylistpackage.MyList#remove(java.lang.Object)
     */
    public void remove(E[] data) {
        if (size > -1) {				    // if the list is not empty
        	if (Arrays.equals(front.data, data)) {                 // if value in the first node
        		front = front.next;
        		if (size == 0)				    // if it was the only node
        			back = null;
        		size--;
        	}
        	else {					   // value not in the first node
        		ListNode<E> prior = front;	           // set up a trailing reference

        		while (prior != null && prior != back) {               // look ahead one node
        			if (Arrays.equals(prior.next.data, data)) {   // found it
        				prior.next = prior.next.next;
        				if (prior.next == null)            // if deleting the last node
        					back = prior;
        				size--;
        			} //endif
        			prior = prior.next;
        		} //endwhile

//        		if (prior.next == back) {
//        			back = prior; 
//        			prior.next = back.next.next;
//        		}
        	} // endelse
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
    public int getIndex(E[] value) {
        int index = 0;
        ListNode<E> current = front;
        while (current != null) {
            if (Arrays.equals(current.data, value)) {
                return index;
            }
            index++;
            current = current.next;
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
        checkIndex(index);
        if (index == 0) {		// special case for the first node
            front = front.next;
            if (size == 0)		// if this is also the only node
                back = null;
        }
        else {				// if the value not in the first node
            ListNode<E> prior = nodeAt(index - 1);   // find the reference to the prior node
            prior.next = prior.next.next;	     // unlink
            if (prior.next == null)		     // if it is the last node
                back = prior;
        }
        
        size--;
    }
    
    /**
     * Replaces the value at the given index with the given value.
     * 
     * @param 0 <= index < length
     * @param value is assigned
     * @throws IndexOutOfBoundsException if index < 0 or index >= length
     */
    public void set(int index, E[] value) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        for (int i = 0; i < 5; i++) {
        	current.data[i] = value[i];
        }
    }
    
    /**
     * Returns the value at the given index in the list.
     * 
     * @param 0 <= index < length
     * @throws IndexOutOfBoundsException if index < 0 or index >= length
     * @return the value at the given index in the list.
     */
    public E[] get(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        return current.data;
    } 

    /**
     * Returns the node at a specific index.
     * @param index where 0 <= index <= size
     * @return reference to the node at a specific index
     */
    private ListNode<E> nodeAt(int index) {
        ListNode<E> current = front;
        for (int i = 1; i <= index; i++) {
                current = current.next;
        }
        return current;
    }

    
    /**
     * Checks if the index is a legal index of the current list.
     * @param index
     * @throws IndexOutOfBoundsException if the given index is not a legal index of the current list
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
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
    @SuppressWarnings("unchecked")
	public Iterator<E> iterator() {
        return (Iterator<E>) new LinkedIterator();
    }

    /**
     * Represents a list node.
     * @author Building Java Programs 3rd ed.
     *
     * @param <E> is of any object type
     */
    protected static class ListNode<E> {

        /**
         * Data stored in this node.
         */
        public E[] data; 

        /**
         * Link to next node in the list.
         */
        public ListNode<E> next;  
       
        /**
         * Constructs a node with given data and a null link.
         * @param data assigned
         */
        @SuppressWarnings("unchecked")
		public ListNode(E[] myData) { 
        	data = (E[]) new java.lang.Object[5];
        	for (int i = 0; i < 5; i++) {
        		data[i] = myData[i];      		
        	}
        	next = null;
        }

        /**
         * Constructs a node with given data and given link.
         * @param data assigned
         * @param next assigned
         */
        public ListNode(E[] data, ListNode<E> next) {       	
        	for (int i = 0; i < 5; i++) {
        		this.data[i] = data[i];
        	}
        	this.next = next;
        }
    }

    /**
     * Represents an iterator for the list.
     * 
     * @author modified from BuildingJavaPrograms 3rd Edition
     */
    protected class LinkedIterator implements Iterator<E[]> {
        
        /**
         * Location of current value to return.
         */
        private ListNode<E> current; 

        /**
         * flag that indicates whether list element can be removed.
         */
        private boolean removeOK; 
        
        /**
         * Location of the prior value in case of removal.
         */
        private ListNode<E> prior;

        /**
         * Constructs an iterator for the given list.
         */
        public LinkedIterator() {
            current = front;
            removeOK = false;
            prior = null;
        }
        
        /**
         * Deep copy an array.
         * @return the copied new array.
         */
		private E[] deepCopy(E[] data) {
        	E[] newData = (E[]) new java.lang.Object[5];;
        	for (int i = 0; i < 5; i++) {
        		newData[i] = data[i];
        	}
        	return newData;	
        }

        /**
         * Returns whether there are more list elements.
         * 
         * @return true if there are more elements left, false otherwise
         * @see java.util.Iterator#hasNext()
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         * 
         * @throws NoSuchElementException if no more elements.
         * @return the next element in the iteration.
         * @see java.util.Iterator#next()
         */
        public E[] next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            prior = current;
			E[] result = deepCopy(current.data);
            current = current.next;
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
            OtherBagUnsorted.this.remove(prior.data);
            removeOK = false;
        }

    }
    
}

