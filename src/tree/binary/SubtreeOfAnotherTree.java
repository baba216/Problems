package tree.binary;

public class SubtreeOfAnotherTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(2);
    root.right = new TreeNode(5);

    TreeNode subTreeRoot = new TreeNode(4);
    subTreeRoot.left = new TreeNode(1);
    subTreeRoot.right = new TreeNode(2);

    /*TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(1);
    root.left.right.right = new TreeNode(2);
    root.right = new TreeNode(5);

    TreeNode subTreeRoot = new TreeNode(4);
    subTreeRoot.left = new TreeNode(1);
    subTreeRoot.right = new TreeNode(2);*/

    /*TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(0);
    root.right = new TreeNode(5);

    TreeNode subTreeRoot = new TreeNode(4);
    subTreeRoot.left = new TreeNode(1);
    subTreeRoot.right = new TreeNode(2);*/

    /*TreeNode root = new TreeNode(1);
    root.left = new TreeNode(1);

    TreeNode subTreeRoot = new TreeNode(1);*/

    Boolean result = isSubTree(root, subTreeRoot);
    System.out.println(result);
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
      left = null;
      right = null;
    }
  }


  public static boolean isSubTree(TreeNode s, TreeNode t) {
    return isSubTreeHelper(s, t, t, s);
  }

  private static boolean isSubTreeHelper(TreeNode s, TreeNode t, TreeNode originalT,
      TreeNode orginalS) {
    if ((s != null && t != null) && (s.val == t.val)) {
      boolean isLeftSubTree = isSubTreeHelper(s.left, t.left, t, s);
      if (isLeftSubTree) {
        boolean isRightSubTree = isSubTreeHelper(s.right, t.right, t, s);
        if (isRightSubTree) {
          return true;
        }
      }
      return false;
    }
    if (s != null) {
      boolean found = isSubTreeHelper(orginalS.left, originalT, originalT, s);
      if (!found) {
        return isSubTreeHelper(orginalS.right, originalT, originalT, s);
      }
      return found;
    }
    if (t == null)
    {
      return true;
    }
    return false;
  }
}
