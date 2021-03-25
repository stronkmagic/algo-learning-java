package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,2,3,5},
//                {3,2,3,4,4},
//                {2,4,5,3,1},
//                {6,7,1,4,5},
//                {5,1,1,2,4},
//        };
        int[][] matrix = {
                {1,2,3},
                {8,9,4},
                {7,6,5},
        };

        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        solution.pacificAtlantic(matrix);
    }

    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int numRows;
    private int numCols;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        numRows = matrix.length;
        numCols = matrix[0].length;

//         Queue<int[]> pacificQueue = new LinkedList<>();
//         Queue<int[]> atlanticQueue = new LinkedList<>();
//         for (int i = 0; i < numRows; i++) {
//             pacificQueue.offer(new int[]{i, 0});
//             atlanticQueue.offer(new int[]{i, numCols - 1});
//         }
//         for (int i = 0; i < numCols; i++) {
//             pacificQueue.offer(new int[]{0, i});
//             atlanticQueue.offer(new int[]{numRows - 1, i});
//         }

//         boolean[][] pacificReachable = bfs(matrix, pacificQueue);
//         boolean[][] atlanticReachable = bfs(matrix, atlanticQueue);

        // Loop through each cell adjacent to the oceans and start a DFS
        boolean[][] pacificReachable = new boolean[numRows][numCols];
        boolean[][] atlanticReachable = new boolean[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            dfs(matrix, i, 0, pacificReachable);
            dfs(matrix, i, numCols - 1, atlanticReachable);
        }
        for (int i = 0; i < numCols; i++) {
            dfs(matrix, 0, i, pacificReachable);
            dfs(matrix, numRows - 1, i, atlanticReachable);
        }

        List<List<Integer>> intersection = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    List<Integer> pair = new ArrayList<>(Arrays.asList(i,j));
                    intersection.add(pair);
                }
            }
        }
        return intersection;
    }

    private void dfs(int[][] matrix, int row, int col, boolean[][] reachable) {
        // cell is reachable, so mark it
        reachable[row][col] = true;
        for (int[] dir : DIRECTIONS) { // Check all directions
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // within bounds
            if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                continue;
            }
            // visited
            if (reachable[newRow][newCol]) {
                continue;
            }
            // check heights
            if (matrix[newRow][newCol] < matrix[row][col]) {
                continue;
            }
            // new cell is reachable
            dfs(matrix, newRow, newCol, reachable);
        }
    }

    private boolean[][] bfs(int[][] matrix, Queue<int[]> queue) {
        boolean[][] reachable = new boolean[numRows][numCols];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            // cell is reachable, so mark it
            reachable[cell[0]][cell[1]] = true;
            for (int[] dir : DIRECTIONS) { // Check all directions
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                // within bounds
                if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                    continue;
                }
                // visited
                if (reachable[newRow][newCol]) {
                    continue;
                }
                // check heights
                if (matrix[newRow][newCol] < matrix[cell[0]][cell[1]]) {
                    continue;
                }
                // new cell is reachable
                queue.offer(new int[]{newRow, newCol});
            }
        }
        return reachable;
    }

}
