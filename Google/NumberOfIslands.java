package Google;

public class NumberOfIslands {
  public static void main(String[] args) {
    char[][] grid = new char[][] {
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '0', '0'},
      {'1', '1', '0', '0', '0'}
    };
    System.out.println(numOfIslands(grid));
  }

  private static int numOfIslands(char[][] grid) {
    int width = grid.length, length = grid[0].length, numOfIsland = 0;
    boolean[][] visited = new boolean[width][length];
    for (int row = 0; row < width; ++row) {
      for (int col = 0; col < length; ++col) {
        if (grid[row][col] == '1' && visited[row][col] == false) {
          numOfIsland++;
          dfs(grid, visited, row, col);
        }
      }
    }
    return numOfIsland;
  }

  private static void dfs(char[][] grid, boolean[][] visited, int row, int col) {
    if (row < 0 || row >= grid.length) return;
    if (col < 0 || col >= grid[0].length) return;
    if (grid[row][col] != '1' || visited[row][col]) return;
    visited[row][col] = true;
    dfs(grid, visited, row + 1, col);
    dfs(grid, visited, row - 1, col);
    dfs(grid, visited, row, col + 1);
    dfs(grid, visited, row, col - 1);
  }

}