/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stacksorting;

/**
 *
 * @author Lavanya
 */
public class Stack 
{
    Node top;
    int size;
    
    public void push(int val)
    {
        Node nNode = new Node(val);
        nNode.next = top;
        top = nNode;
        size++;
    }
    
    public int pop()
    {
        if(top != null)
        {
            int num = top.data;
            top.next = top;
            size--;
            return num;
        }
        return -1;
    }
}
