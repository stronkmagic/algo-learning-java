package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class CicularQueue {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
        //myCircularQueue.enQueue(0);
        myCircularQueue.enQueue(123);

        myCircularQueue.deQueue();
        myCircularQueue.enQueue(123);

        myCircularQueue.deQueue();
        myCircularQueue.deQueue();
        myCircularQueue.deQueue();
        myCircularQueue.deQueue();

    }

    static class MyCircularQueue {
        private List<Integer> queue;
        private int limit;

        public MyCircularQueue(int k) {
            queue = new ArrayList<>();
            limit = k;
        }

        public boolean enQueue(int value) {
            if (queue.size() == limit) return false;
            queue.add(value);
            return true;
        }

        public boolean deQueue() {
            if (queue.size() == 0) return false;
            queue.remove(0);
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return queue.get(0);
        }

        public int Rear() {
            if (isEmpty()) return -1;
            return queue.get(queue.size() - 1);
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public boolean isFull() {
            return queue.size() == limit;
        }
    }
}
