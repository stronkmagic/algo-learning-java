package leetcode;
import java.util.*;

public class MaxBoxesInWarehouse {

    public static void main(String[] args) {


        int[] boxes = {4,4,1,1};
        int[] warehouse = {5,4,3,3,1};

        MaxBoxesInWarehouse maxBoxesInWarehouse = new MaxBoxesInWarehouse();
        int count = maxBoxesInWarehouse.maxBoxesInWarehouse(boxes, warehouse);
        System.out.println(count);
    }

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        modifyWarehouse(warehouse);
        Arrays.sort(boxes);

        int ans = 0;

        int warehouseIdx = warehouse.length - 1;
        for (int i = 0; i < boxes.length; i++) {
            int boxHeight = boxes[i];
            if (warehouseIdx < 0) break;
            if (warehouseIdx >= 0 && boxHeight <= warehouse[warehouseIdx]) {
                warehouseIdx--;
                ans++;
            } else {
                while (warehouseIdx >= 0 && boxHeight > warehouse[warehouseIdx]) {
                    warehouseIdx--;
                }
            }
        }

        return ans;
    }

    private void modifyWarehouse(int[] warehouse) {
        for (int i = 1; i < warehouse.length; i++) {
            if (warehouse[i - 1] < warehouse[i]) {
                warehouse[i] = warehouse[i-1];
            }
        }
    }
}
