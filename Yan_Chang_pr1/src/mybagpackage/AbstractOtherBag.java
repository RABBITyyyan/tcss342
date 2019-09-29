package mybagpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An abstract class represents basic node-based bag.
 * that implements MyBag.
 * 
 * @author Chang Yan (Charlotte)
 * @version April 2019
 * @param <E> is of any object type
 */
public abstract class AbstractOtherBag <E> {
	
	/**
     * Reference to the first node in the list.
     */
    protected ListNode<E> front; 
    
    /**
     * Reference to the last node in the list.
     */
    private ListNode<E> back; 

    /**
     * index of the last list element
     */
    private int size;  

    /**
     * @see mylistpackage.MyList#getSize()
     */
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
            String result = "[" + front.data;
            ListNode<E> current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
    
    /**
     * @see mylistpackage.MyList#remove(java.lang.Object)
     */
    public void remove(E[] value) {
        if (size > -1) {				    // if the list is not empty
    	    if (Arrays.equals(value, front.data)) {                 // if value in the first node
    	        front = front.next;
    		if (size == 0)				    // if it was the only node
    		    back = null;
    		size--;
    	    }
    	    else {					   // value not in the first node
                ListNode<E> prior = front;	           // set up a trailing reference
    	        while (prior.next != null) {               // look ahead one node
    	            if (Arrays.equals(prior.next.data, value)) {   // found it
    	                prior.next = prior.next.next;
    	            	if (prior.next == null)            // if deleting the last node
    	            	    back = prior;
    	            	size--;
    	            } //endif
    	            prior = prior.next;
    	        } //endwhile
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
     * Returns the value at the given index in the list.
     * 
     * @param index: 0 <= index < length
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
    public Iterator<E> iterator() {
        return new LinkedIterator();
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
        public ListNode(E[] data) {
            this(data, null);
        }

        /**
         * Constructs a node with given data and given link.
         * @param data assigned
         * @param next assigned
         */
        public ListNode(E[] data, ListNode<E> next) {       	
        	for (int i = 0; i < 5; i++) {
        		this.data[i] = data[i];
        		this.next = next;
        	}
        }
    }

    /**
     * Represents an iterator for the list.
     * 
     * @author modified from BuildingJavaPrograms 3rd Edition
     */
    private class LinkedIterator implements Iterator<E> {
        
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
         * Deep copy an array.
         * @return the copied new array.
         */
        @SuppressWarnings("null")
		private E[] deepCopy(E[] data) {
        	E[] newData = null;
        	for (int i = 0; i < 5; i++) {
        		newData[i] = data[i];
        	}
        	return newData;	
        }

        /**
         * Constructs an iterator for the given list.
         */
        public LinkedIterator() {
            current = front;
            removeOK = false;
            prior = null;
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
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            prior = current;
            @SuppressWarnings("unchecked")
			E result = (E) deepCopy(current.data);
            current = current.next;
            removeOK = true;
            return result;
        }
    }

}
