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
}
