package leetcode;

import java.util.*;

public class LeastBricks {
    public static void main(String[] args) {
//        List<List<Integer>> wall = new ArrayList<>();
//        List<Integer> w1 = new ArrayList<>(Arrays.asList(1,2,2,1));
//        List<Integer> w2 = new ArrayList<>(Arrays.asList(3,1,2));
//        List<Integer> w3 = new ArrayList<>(Arrays.asList(1,3,2));
//        List<Integer> w4 = new ArrayList<>(Arrays.asList(2,4));
//        List<Integer> w5 = new ArrayList<>(Arrays.asList(3,1,2));
//        List<Integer> w6 = new ArrayList<>(Arrays.asList(1,3,1,1));
//        wall.add(w1);
//        wall.add(w2);
//        wall.add(w3);
//        wall.add(w4);
//        wall.add(w5);
//        wall.add(w6);
//
//        LeastBricks lb = new LeastBricks();
//
//        System.out.println(lb.leastBricks(wall));

    }

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap();

        int count = 0;
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                count = Math.max(count, map.get(sum));
            }
        }

        return wall.size() - count;
    }
}
