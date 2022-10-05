package algo.prac.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
  TreeNode root;

  LevelOrderTraversal() {
    root = null;
  }

  int height(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int lheight = height(root.left);
      int rheight = height(root.right);

      if (lheight > rheight)
        return lheight + 1;
      else
        return rheight + 1;
    }
  }

  static void printLevelOrder(TreeNode root) {
    if (root == null)
      return;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      TreeNode temp = q.poll();
      System.out.println(temp.val);
      if (temp.left != null) {
        q.offer(temp.left);
      }
      if (temp.right != null) {
        q.offer(temp.right);
      }
    }

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

    printLevelOrder(one);
  }
}
