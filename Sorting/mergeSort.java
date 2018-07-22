public class mergeSort {
    /* If array is nearly ordered, or ordered, mergesort is worse than insertion sort, because inner loop of insertion sort never or barely been executed. */
    public void MergeSort(int[] arr) {
        merge_sort(arr, 0, arr.length - 1);
    }
    public void merge_sort(int[] arr, int l, int r) {
        if(l >= r) return;
        int mid = l + (r - l) / 2;
        merge_sort(arr, l, mid);
        merge_sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
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
    public static void main(String[] args) {
        mergeSort mr = new mergeSort();
        int[] arr = new int[] {10,7,4,8,3,5,7,1,8,4};
        mr.MergeSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}


