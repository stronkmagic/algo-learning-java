package leetcode;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        //node.next.next = new ListNode(2);
        //node.next.next.next = new ListNode(1);

        boolean palindrome = solution.isPalindrome(node);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        int size = linkedListSize(head);

        ListNode tail = head;
        int steps = size / 2;
        while (steps-- > 1) {
            tail = tail.next;
        }

        if (size % 2 == 0) {
            ListNode tmp = tail;
            tail = tail.next;
            tmp.next = null;
        }

        ListNode prev = null, next;
        while (tail != null) {
            next = tail.next;
            tail.next = prev;
            prev = tail;
            tail = next;
        }

        return equalLists(head, prev);
    }

    private int linkedListSize(ListNode node) {
        ListNode pt1 = node;
        int size = 0;
        while (pt1 != null) {
            size++;
            pt1 = pt1.next;
        }
        return size;
    }

    private boolean equalLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
