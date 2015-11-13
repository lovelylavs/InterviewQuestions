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
public class Stack 
{
    //Top node
    Node top;
    int size;
    //push
    public void push(int value)
    {
        //create new node for value to push
        Node t = new Node(value);
        t.next = top;
        
        //new node would be top node
        top=t;
        size++;
    }
    
    public int pop()
    {
        if(top != null)
        {
            //point top to next element
            int num = top.data;
            top = top.next;
            size--;
            return num;
            
            
        }
        return -1;
    }
    int peek()
    {
        return top.data;
    }
   
    public boolean isEmpty()
    {
        if(size==0)
            return true;
        else
            return false;
    }
    
}
