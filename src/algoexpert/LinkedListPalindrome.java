package algoexpert;

public class LinkedListPalindrome {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(0);
        linkedList.next = new LinkedList(1);
        linkedList.next.next = new LinkedList(2);
        linkedList.next.next.next = new LinkedList(2);
        linkedList.next.next.next.next = new LinkedList(1);
        linkedList.next.next.next.next.next = new LinkedList(0);
        boolean res = linkedListPalindrome(linkedList);
        System.out.println(res);
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class LinkedListInfo {
        public boolean nodesEqual;
        public LinkedList leftNode;

        public LinkedListInfo(boolean equals, LinkedList lNode) {
            nodesEqual = equals;
            leftNode = lNode;
        }
    }

    public static boolean linkedListPalindrome(LinkedList head) {
        //return recursive(head);
        return usingReverse(head);
    }

    private static boolean usingReverse(LinkedList head) {
        LinkedList slowNode = head;
        LinkedList fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        LinkedList reversedHalf = reverseLinkedList(slowNode);
        LinkedList firstHalf = head;

        while (reversedHalf != null) {
            if (reversedHalf.value != firstHalf.value) return false;
            reversedHalf = reversedHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList prevNode = null;
        LinkedList currNode = head;

        while (currNode != null) {
            LinkedList nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    private static boolean recursive(LinkedList head) {
        LinkedListInfo res = isPalindrome(head, head);
        return res.nodesEqual;
    }

    public static LinkedListInfo isPalindrome(LinkedList left, LinkedList right) {
        if (right == null) return new LinkedListInfo(true, left);

        LinkedListInfo res = isPalindrome(left, right.next);
        LinkedList leftCompare = res.leftNode;
        boolean nodesEqual = res.nodesEqual;

        boolean isEqual = nodesEqual && (leftCompare.value == right.value);
        LinkedList nextCompare = leftCompare.next;

        return new LinkedListInfo(isEqual, nextCompare);
    }
}
