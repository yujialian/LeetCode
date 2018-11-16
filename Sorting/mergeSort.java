public class mergeSort {
    /* If array is nearly ordered, or ordered, mergesort is worse than insertion sort, because inner loop of insertion sort never or barely been executed. */
    public void MergeSort(int[] arr) {
        __MergeSort(arr, 0, arr.length - 1);
    }
    private void __MergeSort(int[] arr, int l, int r) {
        if(l >= r) return;
        int mid = l + (r - l) / 2;
        __MergeSort(arr, l, mid);
        __MergeSort(arr, mid + 1, r);
        __merge(arr, l, r);
    }
    private void __merge(int[] arr, int l, int r) {
        if(l >= r) return;
        int[] newArr = new int[r - l + 1];
        for(int i = l; i <= r; i++) newArr[i - l] = arr[i];
        int mid = l + (r - l) / 2;
        int f = l, s = mid + 1;
        int index = l;
        while(f <= mid && s <= r) {
            if(newArr[f - l] > newArr[s - l]) {
                arr[index++] = newArr[s - l];
                s++;
            } else {
                arr[index++] = newArr[f - l];
                f++;
            }
        }
        while(f <= mid) {
            arr[index++] = newArr[f - l];
            f++;
        }
        while(s <= r) {
            arr[index++] = newArr[s - l];
            s++;
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


