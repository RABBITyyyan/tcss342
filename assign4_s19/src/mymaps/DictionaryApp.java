package mymaps;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;
    
/**
    Program to read in strings from a file
    and insert them into a dictionary.
    
    @author Donald Chinn, Monika Sobolewska
    @version 2019

    Flags:
      -b  binary search tree
      -v  AVL tree
      -h  hash map
      -j  Java built-in class TreeMap
      -x  do nothing
*/
public class DictionaryApp {
    
    // static variables used to identify the
    // data structure/algorithm to use
    // (based on the command line argument)
    private static final int NOALG = 0;
    private static final int useBST = 1;
    private static final int useAVL = 2;
    private static final int useHash = 3;
    private static final int useJavaTreeMap = 4;
    private static final int useNothing = 7;
        
    /**
     * Return the next word in a file.
     * @param file  the file to read from
     * @return  the next word in the file of length > 2, or null if there is no next word
     * A word is defined here as a consecutive sequence of alphanumeric characters.
     */
    private static String getWord(Scanner file) {
       String word = null;
       while (file.hasNext()) {
           word = file.next();
           word = word.replaceAll("\\W", "").toLowerCase();
           if (word.length() > 2)
               break;
       }
       if (word != null && word.length() < 3 ) word = null;
       return word;
       
    }
    
    /**
     * The driver method for the word counting application.
     */
    public static void main(String[] args) {
        boolean error = false;

        // timer variables
        long totalTime = 0;
        long startTime = 0;
        long finishTime = 0;
        int numInsertions = 0;

        int whichAlgorithm = NOALG;
    
        Scanner infile = null;
        
 //       MyMap<String, Integer> bst = new BinarySearchTree<String, Integer>();
 //		  MyMap<String, Integer> avl = new AvlTree<String, Integer>();
 //	      MyMap<String, Integer> hash = new HashTable<String,Integer>();       
        TreeMap<String, Integer> javaTreeMap = new TreeMap<String, Integer>();
    
        // Handle command line arguments.
        // Usage: -[bvhjx] input_filename
        // Options:
        //   -b  use a standard binary search tree
        //   -v  use the recursive implementation of an AVL tree
        //   -h  use quadratic probing hash map
        //   -j  Java built-in class TreeMap

        //   -x  no data structure (just read in the file)
        
        if ((args.length < 2) || (args.length > 2)) {
            System.out.println("Argument usage: -[bvhjx] infile");
            error = true;
        } else {
            // figure out which option was chosen
            if (args[0].charAt(0) == '-') {
                switch (args[0].charAt(1)) {
                    case 'b':
                        whichAlgorithm = useBST;
                        break;
    
                    case 'v':
                        whichAlgorithm = useAVL;
                        break;
    
                    case 'h':
                        whichAlgorithm = useHash;
                        break;
                    
                    case 'j':
                        whichAlgorithm = useJavaTreeMap;
                        break;
                    
                    case 'x':
                        whichAlgorithm = useNothing;
                        break;
            
                    default:
                        System.out.print ("Usage: ");
                        System.out.println("-" + args[0].charAt(1) + " is not a valid option.");
                        error = true;
                        break;
                }
    
                // Get the input filename
                try {
                    infile = new Scanner(Paths.get(args[1]));
                }
                catch (IOException ioexception) {
                  System.out.println("Error: Could not open " + args[1] + ".");
                  error = true;
                }
            } else {
                System.out.println("Argument usage: -[bvsjx] filename");
                error = true;
            }
        }
    
        if (!error) {
        	
        	
        	String currentWord;
    		Integer numTimes;   // the number of times a key has been encountered so far
    		Date startDate;
    		Date finishDate;
        	
    		// start the timer
    		startDate = new Date();
    		startTime = startDate.getTime();

    		while ((currentWord = DictionaryApp.getWord(infile)) != null) {
    			switch (whichAlgorithm) {
    			case useBST:
    				// your code here
    				break;

    			case useAVL:
    				// your code here
    				break;

    			case useHash:
    				// your code here
    				break;

    			case useJavaTreeMap:
    				numTimes = javaTreeMap.get(currentWord);
    				if(numTimes == null)
    					numTimes = 0;
    				numTimes++;
    				javaTreeMap.put(currentWord, numTimes);
    				numInsertions++;
    				break;

    			case useNothing:
    				// do nothing
    				numInsertions++;
    				break;
    			} // end switch
    		} // end while

    		// stop the insertion timer
    		finishDate = new Date();
    		finishTime = finishDate.getTime();
    		totalTime = (finishTime - startTime);


    		System.out.println("** Results for " + args[0]  + " option on file ");
    		System.out.println("    " + args[1]);
    		System.out.println("Time to do insertions: ");
    		System.out.println(totalTime + " ms.");
    		System.out.println("Number of insertions: " + numInsertions);

    		switch (whichAlgorithm) {
    		/*             case useBST:
                    System.out.println(bst);
                    break;/*
                case useAVL:
                    System.out.println(avl);
                    break;
                case useHash:
                    System.out.println(hash);
                    break;*/

    		case useJavaTreeMap:
    			//System.out.println(javaTreeMap);
    			break;
    		case useNothing:
    			// do nothing
    			break;
    		} // end switch       

    		System.out.println("Time to print the tree: ");
    		System.out.println(" ms.");


        } // end if
        infile.close();

        System.out.println("DictionaryApp is done. **");
    }
    
}
