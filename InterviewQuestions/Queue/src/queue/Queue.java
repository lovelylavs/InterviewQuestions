/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queue;

/**
 *
 * @author Lavanya
 */
public class Queue 
{
    Node first, last;
    
    void enqueue(Object item)
    {
        if(first == null)
        {
            last = new Node(item);
            first = last;
        }
        else
        {
            last.next = new Node(item);
            last = last.next;
        }
    }
    
    Object dequeue()
    {
        if(first!=null)
        {
            Object item = first.data;
            first = first.next;
            return item;
        }
        return null;
    }
}
