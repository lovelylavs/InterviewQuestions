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
public class BinaryTree 
{
    public static int height(Node root)
    {
        if(root == null)
            return 0;
        
        else return Math.max(height(root.Left), height(root.Right));
    }
    public static boolean checkBalanced(Node root)
    {
        int lHeight =0;
        int rHeight =0;
        
        if(root == null)
        {
            return true;
        }
        lHeight=height(root.Left);
        rHeight=height(root.Right);
        
        if( (Math.abs(lHeight-rHeight) <= 1) &&
            checkBalanced(root.Left) &&
            checkBalanced(root.Right))
        return true;

      /* If we reach here then tree is not height-balanced */
      return false;
        
    }
    public static void insert(Node node,int value)
    {
        if(value<node.value) //check if value less than present node value
        {
            if(node.Left != null) //so new node to left of present node
            {
                insert(node.Left,value); //recursive call
            }
            else
            {
                System.out.println("Inserted " + value + "to the left of " + node.value);
                node.Left = new Node(value);//create the node
            }
        }
        else if(value>node.value)//check if value greater than present node value
        {
            if(node.Right != null) //so new node to right of present node
            {
                insert(node.Right,value);//recursive call
            }
            else
            {
                System.out.println("Inserted " + value + "to the right of " + node.value);
                node.Right = new Node(value);
            }
        }
    }
    
    public void insert(TreeNode node,int value)
    {
        if(value<node.val) //check if value less than present node value
        {
            if(node.left != null) //so new node to left of present node
            {
                insert(node.left,value); //recursive call
            }
            else
            {
                System.out.println("Inserted " + value + "to the left of " + node.val);
                node.left = new TreeNode(value);//create the node
            }
        }
        else if(value>node.val)//check if value greater than present node value
        {
            if(node.right != null) //so new node to right of present node
            {
                insert(node.right,value);//recursive call
            }
            else
            {
                System.out.println("Inserted " + value + "to the right of " + node.val);
                node.right = new TreeNode(value);
            }
        }
    }

    
    public static void printInOrder(Node node){
        if(node != null){
            printInOrder(node.Left);
            System.out.println("Traversed:"+node.value);
            printInOrder(node.Right);
        }          
    }
    
    public static void printPreOrder(Node node){
        if(node != null){           
            System.out.println("Traversed:"+node.value);
            printInOrder(node.Left);
            printInOrder(node.Right);
        }          
    }
    
    public static void printPostOrder(Node node){
        if(node != null){                       
            printInOrder(node.Left);
            printInOrder(node.Right);
            System.out.println("Traversed:"+node.value);
        }          
    }
    
    public static void printFrontToBack(Node node,int sample)
    {
        if(node==null)
          System.out.println("Null input");
        if(node.value>sample){
            printFrontToBack(node.Left, sample);
            System.out.println("Traversed"+node.value);
            printFrontToBack(node.Right, sample);
        }
        else if(node.value<sample){
            printFrontToBack(node.Right, sample);
            System.out.println("Traversed"+node.value);
            printFrontToBack(node.Left, sample);
        }
        else{
            printFrontToBack(node.Left, sample);
            printFrontToBack(node.Right, sample);
        }                    
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
        System.out.println("Traverse in order");
        printInOrder(root);
        System.out.println("Traverse Pre order");
        printPreOrder(root);
        System.out.println("Traverse Post order");
        printPostOrder(root);
        //System.out.println("Traverse from 7");
        //printFrontToBack(root, 9);
        System.out.println("Tree is balanced"+checkBalanced(root));
    }
    
    
    
}
class Node
{
    Node Left;
    Node Right;
    int value;
    
    public Node(int value)
    {
        this.value = value;
    }
}
