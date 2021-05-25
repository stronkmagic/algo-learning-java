package leetcode;

import java.util.PriorityQueue;

public class FurthestBuildings {
    public static void main(String[] args) {
        int[] test = {4,12,2,7,3,18,20,3,19};
        int bricks = 10, ladders = 2;

        FurthestBuildings solution = new FurthestBuildings();
        solution.furthestBuilding(test, bricks, ladders);
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0)
                pq.add(diff);
            if (pq.size() > ladders)
                bricks -= pq.poll();
            if (bricks < 0)
                return i;
        }
        return heights.length - 1;
    }
}
