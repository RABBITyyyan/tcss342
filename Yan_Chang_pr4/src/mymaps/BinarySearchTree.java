package mymaps;

//BinarySearchTree class
//
//CONSTRUCTION: with no initializer
//
//******************PUBLIC OPERATIONS*********************
//void put( x, y )       --> Insert a node containing key x and value y
//void remove( x )       --> Remove x
//void removeMin( )      --> Remove minimum item
//Comparable find( x )   --> Return item that matches x
//Comparable findMin( )  --> Return smallest item
//Comparable findMax( )  --> Return largest item
//boolean isEmpty( )     --> Return true if empty; else false
//void makeEmpty( )      --> Remove all items
//******************ERRORS********************************
//Exceptions are thrown by insert, remove, and removeMin if warranted

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss, Chang Yan
 */
public class BinarySearchTree<AnyKey extends Comparable<AnyKey>, AnyValue> implements MyMap<AnyKey, AnyValue>
{
    
    /** The tree root. */
    private BinaryNode<AnyKey, AnyValue> root;
    
    /**
     * Construct the tree.
     */
    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * Insert into the tree.
     * @param x the item to insert.
     * @throws DuplicateItemException if x is already present.
     */
    @Override
    public void put( AnyKey x, AnyValue y )
    {
        root = put( x, y, root );
    }

    /**
     * Remove from the tree.
     * If an item is removed, we are to remove the node.
     * @param x the key to remove.
     * @throws ItemNotFoundException if x is not found.
     */
    public void remove( AnyKey x )
    {
        root = remove( x, root );
    }

    /**
     * Remove minimum item from the tree.
     * @throws ItemNotFoundException if tree is empty.
     */
    public void removeMin( )
    {
        root = removeMin( root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyKey findMin( )
    {
        return elementAt( findMin( root ) );
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public AnyKey findMax( )
    {
        return elementAt( findMax( root ) );
    }

    /**
     * Returns a value associated with a key.
     * @param x is the key
     * @return the value associated with the key
     */
    @Override
    public AnyValue get( AnyKey x )
    {	
    	if(x == null) {
    		throw new IllegalArgumentException();
    	}
    	
    	else {
    		return get(x, root);
    	}	
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Internal method to get key field.
     * @param t the node.
     * @return the key field or null if t is null.
     */
    private AnyKey elementAt( BinaryNode<AnyKey, AnyValue> t )
    {
        return t == null ? null : t.key;
    }

    /**
     * Internal method to insert into a subtree.
     * (if an item is already in the dictionary/map, 
     * do not add a new node but rather replace the 
     * value in the existing node that matches the specified key)
     * @param x the key to insert.
     * @param y the value to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws DuplicateItemException if x is already present.
     */
    private BinaryNode<AnyKey, AnyValue> put( AnyKey x, AnyValue y, BinaryNode<AnyKey, AnyValue> t )
    {
        if( t == null )
            t = new BinaryNode<AnyKey, AnyValue>( x, y );
        else if( x.compareTo( t.key ) < 0 )
            t.left = put( x, y, t.left );
        else if( x.compareTo( t.key ) > 0 )
            t.right = put( x, y, t.right );
        else
        	t.value = y; // Duplicate
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if x is not found.
     */
    private BinaryNode<AnyKey, AnyValue> remove( AnyKey x, BinaryNode<AnyKey, AnyValue> t )
    {
        if( t == null )
            throw new IllegalArgumentException( x.toString( ) );
        if( x.compareTo( t.key ) < 0 )
            t.left = remove( x, t.left );
        else if( x.compareTo( t.key ) > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.key = findMin( t.right ).key;
            t.value = findMin( t.right ).value;
            t.right = removeMin( t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to remove minimum item from a subtree.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if t is empty.
     */
    private BinaryNode<AnyKey, AnyValue> removeMin( BinaryNode<AnyKey, AnyValue> t )
    {
        if( t == null )
            throw new IllegalArgumentException( );
        else if( t.left != null )
        {
            t.left = removeMin( t.left );
            return t;
        }
        else
            return t.right;
    }    

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyKey, AnyValue> findMin( BinaryNode<AnyKey, AnyValue> t )
    {
        if( t != null )
            while( t.left != null )
                t = t.left;

        return t;
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyKey, AnyValue> findMax( BinaryNode<AnyKey, AnyValue> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to check to if the bst contains the key that is given. If it does then 
     * the value associated with the key is returned. 
     * If not then a null pointer is returned.
     * @param  x is the key.
     * @param t the node that roots the tree.
     * @return Returns the value at the given key if found, or null if not.
     */
    private AnyValue get( AnyKey x, BinaryNode<AnyKey, AnyValue> t ) {
        while( t != null ) {
            if( x.compareTo( t.key ) < 0 )
                t = t.left;
            else if( x.compareTo( t.key ) > 0 )
                t = t.right;
            else
                return t.value;    // Match
        }
        return null;         // Not found
    }

    /**
     * Method to return the inorder traversal of the binary tree as a sequence of strings.
     * @return an inorder traversal as a string
     */
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder("{");
    	toString(sb, root);
    	sb.replace(sb.length() - 2, sb.length(), "}");
    	return sb.toString();
    }
    
    /**
     * Internal method of inorder traversal of the binary tree as a sequence of strings.
     * @param the StringBuilder.
     * @param cur the node.
     */
    private void toString(StringBuilder sb, BinaryNode<AnyKey, AnyValue> cur) {
    	if (cur.left != null)
    		toString(sb, cur.left);
    	if (cur != null) {
    		sb.append(cur.key.toString());
    		sb.append('=');
    		sb.append(cur.value.toString());
    		sb.append(", ");
    	}        
    	if (cur.right != null)
    		toString(sb, cur.right);
    } 
    
    // Test program
    public static void main( String [ ] args )
    {
    	BinarySearchTree<Integer, Integer> t = new BinarySearchTree<Integer, Integer>( );
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.put( i, i );

        for( int i = 1; i < NUMS; i += 2 )
            t.remove( i );

        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i += 2 )
            if( t.get( i ) != i )
                System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i += 2 )
            if( t.get( i ) != null )
                System.out.println( "Find error2!" );
    }
}