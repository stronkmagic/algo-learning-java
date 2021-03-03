package algoexpert;

import algoexpert.helper.MinHeap;

import java.util.*;

public class KthLargest {

    public static void main(String[] args) {
        int[] array = new int[] {2,10,12,3,15,4,6,100,251,333};
        int k = 3;

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer ar: array) {
            list.add(ar);
        }
        long startTime2 = System.nanoTime();
        System.out.println(kthLargestUsingHeap(list, k));
        long stopTime2 = System.nanoTime();
        System.out.println(stopTime2 - startTime2);

        long startTime = System.nanoTime();
        System.out.println(kthLargestUsingSort(array, k));
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

    }

    private static int kthLargestUsingHeap(List<Integer> array, int k) {
        MinHeap minHeap = new MinHeap(array);
        int result = -1;
        while (k > 0) {
            result = minHeap.remove();
            k--;
        }
        return result;
    }

    private static int kthLargestUsingSort(int[] array, int k) {
        Arrays.sort(array);
        return array[array.length - k];
    }
}
