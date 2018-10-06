class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if(A == null || A.length == 0) return -1;
        int l = 0, r = A.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(A[mid] < A[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
