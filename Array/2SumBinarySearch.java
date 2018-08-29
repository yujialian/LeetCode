class Solution {
    public int[] twoSum(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            int idx = binarySearch(arr, i, target - arr[i]);
            if(idx != -1) return new int[] {i + 1, idx + 1};
        }
        return new int[] {};
    }
    private int binarySearch(int[] arr, int idx, int target) {
        int l = idx + 1, r = arr.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return arr[r] == target ? r : -1;
    }
}
