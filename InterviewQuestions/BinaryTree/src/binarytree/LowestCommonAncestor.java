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
public class LowestCommonAncestor {
    
    /*The lowest common ancestor is defined between two nodes v and w as the 
    lowest node in T that has both v and w as descendants 
    (where we allow a node to be a descendant of itself).”*/
    
    /*For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
    Another example is LCA of nodes 2 and 4 is 2, 
    since a node can be a descendant of itself according to the LCA definition.*/
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;
        
        if(temp.val > p.val && temp.val < q.val)
        {
            return temp;
        }
        else if(temp.val > p.val && temp.val > q.val)
        {
            return lowestCommonAncestor(temp.left, p , q);
        }
        else if(temp.val <p.val && temp.val < q.val)
        {
            return lowestCommonAncestor(temp.right, p ,q);
        }
        return root;
    }
}
