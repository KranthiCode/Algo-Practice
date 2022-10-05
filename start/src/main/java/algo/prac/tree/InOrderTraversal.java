package algo.prac.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
  public static List<Integer> inOrderTraversal(TreeNode node) {
    List<Integer> result = new ArrayList<>();

    Stack<TreeNode> s = new Stack<>();
    TreeNode temp = node;
    // s.push(temp);
    boolean done = false;
    while (!done) {
      if (temp != null) {
        s.push(temp);
        // System.out.println(s);
        temp = temp.left;
      } else {
        if (s.empty()) {
          done = true;
        } else {
          temp = s.pop();
          result.add(temp.val);
          temp = temp.right;
        }
      }
    }
    return result;
  }

  public static void inOrderTraversalRec(TreeNode node) {
    if (node == null) {
      return;
    }
    inOrderTraversalRec(node.left);
    System.out.println(node.val);
    inOrderTraversalRec(node.right);
  }

  public static void main(String[] args) {
    TreeNode one = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    TreeNode four = new TreeNode(4);
    TreeNode five = new TreeNode(5);
    one.left = two;
    one.right = three;
    two.left = four;
    two.right = five;

    System.out.println(inOrderTraversal(one));
    // inOrderTraversalRec(one);
  }

}
