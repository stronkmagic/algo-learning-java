package algoexpert;

import java.util.HashMap;

public class LRUCache {

    public static void main (String[] args) {
        LRUCacheSolution solution = new LRUCacheSolution(3);
        solution.insertKeyValuePair("b", 2);
        solution.insertKeyValuePair("a", 1);
        solution.insertKeyValuePair("c", 3);
        solution.getMostRecentKey();
        solution.getValueFromKey("a");
        solution.getMostRecentKey();
        solution.insertKeyValuePair("d", 4);
        solution.getValueFromKey("b");
        solution.insertKeyValuePair("a", 5);
        solution.getValueFromKey("a");
    }

    static class LRUCacheSolution {
        int maxSize;
        int currentSize = 0;
        LinkedList listMostRecent = new LinkedList();
        HashMap<String, ListNode> cache = new HashMap<>();

        public LRUCacheSolution(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public void insertKeyValuePair(String key, int value) {
            // Write your code here.
            if (!cache.containsKey(key)) {
                if (currentSize == maxSize) {
                    evictLRU();
                } else {
                    currentSize++;
                }
                cache.put(key, new ListNode(key, value));
            } else {
                replaceKey(key, value);
            }
            updateMostRecent(cache.get(key));
        }

        public LRUResult getValueFromKey(String key) {
            // Write your code here.
            if (!cache.containsKey(key)) {
                return new LRUResult(false, -1);
            }
            updateMostRecent(cache.get(key));
            return new LRUResult(true, cache.get(key).value);
        }

        private void evictLRU() {
            String keyToRemove = listMostRecent.tail.key;
            listMostRecent.removeTail();
            cache.remove(keyToRemove);
        }

        private void updateMostRecent(ListNode node) {
            listMostRecent.setHeadTo(node);
        }

        private void replaceKey(String key, int value) {
            if (!this.cache.containsKey(key)) {
                return;
            }
            cache.get(key).value = value;
        }

        public String getMostRecentKey() {
            // Write your code here.
            if (listMostRecent.head == null) return "";
            return listMostRecent.head.key;
        }

    }

    static class LinkedList {
        ListNode head = null;
        ListNode tail = null;

        public void setHeadTo(ListNode node) {
            if (head == node) return;
            else if (head == null) {
                head = node;
                tail = node;
            } else if (head == tail) {
                tail.prev = node;
                head = node;
                head.next = tail;
            } else {
                if (tail == node) {
                    removeTail();
                }
                node.removeBindings();
                head.prev = node;
                node.next = head;
                head = node;
            }
        }

        public void removeTail() {
            if (tail == null) return;
            if (tail == head) {
                head = null;
                tail = null;
                return;

            }
            tail = tail.prev;
            tail.next = null;
        }
    }

    static class ListNode {
        String key;
        int value;
        ListNode next = null;
        ListNode prev = null;

        public ListNode(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public void removeBindings() {
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }

            prev = null;
            next = null;
        }

    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }
}
