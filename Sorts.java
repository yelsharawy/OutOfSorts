public class Sorts {
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
                    int temp = data[i];
                    data[i] = data[i-1];
                    data[i-1] = temp;
                }
            }
            endAt--;
        } while (unsorted);
    }
}
