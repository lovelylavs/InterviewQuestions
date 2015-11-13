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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Node 
{
    //next node pointer
    Node next = null;
    
    //data
    Object data;
    
    //constructor
    public Node(int d)
    {
        data = d;
    }
    public Node(Object d)
    {
        data = d;
    }
    
    public Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
    
    public Node getNext()
    {
        
        return next;
    
    }
    public Object getData()
    {
//        if (next == null) {
//            return 0;
//        }
        
        return data;
    
    }
    public void setData(Object newElem)
    {
       data = newElem;
    }
    public void setNext (Node newNext)
    {
       next = newNext;
    }
    
}

