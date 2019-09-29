package mybagpackage;

import java.util.Iterator;

/**
 * Represents MyBag interface.
 * 
 * @author Monika
 * @version Spring 2019
 * @param <Type> is of any object type.
 */
public interface MyBag<Type> {

    /**
     * Returns the current number of elements in the bag.
     * 
     * @return the current number of elements in the bag >= 0
     */
    public int getSize();

    /**
     * Returns whether the bag is empty.
     * 
     * @return true if bag is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Returns whether value is in the bag.
     * 
     * @param value assigned
     * @return true if value in the bag, false otherwise.
     */
    public boolean contains(Type value);

    /**
     * Inserts an element into the bag.
     * 
     * @param value assigned
     */
    public void insert(Type value);

    
    /**
     * Clears the bag.
     */
    public void clear();
    
    /**
     * Returns a string representation of bag contents.
     * 
     * @return a string representation of bag contents.
     * @see Object#toString()
     */
    @Override
    public String toString();
    
    /**
     * Removes first element occurrence from the bag.
     * 
     * @param value assigned
     */
    public void remove(Type value);
    
    /*********************************************
     * Index bag methods follow
     *********************************************/

    /**
     * Returns the index of value.
     * 
     * @param value assigned.
     * @return index of value if in the bag, -1 otherwise.
     */
    public int getIndex(Type value);

    
    /**
     * Removes value at the given index.
     * 
     * @param  0 <= index <= size
     * @throws IndexOutOfBoundsException if index < 0 or index >= size
     */
    public void removeAtIndex (int index);
    
    /**
     * Replaces the value at the given index with the given value.
     * 
     * @param 0 <= index <= size
     * @value is assigned
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     */
    public void set(int index, Type value);
    
    /**
     * Returns the value at the given index in the bag.
     * 
     * @param index 0 <= index <= size
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     * @return the value at the given index in the bag.
     */
    
    public Type get(int index);
    
    /*********************************************
     * Index bag methods end
     *********************************************/

    /*********************************************
     * Iterator bag class / methods follow
     *********************************************/

    /**
     * Returns an iterator for this bag.
     * 
     * @return an iterator for the bag.
     */
    public Iterator<Type> iterator();
    
    /*********************************************
     * Iterator bag class / methods end
     *********************************************/
    
    

}
