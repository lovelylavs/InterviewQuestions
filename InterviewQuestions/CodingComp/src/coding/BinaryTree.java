/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coding;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Lavanya
 */
public class BinaryTree 
{
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
    
    public static void byLevel(Node root){
     Queue<Node> q  = new LinkedList<>();
     q.add(root);
     while(!q.isEmpty()){
         Node temp = q.remove();
            System.out.println(temp.value);
            if(temp.Left != null)
                q.add(temp.Left);
            if(temp.Right != null)
                q.add(temp.Right);
     }
    }

    /**
     *
     * @param tmpRoot
     */
    public static void print(Node tmpRoot) {

        Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel = new LinkedList<Node>();

        currentLevel.add(tmpRoot);

        while (!currentLevel.isEmpty()) {
            Iterator<Node> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                Node currentNode = iter.next();
                if (currentNode.Left != null) {
                    nextLevel.add(currentNode.Left);
                }
                if (currentNode.Right != null) {
                    nextLevel.add(currentNode.Right);
                }
                System.out.print(currentNode.value + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node>();

        

    }

}
    public static void printPostOrder(Node node){
        if(node != null){                       
            printPostOrder(node.Left);
            printPostOrder(node.Right);
            System.out.println("Traversed:"+node.value);
        }          
    }
    
    public static void main(String[] args)
    {
        System.out.println("Please enter your input");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.contains(","))
        {
            List<String> myList = Arrays.asList(str.split(","));
            List<Integer> newList = new ArrayList<Integer>();
            for(int i=0;i<myList.size();i++)
            {
                if(!newList.contains(Integer.parseInt(myList.get(i))))
                {
                    newList.add(Integer.parseInt(myList.get(i)));
                }
            }
            

            Node root = new Node(0);
            System.out.println("Binary tree example");
            System.out.println("Building tree with root value"+root.value);
            printPostOrder(root);
            print(root);
        }
        else 
            System.out.println("Invalid ");
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
