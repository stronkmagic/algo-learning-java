package codejam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// learn how to read input :D
public class Rsort {
    public static void main(String[] args) throws Exception {
        List<Integer> output = new ArrayList<>();
        Scanner reader = new Scanner(System.in);

        Solution solution = new Solution();

        int testCases = reader.nextInt();
        for(int i = 0; i < testCases; ++i){
            int listSize = reader.nextInt();
            int[] testArray = new int[listSize];
            reader.nextLine();
            String s[]= reader.nextLine().split(" ");

            for (int j = 0 ; j < s.length; j++){
                testArray[j] = Integer.valueOf(s[j]);
            }

            Integer testRes = solution.calculateCost(testArray);
            System.out.println("Case #1: " + testRes);
        }
    }

    static class Solution {
        public int calculateCost(int[] list) {
            if (list.length < 2) return 0;

            int totalCost = 0;

            boolean[] sorted = new boolean[list.length];
            int pivotNumber = list[0];



//            for (int i = 1; i < list.length; i++) {
//                int checkIdx = i - 1;
//                int swapIdx = i - 1;
//
//                for (int j = i; j < list.length; j++) {
//                    if (list[j] < list[swapIdx] && !sorted[j]) {
//                        swapIdx = j;
//                        sorted[j] = true;
//                    }
//                }
//                swap(list,checkIdx,swapIdx);
//                totalCost += swapIdx - checkIdx + 1;
//            }



            return totalCost;
        }
        private void swap (int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}
