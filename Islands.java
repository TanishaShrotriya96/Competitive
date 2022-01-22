class Islands{

    public static 
    void dfs(char[][] grid, int r, int c) {
      int rows = grid.length;
      int cols = grid[0].length;
  
      if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
        return;
      }
  
      grid[r][c] = '0';
      dfs(grid, r - 1, c);
      dfs(grid, r + 1, c);
      dfs(grid, r, c - 1);
      dfs(grid, r, c + 1);
    }
  
    public static int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) {
        return 0;
      }
  
      int rows = grid.length;
      int cols = grid[0].length;
      int num_islands = 0;
      for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
          if (grid[r][c] == '1') {
            ++num_islands;
            dfs(grid, r, c);
          }
        }
      }
  
      return num_islands;
    }
    
    public static void main(String[] args) throws java.lang.Exception
    {
        char M[][] = new char[][] { { '1', '1', '0', '0','0' },
                                  { '0', '1', '0', '0', '1' },
                                  { '1', '0', '0', '1', '1' },
                                  { '0', '0', '0', '0', '0' },
                                  { '1', '0', '1', '0', '1' } };
        System.out.println("Number of islands is: " + Islands.numIslands(M));
    }
  }