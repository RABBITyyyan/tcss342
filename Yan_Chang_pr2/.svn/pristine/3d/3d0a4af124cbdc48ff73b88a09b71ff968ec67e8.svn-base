import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents basic unsorted node-based list.
 * 
 * @author modified from Building Java Programs 3rd ed, Chang Yan.
 * @version April 2019
 * @param <E> is of any object type
 */
public class LinkedListUnsorted<E extends Comparable<? super E>> {

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
    public LinkedListUnsorted() {
        front = null;
        back = null;
        size = -1;
    }
    
    /******************************************************************************************
     * Sorting methods start
     ******************************************************************************************/
    
    /**
     * Sort an array of Comparable objects by insertion.
     */
    public void myinsertion() {
    	ListNode<E> current = front.next;
    	ListNode<E> pointer = front;
    	while (current != null) {  		
    		boolean isSorted = false;
    		if (current.data.compareTo(pointer.data) < 0) {  			
    			// If less than the first node, insert this node as front
    			if (current.data.compareTo(front.data) < 0) {					
    				ListNode<E> temp = new ListNode<E>(current.data);
    				pointer.next = current.next;
    				temp.next = front;
    				current = pointer.next;
    				front = temp;  				
    			} else {	    				
    				ListNode<E> inner_pointer = front;
    				while (inner_pointer != current && !isSorted) {	
    					
    					if (inner_pointer.data.compareTo(current.data) <= 0
    							&& inner_pointer.next.data.compareTo(current.data) >= 0) {
    						ListNode<E> temp = new ListNode<E>(current.data); 
    						// delink the current node
    						pointer.next = current.next;
    		    			// link the temp node to inner_pointer
    						temp.next = inner_pointer.next;
    						inner_pointer.next = temp;	
    						current = pointer.next;
    						isSorted = true; 
    					} 
    					inner_pointer = inner_pointer.next;	
    				}
    			}
    		} else {
    			current = current.next;
    			pointer = pointer.next;
    		}
    	}
    }
    
    /**
     * Sort an array of Comparable objects by odd and even. 
     */
    public void myOddEven() { 
        boolean isSorted = false; // Initially array is unsorted 
  
        while (!isSorted) { 
            isSorted = true; 
            
            ListNode<E> oddFront = front.next;
            ListNode<E> EvenFront = front;
  
            // Perform Bubble sort on odd indexed element            
            for (int i = 1; i <= size - 1; i = i + 2) {          	
            	if (oddFront.data.compareTo(oddFront.next.data) > 0) {
            		E temp_value1 = oddFront.data;
            		oddFront.data = oddFront.next.data;
            		oddFront.next.data = temp_value1;
            		isSorted = false;
            	}
            	oddFront = oddFront.next.next;
            } 
  
            // Perform Bubble sort on even indexed element 
            for (int i = 0; i <= size - 1; i = i + 2) { 
            	if (EvenFront.data.compareTo(EvenFront.next.data) > 0) {
            		E temp_value2 = EvenFront.data;
            		EvenFront.data = EvenFront.next.data;
            		EvenFront.next.data = temp_value2;
            		isSorted = false;
            	}
            	EvenFront = EvenFront.next.next;
            } 
        }
    }
    /******************************************************************************************
     * Sorting methods end
     ******************************************************************************************/
    
    /******************************************************************************************
     * Searching methods start
     ******************************************************************************************/
    
    /**
     * The linear search algorithm of finding the "key" value in linked list.
     * @param key - value to be searched.
     * @return the index of the value to be searched. 
     */
    public int myLinearSearch(E key) { 
        ListNode<E> current = front;    //Initialize current 
        int count = 0;
        while (current != null) { 
        	count++;
            if (current.data.equals(key)) 
                return count;    //data found 
            current = current.next; 
        } 
        return -1;    //data not found 
    }
  	
  	/**
     * The binary search algorithm of finding the "key" value in linked list.
     * @param key - value to be searched.
     * @return the index of the value to be searched. 
     */
    public int mybinarySearch(E key) { 
        ListNode<E> start = front; 
        ListNode<E> last = null; 
        int count = 0;
        do { 
        	// If start is empty 
            if (start == null) 
                return -1;         
            // Find Middle 
        	ListNode<E> mid = start; 
            ListNode<E> mid_next = start.next; 
      
            while (mid_next != last) { 
            	mid_next = mid_next.next; 
                if (mid_next != last) { 
                    mid = mid.next; 
                    mid_next = mid_next.next; 
                	count++;
                } 
            }
            // If middle is empty 
            if (mid == null) 
                return -1; 
            // If value is present at middle 
            if (mid.data.equals(key)) 
                return count; 
            // If value is less than mid 
            else if (mid.data.compareTo(key) < 0) { 
                start = mid.next;
            } 
            // If the value is greater than mid. 
            else {
                last = mid; 
            }
        } while (last == null || last != start); 
        // key is not in the list 
        return -1; 
    }
  	/******************************************************************************************
     * Searching methods end
     ******************************************************************************************/
    


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
    public boolean contains(E value) {
        return getIndex(value) >= 0;
    }

    /**
     * @see mylistpackage.MyList#insert(java.lang.Object)
     */
    public void insert(E value) {
    	ListNode<E> valueNode = new ListNode<E>(value);
        if (size == -1) {
        	front = valueNode;
        	back = valueNode;
        } else {
        	back.next = valueNode;
        	back = valueNode;
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
    public void remove(E value) {
    	if (size > -1) {					 // if the list is not empty
    		if (value.equals(front.data)) {  // if value in the first node
    			front = front.next;
    			if (size == 0)				 // if it was the only node
    				back = null;
    			size--;
    		}
    		else {							  // value not in the first node
    			ListNode<E> prior = front;	  // set up a trailing reference
    	        while (prior.next != null) {   // look ahead one node
    	            if (prior.next.data.equals(value)) { // found it
    	            	prior.next = prior.next.next;
    	            	if (prior.next == null)    // if deleting the last node
    	            		back = prior;
    	            	size--;
    	            	break;
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
    public int getIndex(E value) {
        int index = 0;
        ListNode<E> current = front;
        while (current != null) {
            if (current.data.equals(value)) {
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
     * @param index <= size and index >= 0
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     */
    public void removeAtIndex(int index) {
        checkIndex(index);
        if (index == 0) {
            front = front.next;
            if (size == 0)
                back = null;
        }
        else {
            ListNode<E> current = nodeAt(index - 1);
            current.next = current.next.next;
            if (current.next == null)
                back = current;
        }
        
        size--;
    }
    
    /**
     * Replaces the value at the given index with the given value.
     * 
     * @param 0 <= index <=size
     * @param value is assigned
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     */
    public void set(int index, E value) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        current.data = value;
    }
    
    /**
     * Returns the value at the given index in the list.
     * 
     * @param 0 <= index <=size
     * @throws IndexOutOfBoundsException if index < 0 or index > size
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
    private static class ListNode<E> {

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
            LinkedListUnsorted.this.remove(prior.data);
            removeOK = false;
        }
    }

    
}

