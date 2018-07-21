class Solution {
    public int removeDuplicates(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int k = 0, times = 0, prev = arr[0], idx = 0;
        while(idx < arr.length) {
            if(arr[idx] == prev) {
                if(times < 2) {
                    swap(arr, idx, k++);
                    times++;
                    idx++;
                } else {
                    while(idx < arr.length && arr[idx] == prev) idx++;
                    times = 0;
                }
            } else {
                prev = arr[idx];
                swap(arr, idx, k++);
                times = 1;
                idx++;
            }
        }
        return k;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class Solution {
    public int removeDuplicates(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int k = 0;
        for(int n: arr) {
            if(k < 2 || arr[k - 2] < n) arr[k++] = n;
        }
        return k;
    }
}

