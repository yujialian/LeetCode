public class binarySearch {
    public boolean BS(int[] arr, int target) {
        if(arr == null || arr.length == 0) return false;
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) return true;
            if(arr[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,4,6,7,8,9,19};
        binarySearch bs = new binarySearch();
        System.out.println("9 ? "+ bs.BS(arr, 9));
        System.out.println("19 ? " + bs.BS(arr, 19));
        System.out.println("2 ? " + bs.BS(arr, 2));
    }
}
