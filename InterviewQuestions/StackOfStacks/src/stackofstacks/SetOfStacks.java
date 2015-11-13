/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackofstacks;

import java.util.ArrayList;


/**
 *
 * @author Lavanya
 */
public class SetOfStacks {
    
    //Stack of stacks
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity;
    
    public SetOfStacks(int capacity)
    {
        this.capacity= capacity;
    }
    
    //Get hold of last stack
    public Stack getLastStack()
    {
        if(stacks.size()==0) return null;
        return stacks.get(stacks.size()-1);                
    }
    
    //Push element into the last stack available
    public void push(int v)
    {
        Stack last = getLastStack();
        
        //Add to the last stack
        if(last != null && last.isEmpty())
        {
            last.push(v);
        }
        else
        {
            //must create new stack if previous stacks are full
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
            
        }
    }
    
    //Pop from stack
    public int pop()
    {
        //get the last stack
        Stack last = getLastStack();
        int v = last.pop();
        if(last.size==0)
            stacks.remove(stacks.size()-1);
        return v;
    }
    
    public boolean isEmpty()
    {
        Stack last = getLastStack();
        return last==null || last.isEmpty();        
    }
    
    public int popAt(int index)
    {
        return leftShift(index,true);
    }
    
    //left shift in case an element is poped from a particluar place
    public int leftShift(int index, boolean removeTop)
    {
        Stack stack = stacks.get(index);
        int removed_item;
        
        if(removeTop) removed_item= stack.pop();
        
        else removed_item = stack.removeBottom();
        
        if(stack.isEmpty())
            stacks.remove(index);
        else if(stacks.size() > index+1)
        {
            int v = leftShift(index +1, false);
            stack.push(v);
        }
        return removed_item;
        
    }
}


