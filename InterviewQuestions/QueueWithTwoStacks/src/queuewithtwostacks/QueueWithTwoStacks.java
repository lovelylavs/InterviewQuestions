/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queuewithtwostacks;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 *
 * @author Lavanya
 */
public class QueueWithTwoStacks <Item>
{

    private Stack<Item> inbox;    // back of queue
    private Stack<Item> outbox;    // front of queue

    // create an empty queue
    public QueueWithTwoStacks() {
        inbox = new Stack<Item>();
        outbox = new Stack<Item>();
    }

    // move all items from inbox to outbox
    private void moveStack1ToStack2() {
        while (!inbox.isEmpty())
            outbox.push(inbox.pop());
    }

    // is the queue empty?
    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }


    // return the number of items in the queue.
    public int size() {
        return inbox.size() + outbox.size();     
    }

    // return the item least recently added to the queue.
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (outbox.isEmpty()) moveStack1ToStack2();
        return outbox.peek();
    }

    // add the item to the queue
    public void enqueue(Item item) {
        inbox.push(item);
    }

    // remove and return the item on the queue least recently added
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (outbox.isEmpty()) moveStack1ToStack2();
        return outbox.pop();
    }


    // a test client
    public static void main(String[] args) {
        QueueWithTwoStacks<String> q = new QueueWithTwoStacks<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
    
}
