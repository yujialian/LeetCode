class Solution {
    public int removeDuplicates(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int k = 1;
        int prev = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != prev) {
                prev = arr[i];
                if(i != k) {
                    swap(arr, i, k++);
                } else{
                    k++;
                }
            }
        }
        return k;
    }
    private void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}

class Solution {
    public int removeDuplicates(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int k = 0;
        for(int n: arr) {
            if(k < 1 || arr[k-1] < n) arr[k++] = n;
        }
        return k;
    }
}
