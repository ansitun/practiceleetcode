import java.util.*;

class Node {
    int value = 0;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

class ReverseSubList {

    public static Node reverse(Node head, int p, int q) {
        int count = 0;

        Node n = head;
        while(count < p) {
            head = head.next;
            count++;
        }
        Node prev = head;
        Node next;
        Node m = head;
        while(count < q) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            count++;
        }
        m.next = prev;
        prev.next = head;

//        head = h;
        return n;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}