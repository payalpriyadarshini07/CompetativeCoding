class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        Integer[][] ans = new Integer[m][n];

        for (int i = 0; i < total; i++) {
            int oldRow = i / n;
            int oldCol = i % n;

            int newIndex = (i + k) % total;
            int newRow = newIndex / n;
            int newCol = newIndex % n;

            ans[newRow][newCol] = grid[oldRow][oldCol];
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            result.add(Arrays.asList(ans[i]));
        }

        return result;
    }
}