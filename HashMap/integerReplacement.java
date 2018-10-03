class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        if(map.containsKey(n)) return map.get(n);
        if(n <= 1) return 0;
        if(n >= Integer.MAX_VALUE) return 32;
        int min = Integer.MAX_VALUE;
        if(n % 2 == 0) {
            min = 1 + integerReplacement(n / 2);
            map.put(n, min);
            return min;
        } else {
            min = Math.min(min, integerReplacement(n + 1) + 1);
            min = Math.min(min, integerReplacement(n - 1) + 1);
            map.put(n, min);
            return min;
        }
    }
}
