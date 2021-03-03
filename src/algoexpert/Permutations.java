package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3)) ;
        getPermutations(list);
    }
//    public static List<List<Integer>> getPermutations(List<Integer> array) {
//        // Write your code here.
//        ArrayList<List<Integer>> permutations = new ArrayList<List<Integer>>();
//
//        for (int i = 0; i < array.size(); i++) {
//            List<Integer> permutation = new ArrayList<Integer>();
//            permutation.add(i);
//            for (int j = 0; j < array.size(); j++) {
//                if (i != j) {
//                    permutation.add(j);
//                }
//            }
//            permutations.add(permutation);
//        }
//
//        return permutations;
//    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(array, new ArrayList<>(), permutations);
        return permutations;
    }

    public static void getPermutations(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations) {
        if (array.size() == 0 && currentPermutation.size() > 0) {
            permutations.add(currentPermutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(array.get(i));
                getPermutations(newArray, newPermutation, permutations);
            }
        }
    }
}
