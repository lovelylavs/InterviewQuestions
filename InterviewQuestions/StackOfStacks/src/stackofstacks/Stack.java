/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackofstacks;

import java.util.EmptyStackException;

/**
 *
 * @author Lavanya
 */


public class Stack 
{
    private int capacity;
    public Node top, bottom;
    public int size=0;
    
    //constructor
    public Stack(int capacity)
    {
        this.capacity = capacity;
    }
    
    //check if stack is full
    public boolean isFull()
    {
        return capacity==size;
    }
    
    public void join(Node above, Node below) {
		if (below != null) below.above = above;
		if (above != null) above.below = below;
	}
	
   public boolean push(int v)
   {
       if(size >= capacity) return false;
       size++;
       
       Node n = new Node(v);
       if(size==1) bottom =n;
       join(n,top);
       top=n;
       return true;          
   }
   
   public int pop()
   {
       if (top == null) throw new EmptyStackException();
       Node t = top;
       top = top.below;
       System.out.println("size"+size);
       size--;
       return t.value;
   }
   
   public boolean isEmpty()
   {
       return size==0;
   }
   
   public int removeBottom()
   {
       Node b = bottom;
       bottom = bottom.above;
       if(bottom != null) bottom.below=null;
       size--;
       return b.value;
   }
}
