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
class BSTNode
{
    int data;
    BSTNode parent;
    BSTNode left;
    BSTNode right;

    public BSTNode(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public BSTNode()
    {
    }
}

public class BSTFunctions
{
    BSTNode ROOT;

    public BSTFunctions()
    {
        this.ROOT = null;
    }

    void insertNode(BSTNode node, int data)
    {
        if (node == null)
        {
            node = new BSTNode(data);
            ROOT = node;
        }
        else if (data < node.data && node.left == null)
        {
            node.left = new BSTNode(data);
            node.left.parent = node;
        }
        else if (data >= node.data && node.right == null)
        {
            node.right = new BSTNode(data);
            node.right.parent = node;
        }
        else
        {
            if (data < node.data)
            {
                insertNode(node.left, data);
            }
            else
            {
                insertNode(node.right, data);
            }
        }
    }

    public boolean search(BSTNode node, int data)
    {
        if (node == null)
        {
            return false;
        }
        else if (node.data == data)
        {
            return true;
        }
        else
        {
            if (data < node.data)
            {
                return search(node.left, data);
            }
            else
            {
                return search(node.right, data);
            }
        }
    }

    public void printInOrder(BSTNode node)
    {
        if (node != null)
        {
            printInOrder(node.left);
            System.out.print(node.data + " - ");
            printInOrder(node.right);
        }
    }

    public void printPostOrder(BSTNode node)
    {
        if (node != null)
        {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + " - ");
        }
    }

    public void printPreOrder(BSTNode node)
    {
        if (node != null)
        {
            System.out.print(node.data + " - ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
    
    //This function prints all keys which are in the range [k1 ..k2]
    public void keysInRange(BSTNode node, int k1, int k2)
    {
        int min=Integer.MAX_VALUE;
        //base case
        if(node != null)
          {           
            //As the input is sorted recurse for left sub tree first
            //If node.data is greater than can we recurse for left sub tree
            if(node.data > k1){                
                keysInRange(node.left,k1,k2);
            }
            
            //If the node data lies in range than display node's data
            if(k1 <= node.data && k2 >= node.data)
            {                
                System.out.println("data"+node.data);
                if(min > node.data)
                    min = node.data;
            }
            if(node.data < k2){
                keysInRange(node.right,k1,k2);
            }
        }
        System.out.println("min"+min);
    }

    public static void main(String[] args)
    {
        BSTFunctions f = new BSTFunctions();
        /**
         * Insert
         */
        f.insertNode(f.ROOT, 20);
        f.insertNode(f.ROOT, 5);
        f.insertNode(f.ROOT, 25);
        f.insertNode(f.ROOT, 3);
        f.insertNode(f.ROOT, 7);
        f.insertNode(f.ROOT, 27);
        f.insertNode(f.ROOT, 24);

        /**
         * Print
         */
        f.printInOrder(f.ROOT);
        System.out.println("");
        f.printPostOrder(f.ROOT);
        System.out.println("");
        f.printPreOrder(f.ROOT);
        System.out.println("");

        /**
         * Search
         */
        System.out.println(f.search(f.ROOT, 27) ? "Found" : "Not Found");
        System.out.println(f.search(f.ROOT, 10) ? "Found" : "Not Found");
        
        f.keysInRange(f.ROOT, 5, 10);
    }
}
