package leetcode;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        cyclicReplacements(nums, k);
        //secondMethod();
    }




    private static void secondMethod(int[] nums, int k) {
        k %= nums.length;
        int tmp, prev;
        for (int i = 0; i < k; i++) {
            prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
            }
        }
    }
    private static void cyclicReplacements(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) %nums.length;
                int tmp =nums[next];
                nums[next] = prev;
                prev = tmp;
                current = next;
                count++;
            } while(start != current);
        }
    }

}
