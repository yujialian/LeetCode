class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(set.add(n)) {
            int curN = 0;
            while(n != 0) {
                int curDigit = n % 10;
                curN += curDigit * curDigit;
                n = n / 10;
            }
            if(curN == 1) return true;
            n = curN;
        }
        return false;
    }
}
