public class insertionSort {
    /*Insertion sort have an advantage over selection sort, that is it can end inner loop eailer when cur < arr[j - 1] is not satisfied. */
    void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j;
            for(j = i; j > 0 && cur < arr[j-1]; j--) {
            //One swap operation is 3 times assignment, we want to minimize assignment to reduce time complexity.
                    arr[j] = arr[j-1];
                }
            arr[j] = cur;
            }
        }
    }
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        insertionSort test = new insertionSort();
        int[] arr = new int[] {5,7,1,3,7,9,5,2,6};
        test.insertionSort(arr);
        for(int k: arr) {
            System.out.println(k);
        }
    }
}
