public class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        assert(nums != null && nums.length >= 3);
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - sum);
        for(int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int curSum = nums[i] + nums[l] + nums[r];
                if(curSum == target) return curSum;
                else {
                    if(Math.abs(target - curSum) < diff) {
                        diff = Math.abs(target - curSum);
                        sum = curSum;
                    } else if(curSum > target) {
                        r--;
                    } else {
                        l++;
                    }

                }
            }
        }
        return sum;
    }
}
