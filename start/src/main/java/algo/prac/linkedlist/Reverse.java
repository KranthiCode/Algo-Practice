package algo.prac.linkedlist;

public class Reverse {

  // This implementation modifies the order and head points to null at the end of
  // the implementation
  public static void printInReverse(Node head) {
    Node prev = null;
    Node current = head;
    Node next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    current = prev;

    System.out.println("Printing in reverse");

    while (current != null) {
      System.out.println(current.value);
      current = current.next;
    }

  }

  public static void printInReverseRecursion(Node head) {
    if (head.next != null) {
      printInReverseRecursion(head.next);
    }
    System.out.println(head.value);
  }

  public static void printLinkedList(Node head) {
    Node temp = head;
    System.out.println("Printing in order");
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);

    printInReverseRecursion(head);
    printLinkedList(head);
  }

  // 1 --> 2 --> 3 --> 4 --> null
  // null <-- 1 <-- 2
}

class Node {
  int value;
  Node next;

  Node(int value) {
    this.value = value;
  }
}
