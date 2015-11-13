/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bstminheight;

import java.util.Stack;

/**
 *
 * @author Lavanya
 */
public class BSTMinHeight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //sorted list
        int[] array = {5,1,8,3,10};
        TreeNode root = createMinimalBST(array);
        System.out.println(root.val);
        System.out.println(kthSmallestElem(root, 4));
    }
    
   public static  TreeNode createMinimalBST(int arr[], int start, int end)
    {
        if(end < start)
        {
            return null;
        }
        
        int mid = (start + end) /2;
        
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid -1);
        n.right = createMinimalBST(arr, mid+1, end);
        return n;
    }
    
    public static TreeNode createMinimalBST(int array[])
    {
        return createMinimalBST(array, 0, array.length-1);
    }
    
    public static int kthSmallestElem(TreeNode root, int k)
    {
         Stack<TreeNode> stack = new Stack<TreeNode>();
 
        TreeNode p = root;
        int result = 0;

        while(!stack.isEmpty() || p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                k--;
                if(k==0)
                    result = t.val;
                p = t.right;
            }
        }
 
    return result;
    }
}
