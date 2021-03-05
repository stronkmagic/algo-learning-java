package algoexpert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DiskStacking {
    public static void main(String[] args) {
        List<Integer[]> disks = new ArrayList<>();

        disks.add(new Integer[]{2,1,2});
        disks.add(new Integer[]{3,2,3});
        disks.add(new Integer[]{2,2,8});
        disks.add(new Integer[]{2,3,4});
        disks.add(new Integer[]{1,3,1});
        disks.add(new Integer[]{4,4,5});

        List<Integer[]> integers = diskStacking(disks);
        System.out.println(213);
    }

    public static List<Integer[]> diskStacking(List<Integer[]> disks)
    {
        disks.sort(Comparator.comparing(disks2 -> disks2[2]));

        int[] heights = new int[disks.size()];
        int[] sequences = new int[disks.size()];
        for (int i = 0; i < disks.size(); i++) {
            heights[i] = disks.get(i)[2];
            sequences[i] = Integer.MIN_VALUE;
        }

        int maxHeightIdx = 0;
        for (int i = 1; i < disks.size(); i++) {
            Integer[] currDisk = disks.get(i);
            for (int j = 0; j < i; j++) {
                Integer[] otherDisk = disks.get(j);
                if (otherDisk[0] < currDisk[0] && otherDisk[1] < currDisk[1] && otherDisk[2] < currDisk[2]) {
                    if (heights[i] < currDisk[2] + heights[j]) {
                        heights[i] = currDisk[2] + heights[j];
                        sequences[i] = j;
                    }
                }
            }
            if (heights[i] >= heights[maxHeightIdx]) {
                maxHeightIdx = i;
            }
        }

        return buildSequence(disks, sequences, maxHeightIdx);
    }

    public static List<Integer[]> buildSequence(List<Integer[]> array, int[] sequences, int currentIdx) {
        List<Integer[]> sequence = new ArrayList<>();
        while (currentIdx != Integer.MIN_VALUE) {
            sequence.add(0, array.get(currentIdx));
            currentIdx = sequences[currentIdx];
        }
        return sequence;
    }
}
