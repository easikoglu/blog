package com.easikoglu.algos;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class SubTreeOfTree {

  public boolean isSubtree(TreeNode s, TreeNode t) {

    if(s==null) {
      return false;
    }
    if(checkNodes(s,t)){
      return true;
    }
    return isSubtree(s.left,t) || isSubtree(s.right,t);
  }

  private boolean checkNodes(TreeNode s, TreeNode t) {

    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }
    return s.val == t.val && checkNodes(s.left, t.left) && checkNodes(s.right, t.right);
  }
}
