package dailyinterviewpro;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class FindDuplicateInArray {
    public static void main(String[] args ) {
        int[] example = new int[] {4, 3, 2, 4, 1, 3, 2,1,100};
        FindDuplicateInArray solution = new FindDuplicateInArray();

        long startTime2 = System.nanoTime();
        System.out.printf("%s", solution.findDuplicateInArray(example));
        long stopTime2 = System.nanoTime();
        System.out.println(TimeUnit.SECONDS.convert((stopTime2 - startTime2 ), TimeUnit.NANOSECONDS));

        startTime2 = System.nanoTime();
        System.out.printf("%s", solution.findDuplicateInArrayWithMappu(example));
        stopTime2 = System.nanoTime();
        System.out.println(TimeUnit.SECONDS.convert((stopTime2 - startTime2 ), TimeUnit.NANOSECONDS));
    }

    private int findDuplicateInArrayWithMappu(int[] arr) {
        HashMap<Integer, Integer> mappu = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            mappu.put(arr[i], mappu.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (mappu.containsKey(arr[i]) && mappu.get(arr[i]) == 1) return arr[i];
        }

        return -1;
    }

    private int findDuplicateInArray(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num ^= arr[i];
        }

        return num;
    }
}
