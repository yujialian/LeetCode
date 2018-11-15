public class insertionSort<E extends Comparable<E>> {
    public void insertionSort(E[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(j, j - 1, arr);
                }
            }
        }
    }
    private void swap(int i, int j, E[] arr) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        insertionSort<Integer> test = new insertionSort<>();
        Integer[] arr = new Integer[] {5,7,1,3,7,9,5,2,6};
        test.insertionSort(arr);
        for(int k: arr) {
            System.out.println(k);
        }
    }
}
