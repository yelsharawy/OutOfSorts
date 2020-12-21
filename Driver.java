import java.util.*;

public class Driver {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("usage: java Driver SIZE ALGO [STYLE]");
            System.out.println("supported ALGO: bubble,selection,insertion,test");
            System.out.println("supported STYLE: random,equal,sorted,reversed");
        } else {

            int n = Integer.parseInt(args[0]);
            int[] randData = new int[n];

            Random random = new Random();
            //overhead: 1 random array generation.
            if (args.length < 3 || args[2].equals("random")) {
                for (int i = 0; i < n; i++) {
                    randData[i] = random.nextInt();
                }
            } else if (args[2].equals("equal")) {
                Arrays.fill(randData, random.nextInt());
            } else if (args[2].equals("sorted")) {
                // integers from -2^31 to 2^31-1, somewhat evenly spread
	            int value = Integer.MIN_VALUE;
                int incBy = 2*(Integer.MAX_VALUE/n);
                int maxInc = incBy;
                for (int i = 0; i < n; i++) {
                    int change = random.nextInt(maxInc);
                    value += change;
                    maxInc += incBy - change;
                    randData[i] = value;
                }
            } else if (args[2].equals("reversed")) {
                // same as "sorted" except filling from back to front
	            int value = Integer.MIN_VALUE;
                int incBy = 2*(Integer.MAX_VALUE/n);
                int maxInc = incBy;
                for (int i = n-1; i >= 0; i--) {
                    int change = random.nextInt(maxInc);
                    value += change;
                    maxInc += incBy - change;
                    randData[i] = value;
                }
            }

            if (args[1].equals("bubble")) {
                Sorts.bubbleSort(randData);
            }
            else if (args[1].equals("selection")) {
                Sorts.selectionSort(randData);
            }
            else if (args[1].equals("insertion")) {
                Sorts.insertionSort(randData);
            }

            //TEST MODE! This lets you see if your algorithm fails
            //for a particular type of array, or size of array.
            //This is not meant to be a timed test...
            else if (args[1].equals("test")) {

                int[] randDataBubble = Arrays.copyOf(randData,randData.length);
                int[] randDataSelection = Arrays.copyOf(randData,randData.length);
                int[] randDataInsertion = Arrays.copyOf(randData,randData.length);
                Arrays.sort(randData);
                Sorts.bubbleSort(randDataBubble);
                Sorts.selectionSort(randDataSelection);
                Sorts.insertionSort(randDataInsertion);

                if ( Arrays.equals(randData,randDataBubble)) {
                    System.out.println("Bubble Correct!");
                } else {
                    System.out.println("Bubble Not Correct!!!!!!!!!11oneeleven");
                }

                if ( Arrays.equals(randData,randDataSelection)) {
                    System.out.println("Selection Correct!");
                } else {
                    System.out.println("Selection Not Correct!!!!!!!!!11oneeleven");
                }

                if ( Arrays.equals(randData,randDataInsertion)) {
                    System.out.println("Insertion Correct!");
                } else {
                    System.out.println("Insertion Not Correct!!!!!!!!!11oneeleven");
                }
            }
        }
    }

}
