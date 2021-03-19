package leetcode;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
        KeysAndRooms solution = new KeysAndRooms();

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));

        boolean test1 = solution.canVisitAllRooms(rooms);

        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1,3));
        rooms2.add(Arrays.asList(3,0,1));
        rooms2.add(Arrays.asList(2));
        rooms2.add(Arrays.asList(0));

        boolean test2 = solution.canVisitAllRooms(rooms2);

        System.out.println(test1);
        System.out.println(test2);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 0) return true;
        HashSet<Integer> roomsToVisit = new HashSet<>();
        for (int i = 0; i < rooms.size(); i++) roomsToVisit.add(i);

        Stack<Integer> keys = new Stack<>();
        keys.push(0);

        while (!keys.isEmpty()) {
            Integer currentKey = keys.pop();
            roomsToVisit.remove(currentKey);
            for (Integer k: rooms.get(currentKey)) {
                if (roomsToVisit.contains(k)) keys.push(k);
            }
        }

        return roomsToVisit.isEmpty();
    }
}
