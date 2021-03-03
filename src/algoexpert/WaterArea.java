package algoexpert;

public class WaterArea {
    public static void main(String[] args) {
        int[] example = new int[] {0,3,0,5,10,0,1,1,0,2,0};
        int res = waterArea(example);
        System.out.println(res);
    }

    public static int waterArea(int[] heights) {
        // Write your code here.
        if (heights.length == 0) return 0;

        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int leftMax = heights[leftPointer];
        int rightMax = heights[rightPointer];
        int total = 0;

        while (rightPointer > leftPointer) {
            if (heights[leftPointer] < heights[rightPointer]) {
                leftPointer++;
                leftMax = Math.max(leftMax, heights[leftPointer]);
                total += leftMax - heights[leftPointer];
            } else {
                rightPointer--;
                rightMax = Math.max(rightMax, heights[rightPointer]);
                total += rightMax - heights[rightPointer];
            }
            //
        }
        return total;
    }
}
