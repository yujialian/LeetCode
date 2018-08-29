public class 2SumBrutalForce {
    public int[] 2Sum(int[] arr, int target) {
        if(arr == null || arr.length == 0) return new int[] {};
        for(int i = 0; i < arr.length; i++) {
            int cur = target - arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] == cur) return new int[] { i+1, j+1 };
            }
        }
        return new int[]{}
    }
}
