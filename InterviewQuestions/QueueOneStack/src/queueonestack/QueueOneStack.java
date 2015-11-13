/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queueonestack;

/**
 *
 * @author Lavanya
 */
public class QueueOneStack<E> {
 //stack is last in first out
 //Queue is first in first out   
    private java.util.Stack<E> stack = new java.util.Stack<E>();
    //Second stack is by recursive calls to insert method.
    
    /*Principles while inserting new element into queue
    You need to transfer elements from one stack to another temporary stack, to reverse their order.
Then push the new element to be inserted, onto the temporary stack
Then transfer the elements back to the original stack
The new element will be on the bottom of the stack, and the oldest element is on top (first to be popped)*/
    
    
    public void insert(E elem) {
        if (!stack.empty()) {
            E topElem = stack.pop();
            insert(elem);
            stack.push(topElem);
        }
        else
            stack.push(elem);
    }

    public E remove() {
        return stack.pop();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
