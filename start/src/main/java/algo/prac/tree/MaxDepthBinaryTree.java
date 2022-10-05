package algo.prac.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBinaryTree {

  private static int maxDepthRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int lh = maxDepthRecursive(root.left);
    int rh = maxDepthRecursive(root.right);

    return 1 + Math.max(lh, rh);
  }

  private static int maxDepthIterative(TreeNode root) {
    if (root == null) {
      return 0;
    }
    TreeNode temp = root;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(temp);
    int maxDepth = 0;
    while (!q.isEmpty()) {
      int count = q.size();
      maxDepth++;

      for (int i = 0; i < count; i++) {
        TreeNode current = q.peek();
        if (current.left != null) {
          q.offer(current.left);
        }
        if (current.right != null) {
          q.offer(current.right);
        }
        // poll once every level
        q.poll();
      }
    }
    return maxDepth;
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

    // System.out.println(maxDepthRecursive(one));
    System.out.println(maxDepthIterative(one));
  }
}
