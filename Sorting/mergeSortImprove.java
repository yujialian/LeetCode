public class mergeSort {
    /* If array is nearly ordered, or ordered, mergesort is worse than insertion sort, because inner loop of insertion sort never or barely been executed. */
    public void MergeSort(int[] arr) {
        /*We can use insertion sort if array is comparatively small, because if array is small, there is a chance that the array itself is nearly sorted, plus, even through merge sort is a*nlogn, insertion sort is b*n^2, but since a > b, when n is small, insertion sort is faster than merge sort.*/
        merge_sort(arr, 0, arr.length - 1);
    }
    public void merge_sort(int[] arr, int l, int r) {
        if(l >= r) return;
        if(r - l <= 15) {
            insertionSort(arr, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        merge_sort(arr, l, mid);
        merge_sort(arr, mid + 1, r);
        /*it's better to add if statement if dealing with nearly ordered array.*/
        if(arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }
    public void merge(int[] arr, int l, int mid, int r) {
        if(l >= r) return;
        int[] aux = new int[r - l + 1];
        for(int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int i = l, j = mid + 1;
        for(int k = l; k <= r; k++) {
            if(i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if(j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if(aux[i - l] > aux[j - l]) {
                arr[k] = aux[j - l];
                j++;
            } else {
                arr[k] = aux[i - l];
                i++;
            }
        }
    }

    public void insertionSort(int[] arr, int l, int r) {
        if(l >= r) return;
        for(int i = l; i <= r; i++) {
            int j  = i + 1;
            int k = i;
            for(j = i - 1; j > 0 && arr[j - 1] > arr[k]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = arr[k];
        }
    }

    public static void main(String[] args) {
        mergeSort mr = new mergeSort();
        int[] arr = new int[] {10,7,4,8,3,5,7,1,8,4};
        mr.MergeSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}


