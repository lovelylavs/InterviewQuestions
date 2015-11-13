/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Lavanya
 */
public class LevelOrderBottom {
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        System.out.println("Binary tree example");
        System.out.println("Building tree with root value"+root.val);
        BinaryTree bt = new BinaryTree();
        bt.insert(root,9);
        bt.insert(root,20);
        bt.insert(root,15);
        bt.insert(root,7);
        LevelOrderBottom level = new LevelOrderBottom();
        List<List<Integer>> l = level.levelOrderBottom(root);
        for(List<Integer> list : l){
            for(int n : list){
                System.out.print("\t"+n);
            }
            System.out.println(" ");
        }
    }
    
     public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null)
            return levelOrder;
        
        int cur=1,next=0;
        List<Integer> list = new ArrayList<>();
        queue.add(root);
            
        while(queue.size()>0){
         
            TreeNode temp = queue.peek();
            queue.remove();
            
            cur--;
            if(temp != null){
                list.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
                next+=2;
            }
            
            if(cur==0){
                if(list.size()>0)
                    levelOrder.add(list);
                cur=next;
                next=0;
                list = new ArrayList<>();                
                }
        }
               List<List<Integer>> reversedResult = new  ArrayList<>();
            for(int i=levelOrder.size()-1; i>=0; i--){
            reversedResult.add(levelOrder.get(i));

        }
        
        return reversedResult;

    }
}
