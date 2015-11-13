/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackimpl;



/**
 *
 * @author Lavanya
 */

public class StackImpl {

    Node top;
    
    Object pop()
    {
        if(top != null)
        {
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }
    
    void push(Object item)
    {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }
    
    Object peek()
    {
        return top.data;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
