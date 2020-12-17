public class Sorts {

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**Bubble sort of an int array.
    *Upon completion, the elements of the array will be in increasing order.
    *@param data  the elements to be sorted.
    */
    public static void bubbleSort(int[] data) {
        int endAt = data.length;
        boolean unsorted;
        do {
            unsorted = false;
            for (int i = 1; i < endAt; i++) {
                if (data[i] < data[i-1]) {
                    unsorted = true;
                    swap(data, i, i-1);
                }
            }
            endAt--;
        } while (unsorted);
    }

    /**Selection sort of an int array.
    *Upon completion, the elements of the array will be in increasing order.
    *@param data  the elements to be sorted.
    */
    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int smallestIndex = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < data[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            swap(data, i, smallestIndex);
        }
    }

    /**Insertion sort of an int array.
    *Upon completion, the elements of the array will be in increasing order.
    *@param data  the elements to be sorted.
    */
    public static void insertionSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int insertIndex = i;
            // scans & shifts, both in the same loop
            // from back to front, for O(n) best case
            while (insertIndex > 0 && data[insertIndex-1] > value) {
                data[insertIndex] = data[insertIndex-1];
                insertIndex--;
            }
            data[insertIndex] = value;
        }
    }

}
