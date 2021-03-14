package leetcode;

public class SwappingNodesInLinkedList {
    public static void main(String[] args) {
        ListNode testList = new ListNode(1);
        testList.next = new ListNode(2);
        testList.next.next = new ListNode(3);
        testList.next.next.next = new ListNode(4);
        testList.next.next.next.next = new ListNode(5);

        SwappingNodesInLinkedList solution = new SwappingNodesInLinkedList();
        solution.swapNodes(testList, 2);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, first = head, second = head;

        for (int i = 0; i < k - 1; ++i) fast = fast.next;

        first = fast;

        while (fast.next != null) {
            second = second.next;
            fast = fast.next;
        }

        swapNodeValues(first, second);

        return head;
    }

    private void swapNodeValues(ListNode l1, ListNode l2) {
        int tmp = l1.val;
        l1.val = l2.val;
        l2.val = tmp;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
