package leetcode;

public class WiggleSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,7,4,9,2,5};
        int[] nums11 = {1,1,7,4,9,2,5};
        int[] nums2 = {1,17,5,10,13,15,10,5,16,8};
        int[] nums3 = {1,2,3,4,5,6,7,8,9};
        WiggleSubsequence soltuion = new WiggleSubsequence();
        int i = soltuion.wiggleMaxLength(nums);
        int i11 = soltuion.wiggleMaxLength(nums11);
        int i2 = soltuion.wiggleMaxLength(nums2);
        int i3 = soltuion.wiggleMaxLength(nums3);
        System.out.println(i);
        System.out.println(i11);
        System.out.println(i2);
        System.out.println(i3);
    }


    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int up = 1;
        int down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
