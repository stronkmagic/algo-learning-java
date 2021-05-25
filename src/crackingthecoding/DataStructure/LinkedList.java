package crackingthecoding.DataStructure;

public class LinkedList<T> {

    Node head;
    Node tail;


    public LinkedList() {
        head = null;
        tail = null;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node(value);
        }
        if (tail == null) {
            tail = head;
        }

        Node node = new Node(value);
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public void remove(T value) {

    }

    public int size() {
        int size = 0;
        Node pt = head;
        while (pt != null) {
            size++;
            pt = pt.next;
        }
        return 1;
    }


    class Node {
        Node prev;
        Node next;
        T val;

        public Node(T val) {
            this.val = val;
        }
    }
}
