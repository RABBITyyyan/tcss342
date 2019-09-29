package mybagpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents basic unsorted node-based bag.
 * 
 * @author modified from Building Java Programs 3rd ed, Chang Yan.
 * @version April 2019
 * @param <E> is of any object type
 */
public class LinkedBagSorted<E extends Comparable<? super E>> extends AbstractLinkedBag<E> {
    
    /**
     * Reference to the last node in the list.
     */
    private ListNode<E> back; 
  
    /**
     * Constructs an empty list.
     */
    public LinkedBagSorted() {
        back = null;
    }
    
    /**
     * Get the size of the list.
     * @return the size of the list.
     */
    public int getSize() { 
        ListNode<E> temp = back; 
        int count = 0;
        if (temp == null) {
        	return 0;
        }
        if (temp.next == back) {
        	return 1;
        }
        while (temp.next != back) { 
            count++; 
            temp = temp.next;
        } 
        return count + 1; 
    } 

    /**
     * @see mylistpackage.MyList#isEmpty()
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * @see mylistpackage.MyList#contains(java.lang.Object)
     */
    public boolean contains(E value) {
        return getIndex(value) >= 0;
    } 

    /**
     * @see mylistpackage.MyList#insert(java.lang.Object)
     */
    public void insert(E value) { 
    	ListNode<E> current; 
    	ListNode<E> prior; 
    	ListNode<E> valueNode = new ListNode<E>(value);

    	// Special case for the empty linked list
    	if (back == null) { 
    		back = valueNode;
    		back.next = back;
    	} else {  
    		//  Locate the node before point of insertion
    		current = back.next; 
    		prior = back;
    		while (current != back && current.data.compareTo(value) < 0) {
    			current = current.next; 
    			prior = prior.next;
    		}
    		// Special case when the node is the last node
    		if (current == back) {
    			// compare the values
    			if (current.data.compareTo(value) < 0) {
    				ListNode<E> head = back.next;
        			valueNode.next = head;
        			back.next = valueNode;
        			back = back.next;
    			} else {      			
        			prior.next = valueNode;
        			valueNode.next = current; 
    			}		
    		} else {
    			prior.next = valueNode;
    			valueNode.next = current; 
    		} 
    	} 
    }

    /**
     * @see mylistpackage.MyList#clear()
     */
    public void clear() {
        back = null;
    }

    /**
     * Creates a comma-separated, bracketed version of the list.
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        if (getSize() == 0) {
            return "[]";
        } else {
            String result = "[" + back.next.data;
            ListNode<E> current = back.next.next;
            while (current != back.next) {
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
    @Override
    public void remove(E value) {
    	if (getSize() > 0) {				    // if the list is not empty
    		if (value.equals(back.next.data)) { // if value in the first node
    			back.next = back.next.next;
    			if (getSize() == 1)				    // if it was the only node
    				back = null;
    		}
    		else { // value not in the first node
    			ListNode<E> prior = back;	           // set up a trailing reference
    			while (prior.next != back ) {
    				// trace the last node
    				// look ahead one node
    				if (prior.next.data.equals(value))   // found it   
    					prior.next = prior.next.next; //endif
    				prior = prior.next;     
    			} //endwhile
    			// if deleting the last node
    			if (prior.next == back && prior.next.data.equals(value)) {
    				back = prior; 
    				prior.next = back.next.next;
    			}
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
    public int getIndex(E value) {
        int index = 0;
        // If there is only one element 
        if (getSize() == 1) {
        	if (back.data == value) {
        		return 0;	
        	} 	
        }
        // If there is no element
        if (getSize() == -1) {
        	return -1;
        }
        // If there is more than 1 element
        if (getSize() > 1) {
        	// If we are finding the last node
        	if (back.data.equals(value)) {
        		return getSize() - 1;
        	}	
        	 ListNode<E> current = back.next;
             while (current != back) {
                 if (current.data.equals(value)) {
                     return index;
                 }
                 index++;
                 current = current.next;
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
    	checkIndex(index);
    	if (index == 0) {		// special case for the first node
    		if (getSize() - 1 == 0)		// if this is also the only node
    			back = null;
    		else if (getSize() - 1 == 1)     // if there are two nodes
    			back.next = back;
    		else  // if there are more than two nodes
    			back.next = back.next.next;           	
    	}
    	else {				// if the value not in the first node
    		ListNode<E> prior = nodeAt(index - 1);   // find the reference to the prior node 
    		// unlink
    		if (prior.next == back) { // if it is the last node
    			ListNode<E> temp = back.next;
    			back = prior; 
    			back.next = temp;
    		} else {
    			prior.next = prior.next.next;
    		}         
    	}
    }
    
    /**
     * Replaces the value at the given index with the given value.
     * 
     * @param 0 <= index < length
     * @param value is assigned
     * @throws IndexOutOfBoundsException if index < 0 or index >= length
     * @throws IllegalArgumentException if the value to be set is not 
     * valid for a sorted linked bag.
     */
    public void set(int index, E value) {
    	checkIndex(index);
    	ListNode<E> current = nodeAt(index);
    	// The first node:
    	if (index == 0 && getSize() - 1 == 0) 
    		current.data = value;

    	if (index == 0 && getSize() - 1 > 0) {
    		if (value.compareTo(current.next.data) <= 0) 
    			current.data = value;
    		else 
    			throw new IllegalArgumentException();

    	}
    	// If the node is not the first and last node
    	if (index > 0 && index < getSize() - 1) {
    		ListNode<E> prior = nodeAt(index - 1);
    		if (value.compareTo(prior.data) >= 0 && value.compareTo(current.data) <= 0) 
    			current.data = value;
    		else 
    			throw new IllegalArgumentException();

    	}
    	// If the node is the last node
    	if (index == getSize() - 1) {
    		ListNode<E> prior = nodeAt(index - 1);
    		if (value.compareTo(prior.data) >= 0) 
    			current.data = value;
    		else 
    			throw new IllegalArgumentException();
    	}
    }

    /**
     * Returns the value at the given index in the list.
     * 
     * @param 0 <= index < length
     * @throws IndexOutOfBoundsException if index < 0 or index >= length
     * @return the value at the given index in the list.
     */
    public E get(int index) {
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
        ListNode<E> current = back;
        for (int i = 0; i <= index; i++) {
                current = current.next;
        }       
        if (index == 0) 
        	return back.next;  
        return current;
    }

    
    /**
     * Checks if the index is a legal index of the current list.
     * @param index
     * @throws IndexOutOfBoundsException if the given index is not a legal index of the current list
     */
    private void checkIndex(int index) {
        if (index < 0 || index > getSize() - 1) {
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
        public E data; 

        /**
         * Link to next node in the list.
         */
        public ListNode<E> next;  

       
        /**
         * Constructs a node with given data and a null link.
         * @param data assigned
         */
        public ListNode(E data) {
            this(data, null);
        }

        /**
         * Constructs a node with given data and given link.
         * @param data assigned
         * @param next assigned
         */
        public ListNode(E data, ListNode<E> next) {
            this.data = data;
            this.next = next;
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
         * Constructs an iterator for the given list.
         */
        public LinkedIterator() {
        	if (back != null) {
        		current = back.next;
        	}
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
            return current != null && (prior != back || prior == null);
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
            E result = current.data;
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
            LinkedBagSorted.this.remove(prior.data);
            removeOK = false;
        }
    }
}

