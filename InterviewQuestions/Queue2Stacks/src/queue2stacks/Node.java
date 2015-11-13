/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queue2stacks;

/**
 *
 * @author Lavanya
 */
public class Node 
{
    Node next;
    
    int data;
    
    public Node(int data)
    {
        this.data = data;
    }
    public Node getNext()
    {
            return next;
    }
    
    public void setNext(Node n)
    {
        next = n;
    }
    public int getData()
    {
        return data;
    }
}
