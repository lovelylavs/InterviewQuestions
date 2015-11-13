/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackimpl;

/**
 *
 * @author Lavanya
 */
public class Arr3Stacks 
{
    int stackSize = 100; // Each stack size is 100
    int[] buffer = new int[stackSize * 3]; //buffer is 3 times
    int[] stackPointer = {-1,-1,-1}; //stack pointer for each
        
    public void push(int stackNum, int value) throws Exception
    {
        //Check if space is available
        if(stackPointer[stackNum] +1 >= stackSize)
        {
            throw new Exception("Out of space");
        }
        stackPointer[stackNum]++;
        
        buffer[absTopofStack(stackNum)]=value;
        
    }
    
    int pop(int stackNum) throws Exception
    {
        if(stackPointer[stackNum]==-1)
        {
            throw new Exception("Trying to pop an empty stack");
        }
        
        int value = buffer[absTopofStack(stackNum)];
        buffer[absTopofStack(stackNum)]=0;
        stackPointer[stackNum]--;
        return value;
    }
    
    int peek(int stackNum)
    {
        int index = absTopofStack(stackNum);
        return buffer[index];
    }
    boolean isEmpty(int stackNum)
    {
        return stackPointer[stackNum] == -1;
    }
    //index of top of stack "stacknum" in absolute terms.
    int absTopofStack(int stackNum)
    {
        return stackNum * stackSize + stackPointer[stackNum];
    }
    
    public static void main(String[] args)
    {
        Arr3Stacks stack = new Arr3Stacks();
        try
        {
        stack.push(1, 12);
        }
        catch(Exception e)
        {
            System.out.println("Exception");
        }
    }
}
