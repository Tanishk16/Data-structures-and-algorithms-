class Solution {
    int m, n;
    public void dfs(char[][] grid, int r, int c){
        if(r >= m || r <0 || c >= n  || c < 0){
            return;
        }
        if(grid[r][c] != '1'){
            return;
        }
        // this means this is the visited index;
        grid[r][c] = '0';
        dfs(grid, r , c-1);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);

    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if(n == 0){
            return 0;
        }
        int result = 0;

        for(int i = 0;i<m ;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i , j);
                    ++result;
                }
            }
        }
        return result;
    }
}