class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int i, int j) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        grid[i][j] = 2;
        queue.offer(new int[] {i, j});
        while(!queue.isEmpty()) {
            int[] lo = queue.poll();
            for(int[] dir: dirs) {
                i = dir[0] + lo[0];
                j = dir[1] + lo[1];
                if(isValid(grid, i, j) && grid[i][j] == 1) {
                    count++;
                    grid[i][j] = 2;
                    queue.offer(new int[] {i, j});
                }
            }
        }
        return count;
    }
    private boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
