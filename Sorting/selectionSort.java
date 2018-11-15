public class selectionSort<E extends Comparable<E>> {
    public void selection(E[] arr) {
        if(arr == null || arr.length == 0) return;
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0) minIndex = j;
            }
            if(i != minIndex) swap(arr, minIndex, i);
        }
    }
    private void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        selectionSort<Integer> test = new selectionSort<>();
        Integer[] arr = new Integer[] {5,7,1,3,7,9,5,2,6};
        test.selection(arr);
        for(int k: arr) {
            System.out.println(k);
        }
    }
}




