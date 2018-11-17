import java.util.*;
public class quickSortNaive {
    public static void quickSort(Integer[] arr) {
        __quickSort(arr, 0, arr.length - 1);
    }
    private quickSortNaive() {};
    private static void __quickSort(Integer[] arr, int l, int r) {
        if(l <= r) return;
        int p = __partition(arr, l, r);
        __quickSort(arr, l, p);
        __quickSort(arr, p + 1, r);
    }
    private static int __partition(Integer[] arr, int l, int r) {
        int pivot = arr[l];
        int j = l;
        for(int i = l + 1; i <= r; i++) {
            if(arr[i].compareTo(pivot) < 0) {
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
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
        quickSortNaive.quickSort(test);
        for(int i = 0; i < test.length; i++) {
            System.out.println("Sorted:" + test[i]);
        }
		int N = 1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("quickSortNaive", arr);

		return;
	}
}
