public class mergeSortBottomUp {
    public void mergeSortBU(int[] arr) {
        for(int step = 1; step < arr.length; step = step + step) {
            for(int i = 0; i + step < arr.length; i += step + step) {
                __merge(arr, i, i + step - 1, Math.min(i + step + step - 1, arr.length - 1));
            }
        }
    }
    private void __merge(int[] arr, int l, int mid, int r) {
        int[] newArr = new int[(r - l) + 1];
        for(int i = l; i <= r; i++) {
            newArr[i - l] = arr[i];
        }
        int start1 = l, start2 = mid + 1;
        int index = l;
        while(start1 <= mid && start2 <= r) {
            if(newArr[start1 - l] > newArr[start2 - l]) {
                arr[index++] = newArr[start2 - l];
                start2++;
            } else {
                arr[index++] = newArr[start1 - l];
                start1++;
            }
        }
        while(start1 <= mid) {
            arr[index++] = newArr[start1 - l];
            start1++;
        }
        while(start2 <= r) {
            arr[index++] = newArr[start2 - l];
            start2++;
        }
    }
    public static void main(String[] args) {
        mergeSortBottomUp mr = new mergeSortBottomUp();
        int[] arr = new int[] {10,7,4,8,3,5,7,1,8,4, 123, 33, 22, 55, 7, 55, 2, 0, 1};
        mr.mergeSortBU(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
