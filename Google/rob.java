//198
class Solution {
    public int rob(int[] nums) {
        int prevRob = 0;//Not rob prevous house.
        int currRob = 0;//Rob prevous house.
        for(int i = 0; i < nums.length; i++) {
            int temp = currRob;//If rob previous house, current house can not be robbed.
            currRob = Math.max(nums[i] + prevRob, currRob);//curr max rob amount equals to not rub prevous house rub current house or ruby previous house not rob current house.
            prevRob = temp;//rub prevous house not rub current house.
        }
        return currRob;
    }
}
//I think below solution is much more understandble compare to above.
//Given credit to https://leetcode.com/problems/house-robber/discuss/55695/JAVA-DP-Solution-O(n)-runtime-and-O(1)-space-with-inline-comment
/*
public int rob(int[] num) {
    int rob = 0; //max monney can get if rob current house
    int notrob = 0; //max money can get if not rob current house
    for(int i=0; i<num.length; i++) {
        int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
        notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
        rob = currob;
    }
    return Math.max(rob, notrob);
}
*/
