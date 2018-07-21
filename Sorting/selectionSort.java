public class selectionSort {
    void selection(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) min = j;
            }
            swap(arr, min, i);
        }
    }
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        selectionSort test = new selectionSort();
        int[] arr = new int[] {5,7,1,3,7,9,5,2,6};
        test.selection(arr);
        for(int k: arr) {
            System.out.println(k);
        }
    }
}




