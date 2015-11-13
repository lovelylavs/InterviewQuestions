/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackimpl;

import java.util.Stack;
/**
 *
 * @author Lavanya
 */
//Extending from the Java Stack Collection
public class StackMin extends Stack<Integer>
{
    //Another stack to keep track of minimum value
    Stack<Integer> s2;
    
    public StackMin()
    {
        s2= new Stack<Integer>();
    }
    
    public void push(int num)
    {
        //if element is less than min also push it into the new stack
        if(num<=min())
        {
            s2.push(num);
        }
        super.push(num);
    }
    
    @Override
    //Number is minimum element
    public Integer pop()
    {
        int num = super.pop();
        //If element being popped out os also minimum element pop t out from stack s2
        if(num==min())
        {
            s2.pop();
        }
        System.out.println("Element poped"+num);
        return num;
    }
    
    //Gets the minimum value
    public int min()
    {
        if(s2.isEmpty())
            return Integer.MAX_VALUE;
        else
            return s2.peek();
    }
    
    public static void main(String[] args)
    {
        StackMin stack = new StackMin();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.pop();
    }
}
