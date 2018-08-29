public class 2Sum2Pointers {
	class Solution {
		public int[] twoSum(int[] arr, int target) {
			int i = 0, j = arr.length -1;
			while(i < j) {
				int curSum = arr[i] + arr[j];
				if(curSum == target) return new int[] {i+1, j+1};
				else if(curSum > target) j--;
				else i++;
			}
			return new int[]{};
		}
	}
}
