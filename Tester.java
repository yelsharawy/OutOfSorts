import java.util.*;

public class Tester {

    public static interface Sorter {
        public void sort(int[] data);
    }

    public static String[] names = {"bubble sort", "selection sort", "insertion sort"};
    public static Sorter[] sorters = {Sorts::bubbleSort, Sorts::selectionSort, Sorts::insertionSort};

    public static boolean check(int[] nums) {
        boolean passed = true;
        int arrSize = nums.length;
        int[] sorted = Arrays.copyOf(nums, arrSize);
        Arrays.sort(sorted);

        for (int i = 0; i < sorters.length; i++) {
            Sorter sorter = sorters[i];
            int[] testArr = Arrays.copyOf(nums, arrSize);
            sorter.sort(testArr);
            if (!Arrays.equals(sorted, testArr)) {
                passed = false;
                System.out.println("\nFailure with "+names[i]+":");
                System.out.println("\tOriginal:\t"+Arrays.toString(nums));
                System.out.println("\tSorted:\t\t"+Arrays.toString(sorted));
                System.out.println("\tIncorrect:\t"+Arrays.toString(testArr));
            }
        }
        return passed;
    }

    private static final int seed = 10;
    private static final int trials = 100000;
    private static final int arrSize = 10;
    private static final int valRange = 100;

    public static boolean randomTest() {
        Random random = new Random(seed);
        for (int t = 0; t < trials; t++) {
            int[] nums = new int[arrSize];
            for (int i = 0; i < arrSize; i++) {
                nums[i] = random.nextInt(valRange);
            }
            if (!check(nums)) return false;
        }
        return true;
    }

    public static int[][] allPossible(int size) {
        int possCount = 1;
        for (int i = 1; i <= size; i++) {
           possCount *= size;
        }
        int[][] results = new int[possCount][size];
        for (int i = 1; i < possCount; i++) {
            System.arraycopy(results[i-1], 0, results[i], 0, size);
            for (int j = 0; ++results[i][j] == size; j++) {
                results[i][j] = 0;
            }
        }
        return results;
    }

    public static boolean thoroughTests() {
        for (int size = 0; size <= 8; size++) {
            System.out.print(size + "...");
            int[][] tests = allPossible(size);
            for (int[] test : tests) {
                if (!check(test)) {
                    System.out.println();
                    return false;
                }
            }
        }
        System.out.println();
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Random tests "+(randomTest() ? "passed" : "failed"));
        System.out.println("Thorough tests "+(thoroughTests() ? "passed" : "failed"));
    }

}
