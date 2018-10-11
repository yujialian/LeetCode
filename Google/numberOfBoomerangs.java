//447
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) return 0;
        Map<Integer, Integer> map;
        int sum = 0;
        for(int i = 0; i < points.length; i++) {
            map = new HashMap<>();
            for(int j = 0; j < points.length; j++) {
                if(i != j) {
                    int dis = calculate(points, i, j);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                sum += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return sum;
    }
    private int calculate(int[][] points, int i, int j) {
        return (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
    }
}
