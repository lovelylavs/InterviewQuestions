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
    class NodeWithMin
    {
       public int value;
       public int min;
       
       public NodeWithMin(int value,int min)
       {
           this.value = value;
           this.min = min;
       }
    }
public class StackCMin extends Stack<NodeWithMin> {
    
   public void push(int value)
   {
       int newMin = Math.min(value, min());
       super.push(new NodeWithMin(value, newMin));
   }
   
   public int min()
   {
       if(this.isEmpty())
       {
           return Integer.MAX_VALUE;
       }
       else
           return peek().min;
   }
    
}


