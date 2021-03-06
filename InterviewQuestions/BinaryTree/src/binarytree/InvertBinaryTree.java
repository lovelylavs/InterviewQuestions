/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import java.util.LinkedList;

/**
 *
 * @author Lavanya
 */
public class InvertBinaryTree {
    
    public TreeNode invertTree(TreeNode root) {
    if(root!=null){
        helper(root);
    }
 
    return root;    
}
 
public void helper(TreeNode p){
 
    TreeNode temp = p.left;
    p.left = p.right;
    p.right = temp;
 
    if(p.left!=null)
        helper(p.left);
 
    if(p.right!=null)
        helper(p.right);
}

public TreeNode invTree(TreeNode root)
{
    LinkedList<TreeNode> queue = new LinkedList<>();
    
    if(root != null)
    {
        queue.add(root);
    }
    
    while(!queue.isEmpty())
    {
        TreeNode p = queue.poll();
        if(p.left!=null)
        queue.add(p.left);
 
    if(p.right!=null)
        queue.add(p.right);
       
       TreeNode temp = p.left;
       p.left = p.right;
       p.right = temp;
               
    }
    return root;
}
}
