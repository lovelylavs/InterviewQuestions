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
public class BinaryTreeIsBal {
    
    //Code runs O(n) times O(H) space where H is height of tree
    public static int checkHeight(TreeNode root)
    {
        //if the root is null the height of tree is 0
        if(root == null)
        {
            return 0;
        }
        
        //Check if left is balanced
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1 )
            return -1; //Tree is not balanced
        
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1)
            return -1; //Tree is not balanced
        
        //checking if current node is balanced
        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1)
            return -1; //not balanced
        else
        {
            return Math.max(leftHeight, rightHeight) + 1;
        
            
        }
    }
    
    public static boolean isBalanced(TreeNode root)
    {
        if(checkHeight(root) == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
