/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

/**
 *
 * @author Lavanya
 */
public class SameBinaryTree {
    
        public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
          return true;
          else if(p != null & q != null)
          {
              if(p.val == q.val)
              {
                  return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
              }
              else
              {
                  return false;
              }
          }
       return false;
    }
    
}
