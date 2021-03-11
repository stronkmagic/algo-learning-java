package algoexpert;

import algoexpert.helper.MaxHeap;
import algoexpert.helper.MinHeap;

import java.util.*;

public class KthLargest {

    public static void main(String[] args) {
//        int[] array = new int[] {2,10,12,3,15,4,6,100,251,333};
//        int k = 3;
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (Integer ar: array) {
//            list.add(ar);
//        }
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5000000; i++) {
            list.add(random.nextInt());
        }


        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) array[i] = list.get(i);

        int k = 3;
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
        MaxHeap heap = new MaxHeap(array);
        int result = -1;
        while (k > 0) {
            result = heap.remove();
            k--;
        }
        return result;
    }

    private static int kthLargestUsingSort(int[] array, int k) {
        Arrays.sort(array);
        return array[array.length - k];
    }
}
