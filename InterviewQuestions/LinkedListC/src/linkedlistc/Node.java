/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlistc;

/**
 *
 * @author Lavanya
 */
public class Node 
{
    Node next = null;
    int data;
    
    public Node(int d)
    {
        data = d;
    }
    
    void appendToTail(int d)
    {
        //new node 
        Node end = new Node(d);
        //to traverse the list to insert the node
        Node n = this;
        
        while(n.next != null)
        {
            n= n.next;
        }
        //at end of list insert the new node
        n.next = end;
    }
    
   
   
    
}
