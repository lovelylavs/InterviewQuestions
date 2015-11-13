/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dfsbfs;

import java.util.ArrayList;

/**
 *
 * @author Lavanya
 */
public class BfsDfsDemo 
{
    public static void main(String[] args)
    {
        //tree is like 
        //1->2 1->5 1->6
        //2->3 2-> 4
        //5->4
        Node<Integer> root = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        
        root.addChild(node2);
        root.addChild(node5);
        root.addChild(node6);

        node2.addChild(node3);
        node2.addChild(node4);
        
        node5.addChild(node4);
        
        Tree<Integer> tree = new Tree<>(root);

        ArrayList<Node<Integer>> preOrder = tree.getPreOrderTraversal();
        
        for(int i=0;i<preOrder.size();i++)
        {
            System.out.println(preOrder.get(i));
        }
        System.out.println("Path from root to any leaf");
       ArrayList<ArrayList<Node<Integer>>> paths = tree.getPathsFromRootToAnyLeaf();
       for(int i=0; i<paths.size(); i++)
       {
           ArrayList<Node<Integer>> node = paths.get(i);
            System.out.println("Path:" +i);
            for(int j=0;j<node.size();j++)
            {
                System.out.println(node.get(j));
            }
       }
        
        for(int i=0;i<preOrder.size();i++)
        {
            System.out.println(preOrder.get(i));
        }

    }
}
