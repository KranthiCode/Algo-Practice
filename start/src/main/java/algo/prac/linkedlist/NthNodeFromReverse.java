package algo.prac.linkedlist;

import java.util.TooManyListenersException;

public class NthNodeFromReverse {
  public static void nthNodeFromEnd(Node head, int n) {
    int len = 0;
    if (head == null) {
      return;
    }
    Node temp = head;
    while (temp != null) {
      temp = temp.next;
      len++;
    }

    if (len >= n) {
      temp = head;
      len = len - n;
      while (len > 0) {
        temp = temp.next;
        len--;
      }
    }
  }

  public static void nthNodeFromEnd1(Node head, int n) {
    if (head == null) {
      return;
    }

    Node firstPnt = head;
    Node secondPnt = head;

    int tempCount = n;
    while (tempCount > 0 && firstPnt != null) {
      firstPnt = firstPnt.next;
      tempCount--;
    }

    while (firstPnt != null) {
      firstPnt = firstPnt.next;
      secondPnt = secondPnt.next;
    }
    System.out.println(secondPnt.value);
  }
}
