package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        powerset(arrayList);
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (Integer element: array) {
            int length = subsets.size();
            for (int i = 0; i < length; i++) {
                List<Integer> currentSubset = new ArrayList<Integer>(subsets.get(i));
                currentSubset.add(element);
                subsets.add(currentSubset);
            }
        }

        return subsets;
    }

}
/*

[1,2,3,4,5]

[
    [],
    [1], [2], [3], [4], [5],
    [1,2], [1,3], [1,4], [1,5], [2,3], [2,4], [2,5], [3,4], [3,5], [4,5]
    [1,2,3], [1,2,4], [1,2,5], [2,3,4], [2,3,5], [3,4,5]
    [1,2,3,4], [1,2,3,5], [2,3,4,5]
    [1,2,3,4,5]
]

 */