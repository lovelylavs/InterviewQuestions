/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedliststack;

/**
 *
 * @author Lavanya
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *

/**
 *
 * @author Lavanya
 */
public class LLNode 
{
    LLNode next = null;
    int data;
    
    public LLNode()
    {
        
    }
    
    public LLNode(int d)
    {
        data = d;
    }
    
    public LLNode(int data, LLNode next)
    {
        this.data = data;
        this.next = next;
    }
    
    public LLNode getNext()
    {
        
        return next;
    
    }
    public int getData()
    {
       return data;
    
    }
    public void setData(int newElem)
    {
       data = newElem;
    }
    public void setNext (LLNode newNext)
    {
       next = newNext;
    }
    
}

