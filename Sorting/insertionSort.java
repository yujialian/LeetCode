public class insertionSort {
    void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
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
