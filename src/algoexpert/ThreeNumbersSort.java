package algoexpert;

public class ThreeNumbersSort {
    public static void main(String[] args) {
        int[] nums = new int[] {-2, -3, -3, -3, -3, -3, -2, -2, -3};
        int[] order = new int[] {-2, -3, 0};
        long startTime2 = System.nanoTime();
        threeNumberSort(nums, order);
        long stopTime2 = System.nanoTime();
        System.out.println(stopTime2 - startTime2);


        long startTime1 = System.nanoTime();
        threeNumberSortMy(nums, order);
        long stopTime1 = System.nanoTime();
        System.out.println(stopTime1 - startTime1);
    }

    public static int[] threeNumberSortMy(int[] array, int[] order) {
        // Write your code here.
        int orderIdx = 0;
        for (int o = 0; o < order.length - 1; o++) {
            for (int i = 0; i < array.length; i++) {
                int arrayValue = array[i];
                if (order[o] == arrayValue) {
                    if (orderIdx != i) {
                        int tmp = array[orderIdx];
                        array[orderIdx] = array[i];
                        array[i] = tmp;
                    }
                    orderIdx++;
                }
            }
        }
        return array;
    }

    public static int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        int firstValue = order[0];
        int secondValue = order[1];

        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = array.length - 1;

        while (secondIdx <= thirdIdx) {
            int value = array[secondIdx];

            if (value == firstValue) {
                swap(firstIdx, secondIdx, array);
                firstIdx++;
                secondIdx++;
            } else if (value == secondValue) {
                secondIdx += 1;
            } else {
                swap(secondIdx, thirdIdx, array);
                thirdIdx -= 1;
            }
        }

        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
