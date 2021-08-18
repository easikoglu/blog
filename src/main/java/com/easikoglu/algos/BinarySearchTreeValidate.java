package com.easikoglu.algos;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class BinarySearchTreeValidate {

  public boolean isValidBST(TreeNode root) {
    return validate(root);
  }

  private boolean validate(TreeNode root) {

    if (root == null) {
      return true;
    }

    if ((root.right != null && root.right.val >= root.val)
        || (root.left != null && root.left.val <= root.val)) {
      return false;
    }

    return validate(root.right) && validate(root.left);
  }

  Integer previousVal = 0;
  private boolean  inOrderTraverse(TreeNode root){


    Stack<TreeNode> stack = new Stack<>();


    while(root!=null || !stack.isEmpty()){
        while(root!=null){
          stack.push(root);
          root = root.left;
        }
        root = stack.pop();
        if(previousVal!=null && previousVal >= root.val){
          return false;
        }
        previousVal = root.val;
        root = root.right;

    }
    return true;


  }


}





class TreeNode2 {
  int val;
  TreeNode2 left;
  TreeNode2 right;

  TreeNode2() {}

  TreeNode2(int val) {
    this.val = val;
  }

  TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
