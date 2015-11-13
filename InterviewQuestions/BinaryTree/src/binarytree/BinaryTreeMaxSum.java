/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import static binarytree.BinaryTree.insert;

/**
 *
 * @author Lavanya
 */
public class BinaryTreeMaxSum 
{
    static int max;
    
    public  static int maxPathSum(Node root)
    {
        max = (root == null)?0:root.value;
        findMax(root);
        return max;
        
    }
    
    public static int findMax(Node node)
    {
        if(node == null){
            return 0;
        }
        
        //recursively get sum of left and right
        int left = Math.max(findMax(node.Left),0);
        int right = Math.max(findMax(node.Right),0);
        
        //update maximum
        max = Math.max(node.value + left + right , max);
        return node.value + Math.max(left, right);
    }
    public static void main(String[] args)
    {
        Node root = new Node(5);
        System.out.println("Binary tree example");
        System.out.println("Building tree with root value"+root.value);
        insert(root,1);
        insert(root,8);
        insert(root,6);
        insert(root,3);
        insert(root,9);
        System.out.println(maxPathSum(root));
    }
}