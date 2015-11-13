/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myqueue;

import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Lavanya
 */
public class MyQueue {

    /**
     * @param args the command line arguments
     */
    Stack<Integer> front = new Stack<>();
    Stack<Integer> back = new Stack<>();
    // Push element x to the back of queue.
 public void push(int x) {
        //If back is empty push element to back
        if(back.isEmpty()){
            back.push(x);
        }
        //If back is not empty
        else{
            //add elements from back to front
            while(!back.isEmpty()){
                front.push(back.pop());
            }
            
            //add element to back
            back.push(x);
            
            while(!front.isEmpty()){
                back.push(front.pop());
            }
        }
        
    }


    // Removes the element from in front of queue.
    public void pop() {
        back.pop();
    }

    // Get the front element.
    public int peek() {
        return back.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return back.isEmpty();
    }
    
    public static void main(String[] args)
    {
        MyQueue m = new MyQueue();
        m.push(1);
        m.push(2);
        m.pop();
        System.out.println(m.empty());
    }
}
