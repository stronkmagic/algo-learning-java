package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinHeapProblem {
    static class MinHeapImpl {
        List<Integer> heap = new ArrayList<>();

        public MinHeapImpl(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            int firstParentIdx = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            int childOneIdx = currentIdx * 2 + 1;
            while (childOneIdx <= endIdx) {
                int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                int idxToSwap;
                if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }

                if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 +1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.

            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public int peek() {
            // Write your code here.
            return heap.get(0);
        }

        public int remove() {
            // Write your code here.
            swap(0, heap.size() - 1, heap);
            int val = heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return val;
        }

        public void insert(int value) {
            // Write your code here.
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        private void swap(int i, int j, List<Integer> heap) {
            Integer tmp = heap.get(j);
            heap.set(j, heap.get(i));
            heap.set(i, tmp);
        }
    }

    public static void main(String[] args) {
        List<Integer> testArray = new ArrayList<>(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
        MinHeapImpl minHeap = new MinHeapImpl(testArray);
    }
}
