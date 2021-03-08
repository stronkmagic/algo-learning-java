package algoexpert;

import algoexpert.helper.LinkedList;

public class MergeTwoLinkedLists {
    public static void main(String[] args) {
        LinkedList listOne = new LinkedList(2);
        listOne.next = new LinkedList(6);
        listOne.next.next = new LinkedList(7);
        listOne.next.next.next = new LinkedList(8);

        LinkedList listTwo = new LinkedList(1);
        listTwo.next = new LinkedList(3);
        listTwo.next.next = new LinkedList(4);
        listTwo.next.next.next = new LinkedList(5);
        listTwo.next.next.next.next = new LinkedList(9);
        listTwo.next.next.next.next.next = new LinkedList(10);

        LinkedList mergedList2 = mergeLinkedListsTwo(listOne, listTwo);
        while (mergedList2 != null) {
            System.out.println(mergedList2.value);
            mergedList2 = mergedList2.next;
        }
//        LinkedList mergedList = mergeLinkedLists(listOne, listTwo);
//        while (mergedList != null) {
//            System.out.println(mergedList.value);
//            mergedList = mergedList.next;
//        }
    }
    // O(n + k) n -listOne, k + listTwo | O(1) space
    public static LinkedList mergeLinkedListsTwo(LinkedList headOne, LinkedList headTwo) {
        LinkedList p1 = headOne;
        LinkedList p1Prev = null;
        LinkedList p2 = headTwo;
        while(p1 != null && p2 != null)
        {
            if (p1.value < p2.value ){
                p1Prev = p1;
                p1 = p1.next;
            } else {
                if (p1Prev != null) p1Prev.next = p2;
                p1Prev = p2;
                p2 = p2.next;
                p1Prev.next = p1;
            }
        }
        if (p1 == null) p1Prev.next = p2;

        return headOne.value < headTwo.value ?  headOne : headTwo;
    }

    // O(n + k) n -listOne, k + listTwo | O(n) space
    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        LinkedList head = new LinkedList(-1);
        LinkedList currNode = head;
        while (headOne != null && headTwo != null) {
            if (headOne.value < headTwo.value)  {
                currNode.next = headOne;
                headOne = headOne.next;
            } else {
                currNode.next = headTwo;
                headTwo = headTwo.next;
            }
            currNode = currNode.next;
        }

        while (headOne != null) {
            currNode.next = headOne;
            headOne = headOne.next;
        }

        while (headTwo != null) {
            currNode.next = headTwo;
            headTwo = headTwo.next;
            currNode = currNode.next;
        }

        return head.next;
    }
}
