package leetcode;

public class RotateImage {
    public static void main(String[] args) {
        int[][] img1 = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(img1);
    }
    public void rotate(int[][] matrix) {
        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println(matrix[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                swap(matrix, i, j, i, N - j - 1);
            }
        }
    }

    // 23 with 32
    // 1 0 with 1 4

    private void swap(int[][] matrix, int i, int j, int i2, int j2) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }

}
