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
public class LinkedListStack 
{
    private LLNode first;
    private int N;
    
    public boolean isEmpty()
    {
        return first==null;
    }
    public void push(int data)
    {
        LLNode oldNode = first;
        first = new LLNode();
        first.data = data;
        first.next = oldNode;
        N++;            
    }
    
    public int pop()
    {
        if(isEmpty()) 
        {
             return 0;
            //throw new RuntimeException("stack underflow");          
        }
         else
           {
                int item = first.getData();
                first=first.getNext();
                N--;
                return item;
           }
        }
    
    public void print() {
        System.out.println("");
        if(first == null){
            System.out.print("EMPTY");
            return;
        }
        LLNode tmpNode = first;
        while (tmpNode != null) {
            System.out.print(tmpNode.data + " -> ");
            tmpNode = tmpNode.next;
        }
    }
    
    public static void main(String[] args)
    {
        LinkedListStack myStack = new LinkedListStack();
        myStack.push(10);
        myStack.push(20);
        myStack.print();
        
    }
    
    
}
