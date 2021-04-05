package leetcode;

public class MaxOfAbsValueExpr {
    public static void main(String[] args) {
        System.out.println('a'-'a');
        System.out.println('b'-'a');
        System.out.println('c'-'a');
        System.out.println('z'-'a');
//        int[] arr1 = {1,2,3,4};
//        int[] arr2 = {-1,4,5,6};
//        MaxOfAbsValueExpr solution = new MaxOfAbsValueExpr();
//        int absValExpr = solution.maxAbsValExpr(arr1, arr2);
//        System.out.println(absValExpr);
    }

    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        int[][] directions = {{1,1},{1,-1},{-1,1},{-1,-1}};
        int max = 0;
        for (int[] dir: directions) {
            int x = dir[0];
            int y = dir[1];
            int smallest = x * arr1[0] + y * arr2[0] + 0;
            for (int i = 1; i < arr1.length; i++) {
                int curr = x * arr1[i] + y * arr2[i] + i;
                max = Math.max(curr - smallest, max);
                smallest = Math.min(smallest, curr);
            }
        }
        return max;
    }
}
