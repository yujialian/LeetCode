public class insertionSortImprove<E extends Comparable<E>> {
    public void insertionSort(E[] arr) {
        for(int i = 0; i < arr.length; i++) {
            E currValue = arr[i];
            int j;
            for(j = i; j > 0; j--) {
                if(arr[j - 1].compareTo(currValue) > 0) arr[j] = arr[j - 1];
                else break;
            }
            arr[j] = currValue;
        }
    }
    public static void main(String[] args) {
        insertionSortImprove<Integer> test = new insertionSortImprove<>();
        Integer[] arr = new Integer[] {5,7,1,3,7,9,5,2,6};
        test.insertionSort(arr);
        for(int k: arr) {
            System.out.println(k);
        }
    }
}
