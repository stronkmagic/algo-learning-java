package leetcode;

public class MatrixBlockSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
//        int[][] matrix = {
//                //[[67,64,78],[99,98,38],[82,46,46],[6,52,55],[55,99,45]
//                {67,64,78},
//                {99,98,38},
//                {82,46,46},
//                {6,52,55},
//                {55,99,45}
//        };
        MatrixBlockSum solution = new MatrixBlockSum();
        solution.matrixBlockSum2(matrix, 1);
        solution.matrixBlockSum2(matrix, 2);
    }

    public int[][] matrixBlockSum2(int[][] m, int K) {
        int M = m.length, N = m[0].length;
        int[][] dp = new int[M+1][N+1], res = new int[M][N];

        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + m[i-1][j-1];
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int tlx = Math.max(0, i-K) + 1, tly = Math.max(0, j-K) + 1;
                int brx = Math.min(M-1, i+K) + 1, bry = Math.min(N-1, j+K) + 1;

                res[i][j] = dp[brx][bry] -dp[brx][tly-1] -dp[tlx-1][bry] + dp[tlx-1][tly-1];
            }
        }

        return res;
    }

    public int[][] matrixBlockSum(int[][] m, int K) {
        int[][] rows = new int[m.length][m[0].length];

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[0].length; j++) {

                if (j > 0) {
                    rows[i][j] = m[i][j] + rows[i][j-1];
                } else {
                    rows[i][j] = m[i][j];
                }
            }
        }

        int[][] res = new int[m.length][m[0].length];

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[0].length; j++) {
                res[i][j] = sumRow(rows, j - K - 1, j + K, i - K, i + K);
            }
        }
        return res;
    }

    private int sumRow(int[][] rowSums, int start, int end, int row, int endRow) {
        int sum = 0;
        if (row < 0) {
            row = 0;
        }
        if (end >= rowSums.length) {
            end = rowSums.length - 1;
        }
        for (int i = row; i <= endRow && i < rowSums.length; i++) {
            int res = rowSums[i][end];
            if (start >= 0) {
                res -= rowSums[i][start];
            }
            sum += res;
        }
        return sum;
    }
}
