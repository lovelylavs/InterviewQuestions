/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import static binarytree.BinaryTree.insert;
import static binarytree.BinaryTreeMaxSum.maxPathSum;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Lavanya
 */
public class MinimumDepth {
    
    //using breadth first search
    public static int minDepth(Node root)
    {
        if(root == null){
            return 0;
        }
        //USe a queue 
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level=0;
        
        //while the queue is not empty
        while(queue.size()>0){
            
            //get the first element from queue
            Node current = queue.poll();
            if(current == null){
                level++;
                if(queue.size()>0)
                    //Add null to the queue to keep track of levels
                    queue.offer(null);
            }
            else{
                if(current.Left ==null && current.Right == null){
                    return ++level;         
                }
                if(current.Left != null)
                    queue.add(current.Left);
                if(current.Right != null)
                    queue.add(current.Right);
            }
                
        }
         return -1;   
    }
    
    //using depth first search
    public static int minDep(Node root)
    {
        if(root == null ) return 0;
        if(root.Left == null && root.Right == null) return 1;
        int left = minDep(root.Left);
        int right = minDep(root.Right);
        if(left==0) return right+1;
        if(right==0) return left+1;
        return Math.min(left, right)+1;
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
        System.out.println(minDepth(root));
        System.out.println(minDep(root));
    }
    
    
}
