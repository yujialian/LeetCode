class Solution {
    public int removeElement(int[] arr, int val) {
        int k = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != val) {
                if(i != k) swap(arr, i, k++);
                else k++;
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
