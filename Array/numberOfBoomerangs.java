class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0) return 0;
        int total = 0;
        for(int i = 0; i < points.length; i++) {
            /* Key is distance, value is number of pair. */
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++) {
                if(i != j) {
                    int distance = dis(points[i], points[j]);
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
            }
            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                total += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return total;
    }
    private int dis(int[] arr1, int[] arr2) {
        return (arr2[0] - arr1[0]) * (arr2[0] - arr1[0]) + (arr2[1] - arr1[1]) * (arr2[1] - arr1[1]);
    }
}
