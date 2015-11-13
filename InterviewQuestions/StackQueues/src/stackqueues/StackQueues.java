/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackqueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Lavanya
 */
public class StackQueues {

    /**
     * @param args the command line arguments
     */
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
     public void push(int x) {
        
        //If Queue1 is empty add element to it
            if(q1.isEmpty())
           {
               q1.offer(x);
           }
           //If its not empty
           else if(q1.size() >0){
               q2.offer(x);
               int size = q1.size();
               
               //make q1 empty now
               while(size >0){
                   q2.offer(q1.poll());
                   size--;
               }
               
           }
           else if(q2.size() >0 ){
                q1.offer(x);
               int size = q2.size();
               while(size >0){
                   q1.offer(q2.poll());
                   size--;
               }
               
           }
    }

    // Removes the element on top of the stack.
    public void pop() {
       if(q1.size() >0){
           q1.poll();
       }else if(q2.size() >0){
           q2.poll();
       }
      }

    // Get the top element.
    public int top() {
        if(q1.size() >0){
           return q1.peek();
       }else if(q2.size() >0){
           return q2.peek();
       }
       return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }


    public static void main(String[] args) {
        // TODO code application logic here
        StackQueues stack = new StackQueues();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.push(6);
    }
    
}
