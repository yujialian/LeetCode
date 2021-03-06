public class quickSortThreeway {
	public quickSortThreeway() {}
    public static void quickSort(Integer[] arr) {
        __quickSort(arr, 0, arr.length - 1);
    }
    private static void __quickSort(Integer[] arr, int l, int r) {
        if(l >= r) return;
        int p = __partition(arr, l, r);
        __quickSort(arr, l, p - 1);
        __quickSort(arr, p + 1, r);
    }
    private static int __partition(Integer[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Integer pivot = arr[l];
        int lIndex = l;
        int rIndex = r + 1;
        int i = l + 1;
        while(i < rIndex) {
            if(arr[i].compareTo(pivot) > 0) {
                swap(arr, --rIndex, i);
            } else if(arr[i].compareTo(pivot) < 0) {
                swap(arr, ++lIndex, i++);
            } else {
                i++;
            }
        }
		return lIndex;
    }
    private static void swap(Integer[] arr, int i, int j) {
        Integer tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
   public static void main(String[] args) {

       // Quick Sort也是一个O(nlogn)复杂度的算法
       // 可以在1秒之内轻松处理100万数量级的数据
       Integer[] test = new Integer[10];
       for(int i = 9; i >= 0; i--) {
           test[i] = i;
       }
       quickSortThreeway.quickSort(test);
       for(int i = 0; i < test.length; i++) {
           System.out.println("Sorted:" + test[i]);
       }
       int N = 1000000;
       Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
       SortTestHelper.testSort("quickSortThreeway", arr);

       return;
   }
}
