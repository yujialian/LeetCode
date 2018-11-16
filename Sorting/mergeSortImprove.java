public class mergeSortImprove {
    /* If array is nearly ordered, or ordered, mergesort is worse than insertion sort, because inner loop of insertion sort never or barely been executed. */
    public void mergeSortImprove(int[] arr) {
        /*We can use insertion sort if array is comparatively small, because if array is small, there is a chance that the array itself is nearly sorted, plus, even through merge sort is a*nlogn, insertion sort is b*n^2, but since a > b, when n is small, insertion sort is faster than merge sort.*/
        if(arr.length <= 15) {
            __insertionSort(arr);
            return;
        }
        _mergeSort(arr, 0, arr.length - 1);
    }
    public void _mergeSort(int[] arr, int l, int r) {
        if(l >= r) return;
        int mid = l + (r - l) / 2;
        _mergeSort(arr, l, mid);
        _mergeSort(arr, mid + 1, r);
        /*it's better to add if statement if dealing with nearly ordered array.*/
        if(arr[mid] > arr[mid + 1]) {
            _merge(arr, l, r);
        }
    }
    private void _merge(int[] arr, int l, int r) {
        if(r >= l) return;
        int[] newArr = new int[r - l + 1];
        for(int i = l; i <= r; i++) {
            newArr[i - l] = arr[i];
        }
        int index = l;
        int mid = l + (r - l) / 2;
        int m = l, n = mid + 1;
        while(m <= mid && n <= r) {
            if(newArr[m - l] > newArr[n - l]) {
                arr[index++] = newArr[m - l];
                m++;
            } else {
                arr[index++] = newArr[n - l];
                n++;
            }
        }
        while(m <= mid) {
            arr[index++] = newArr[m - l];
        }
        while(n <= r) {
            arr[index++] = newArr[n - l];
        }
    }
    private void __insertionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int j;
            for(j = i; j > 0; j--) {
                if(curr < arr[j - 1]) arr[j] = arr[j - 1];
                else break;
            }
            arr[j] = curr;
        }
    }

    public static void main(String[] args) {
        mergeSort mr = new mergeSort();
        int[] arr = new int[] {10,7,4,8,3,5,7,1,8,4, 123, 33, 22, 55, 7, 55, 2, 0, 1};
        mr.MergeSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}


