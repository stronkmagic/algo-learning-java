package algoexpert;

import algoexpert.helper.MinHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrays {
    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        List<Integer> t1 = new ArrayList<>();
        t1.addAll(Arrays.asList(1,5,9,21));
        List<Integer> t2 = new ArrayList<>();
        t2.addAll(Arrays.asList(-1,0));
        List<Integer> t3 = new ArrayList<>();
        t3.addAll(Arrays.asList(-124,81,121));
        List<Integer> t4 = new ArrayList<>();
        t4.addAll(Arrays.asList(3,6,12,20,150));
        test.add(t1);
        test.add(t2);
        test.add(t3);
        test.add(t4);

        List<Integer> integers = mergeSortedArrays(test);
        integers.forEach(System.out::println);
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // Write your code here.

        MinHeap heap = new MinHeap();

        for (List<Integer> array: arrays) {
            for (Integer val: array) {
                heap.insert(val);
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!heap.isEmpty()) {
            list.add(heap.remove());
        }

        return list;
    }
}
