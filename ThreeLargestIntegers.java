import java.util.Arrays;

/**
 * A simple program taking no parameters that runs several predefined tests against an algorithm that prints 
 * the top 3 integers (highest to lowest) in an array.
 */
public class ThreeLargestIntegers {
    public static void main(String[] args) {
        // test method does it all.
        testPrintTopThree();

        System.out.println("\n\nAll done!\n");

    } 
    /**
     * Prints the top three integers, highest to lowest, in the passed array. 
     * @param arr array of  3 or more integers.
     * @throws ArrayLengthException if the array length is < 3 
     */
    public static void printTopThree(int[] arr) throws ArrayLengthException {
   
        int top1 = Integer.MIN_VALUE, top2 = Integer.MIN_VALUE, top3 = Integer.MIN_VALUE;

        if(arr.length < 3)
            throw new ArrayLengthException("Array has less than the required 3 elements! Length is " + arr.length);

        for(int i = 0; i < arr.length; i++){
            
            if(arr[i] > top1){
                // shift them down since we are replacing the top1. This keeps them in order.
                top3 = top2;
                top2 = top1;
                top1 = arr[i];
            }
            else if(arr[i] > top2){
                top3 = top2;
                top2 = arr[i];

            }
            else if(arr[i] > top3)
                top3 = arr[i];   // simple assignment if here             
  
        }

        System.out.println("\nLargest: " + top1 + "\nSecond largest: " + top2 + "\nThird largest: " + top3);
    }

    /**
     * Test for printTopThree 
     */
    public static void testPrintTopThree() {

        int[][] arr = {
            {1,15, 22, 2 -15, 7, 11, -30, 400},
            {400, -60, -50, 200, 21, 2000, 4, 8},
            {-40, -20, -116, -221, -50},
            {1, 2},
            {Integer.MIN_VALUE, 0, Integer.MAX_VALUE},
            {40, 100, 1, 100, 100},
            {200, 1, 200, 2, 1}
        };

        for(int i =0; i < arr.length; i++)
        {
            System.out.println("\n\nTest #" + (i +1) +  " printTopThree with this parameter: " + Arrays.toString(arr[i]));

            try {
        
                printTopThree(arr[i]);
                
            } catch (ArrayLengthException e) {
                System.out.println("Exception caught. Error: " + e.getMessage());
    
            }
        } 
    }
   
}  

class ArrayLengthException extends Exception {
    public ArrayLengthException(String message ) {
        super(message);
    }
}  
