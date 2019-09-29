package mymaps;

import java.io.Serializable;

/**
 * HashTable implementation.
 * Matches are based on equals; and hashCode must be consistently defined.
 * @author Chang Yan
 */
public class HashTable<AnyKey, AnyValue> implements MyMap<AnyKey, AnyValue> {
    /**
     * Construct an empty HashTable.
     */
    public HashTable( )
    {
        allocateArray( DEFAULT_TABLE_SIZE );
        clear( );
    }  
    
    /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        return currentSize;
    }
    
    /**
     * Returns a string representation of this <tt>Hashtable</tt> object
     * in the form of a set of entries, enclosed in braces and separated
     * by the ASCII characters "<tt>,&nbsp;</tt>" (comma and space). Each
     * entry is rendered as the key, an equals sign <tt>=</tt>, and the
     * associated element, where the <tt>toString</tt> method is used to
     * convert the key and element to strings.
     *
     * @return  a string representation of this hashtable
     */
	@Override
    public String toString() {
        int max = size();
        if (max == 0)
            return "{}";

        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 1; i <  array.length; i++) {
        	if (array[ i ] != null) {
        		sb.append( array[ i ].key.toString());
                sb.append('=');
                sb.append( array[ i ].value.toString());
                sb.append(", ");
        	}         
        }       
        sb.replace(sb.length() - 2, sb.length(), "}");  
		return sb.toString();
    }
    
    /**
     * Checks if x is in the set.
     * If it is, it returns the reference to the matching
     * key; otherwise it returns null.
     * @param x the key to search for.
     * @return if contains(x) is false, the return value is null;
     * otherwise, the return value is the value given the key.
     */
    @SuppressWarnings("unchecked")
	@Override
    public AnyValue get( AnyKey x )
    {
        int currentPos = findPos( x );

        if( isActive( array, currentPos ) )
            return (AnyValue) array[ currentPos ].value;
        return null;
    }
    
    /**
     * Tests if item in pos is active.
     * @param pos a position in the hash table.
     * @param arr the HashEntry array (can be oldArray during rehash).
     * @return true if this position is active.
     */
    @SuppressWarnings("rawtypes")
	private static boolean isActive( HashEntry [ ] arr, int pos )
    {
        return arr[ pos ] != null && arr[ pos ].isActive;
    }
    
    /**
     * Adds an item to this collection.
     * @param x is the key.
     * @param y is the value.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void put( AnyKey x, AnyValue y )
    {
    	int currentPos = findPos( x );
    	if( isActive( array, currentPos ) ) {
    		array[ currentPos ].value = y;
    	} else {
    		if( array[ currentPos ] == null ) 
    			occupied++;
    		array[ currentPos ] = new HashEntry( x, y, true );
    		currentSize++;
    		modCount++;
    		if( occupied > array.length / 2 )        
    			rehash( );
    	}

    }
    
    /**
     * Private routine to perform rehashing.
     * Can be called by both add and remove.
     */
    @SuppressWarnings("unchecked")
	private void rehash( )
    {
        @SuppressWarnings("rawtypes")
		HashEntry [ ] oldArray = array;
        
            // Create a new, empty table
        allocateArray( nextPrime( 4 * size( ) ) );
        currentSize = 0;
        occupied = 0;
        
            // Copy table over
        for( int i = 0; i < oldArray.length; i++ )
            if( isActive( oldArray, i ) ) 
                put( (AnyKey) oldArray[ i ].key, (AnyValue) oldArray[ i ].value );
    }
    
    /**
     * Removes an item from this collection.
     * @param x any key.
     * @return true if this item was removed from the collection.
     */
    @SuppressWarnings("unchecked")
	public void remove( AnyKey x )
    {
        int currentPos = findPos( x );
        if( isActive( array, currentPos ) ) {
        	array[ currentPos ].isActive = false;
        	array[ currentPos ].key = null;
        	array[ currentPos ].value = null;
            currentSize--;
            modCount++;          
            if( currentSize < array.length / 8 )
                rehash( );
        }
    }
    
    /**
     * Change the size of this collection to zero.
     */
    public void clear( )
    {
        currentSize = occupied = 0;
        modCount++;
        for( int i = 0; i < array.length; i++ )
            array[ i ] = null;
    }
    
    private static class HashEntry<AnyKey, AnyValue> implements Serializable
    {
		private static final long serialVersionUID = -9101211879569431578L;
		public AnyKey  key;   // the key
        public AnyValue  value;   // the value
        public boolean isActive;  // false if marked deleted

        @SuppressWarnings("unused")
		public HashEntry( AnyKey AnyKey, AnyValue AnyValue )
        {
            this( AnyKey, AnyValue, true );
        }

        public HashEntry( AnyKey theKey, AnyValue theValue, boolean i )
        {
            key  = theKey;
            value = theValue;
            isActive = i;
        }
    }
    
    
    /**
     * Method that performs quadratic probing resolution.
     * Assumes table is at least half-empty.
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    private int findPos( AnyKey x )
    {
        int offset = 1;
        int currentPos = ( x == null ) ? 0 : Math.abs( x.hashCode( ) % array.length );

        while( array[ currentPos ] != null )
        {
            if( x == null )
            {
                if( array[ currentPos ].key == null )
                    break;
            }
            else if( x.equals( array[ currentPos ].key ) )   
                break; 
            
            currentPos += offset;                  // Compute ith probe
            offset += 2;
            if( currentPos >= array.length )       // Implement the mod
                currentPos -= array.length;
        }

        return currentPos;
    }
    
    
    /**
     * Internal method to allocate array.
     * @param arraySize the size of the array.
     */
    private void allocateArray( int arraySize )
    {
        array = new HashEntry[ nextPrime( arraySize ) ];
    }

    /**
     * Internal method to find a prime number at least as large as n.
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }
    
    private static final int DEFAULT_TABLE_SIZE = 101;
    
    private int currentSize = 0;
    private int occupied = 0;
    private int modCount = 0;
    @SuppressWarnings("rawtypes")
	private HashEntry [ ] array;
		
}
