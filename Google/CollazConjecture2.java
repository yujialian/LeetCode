public class CollazConjecture2 {
    Map<Integer, Integer> map = new HashMap<>();

    public int findSteps(int num) {
        if(num <= 1) return 1;
        if(num % 2 == 1) num = num / 2;
        if(map.containsKey(num)) return map.get(num);
        else if(num % 2 == 0) num = num * 3 + 1;
        if(map.containsKey(num)) return map.get(num);
        int steps = findSteps(num);
        map.put(num, steps);
        return steps;
    }
    public int longestSteps(int num) {
        if(num < 0) return 0;
        int res = 0;
        for(int i = 1; i <= num; i++) {
            int t = findSteps(i);
            map.put(num, t);
            res = Math.max(res, t);
        }
        return res;
    }
}
