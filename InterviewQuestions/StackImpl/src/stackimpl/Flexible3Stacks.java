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

        
        public class Flexible3Stacks
        {
            int number_of_stacks = 3;
            int default_size=4;
            int total_size = default_size * number_of_stacks;
            
            StackData[] stacks = {new StackData(0,default_size), new StackData(default_size, default_size), new StackData(default_size*2, default_size)};
            
            int[] buffer = new int[total_size];
            
            public static void main(String[] args) throws Exception
            {
                Flexible3Stacks st = new Flexible3Stacks();
                st.push(0,10);
                st.push(1,20);
                st.pop(0);
                
            }
            
            public int numberOfElements()
            {
                return stacks[0].size +stacks[1].size + stacks[2].size;
            }
            
            public  int nextElement(int index)
            {
                if(index + 1 == total_size) return 0;
                else
                    return index+1;
            }
              
            public  int previousElement(int index)
            {
                if(index  == 0) return total_size-1;
                else
                    return index-1;
            }
            
            public  void shift(int stackNum)
            {
                StackData stack = stacks[stackNum];
                if(stack.size >= stack.capacity)
                {
                    int nextStack = (stackNum+1) % number_of_stacks;
                    shift(nextStack); //make some room
                    stack.capacity++;
                }
                
                //Shift elements in reverse order
                for(int i= (stack.start + stack.capacity-1)%total_size;
                        stack.isWithinStack(i, total_size);
                        i=previousElement(i))
                {
                    buffer[stack.start]=0;
                    stack.start = nextElement(stack.start); // move stack start
                    stack.pointer = nextElement(stack.pointer); // move pointer
                    stack.capacity--; // return capacity to original
                }
            }
            
            /*Expand stack by shifting over other stacks */
            public void expand(int stackNum)
            {
                shift((stackNum+1) % number_of_stacks);
                stacks[stackNum].capacity++;
            }
            
            public void push(int stackNum, int value) throws Exception
            {
                StackData stack = stacks[stackNum];
                
                //Check if we have space
                if(stack.size >= stack.capacity)
                {
                    if(numberOfElements() >= total_size)
                    {
                        throw new Exception("Out of space");
                    }
                    else
                    {
                        //Just need to shift things around
                        expand(stackNum);
                    }
                }
                
                // Find the index of top element in the array +1, and increment the stack pointer
                stack.size++;
                stack.pointer =nextElement(stack.pointer);
                buffer[stack.pointer]=value;
            }
            
            public  int pop(int stackNum) throws Exception
            {
                StackData stack = stacks[stackNum];
                if(stack.size==0)
                {
                    throw new Exception("Trying to pop an empty stack.");
                }
                int value = buffer[stack.pointer];
                System.out.println("value:" + value);
                buffer[stack.pointer]= previousElement(stack.pointer);
                stack.pointer = previousElement(stack.pointer);
                stack.size--;
                return value;
            }
            
            public  int peek(int stackNum)
            {
                StackData stack = stacks[stackNum];
                return buffer[stack.pointer];
            }
            
            public boolean  isEmpty(int stackNum)
            {
                StackData stack = stacks[stackNum];
                return stack.size==0;
            }
        }
 

