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
public class Queue2Stacks {
   
    //Two stacks are used to implement queue
    Stack s1;
    Stack s2;
  
    public Queue2Stacks()
    {
        //instantiate stacks
        s1 = new Stack();
        s2 = new Stack();
    }
    
    //The total size
    public int size()
    {
        return s1.size + s2.size;
    }
    
    //Add element to the first stack
    public void enqueue(int val)
    {
        s1.push(val);
    }
    
    //shift elements in stack s1 to s2 to maintain they are current always
    private void shiftStacks()
    {
        if(s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
        }
    }
    
    public int peek()
    {
        shiftStacks();
        return s2.peek();
    }
    
    //we shift the stack and remove the first element added by moving element to second 
    public int dequeue()
    {
        //shift elements to s2 and then pop
        
        shiftStacks();
        return s2.pop();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue2Stacks queue = new Queue2Stacks();
        queue.enqueue(12);
        System.out.println("pop" + queue.dequeue());
    }
    
}
