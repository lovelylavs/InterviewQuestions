/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linked;

/**
 *
 * @author Lavanya
 */
public class NumbersSum 
{
    public static void main(String[] args)
    {
        int val1 = 617, val2=295;
        int digit=0;
        Node num1= null;
        Node newNode = null;
        while(val1>0)
        {
            digit = val1%10;
            if(num1 != null)
            {
                newNode = new Node(digit);
                
                while(num1.next != null)
                {
                    num1 = num1.next;
                }
                num1.next = newNode;
            }
            else
            {
                num1 = new Node(digit);
            }
            val1=val1/10;
            
        }
    }
    public void sumNumbers(Node num1, Node num2)
    {
        int value1=0,value2=0, i=0,j=0;
        while(num1.next != null)
        {
            value1= value1 + (num1.data *(int)Math.pow(10, i));
            num1 = num1.next;
        }
        
        while(num2.next != null)
        {
            value2= value2 + (num2.data *(int)Math.pow(10, i));
            num2 = num2.next;
        }
        System.out.println("value1"+value1 + "\n"+"value2"+value2);
    }
    
    public Node addLists(Node l1, Node l2, int carry)
    {
        if(l1 == null && l2 == null && carry ==0)
            return null;
        
        Node result = null;
        
        /* Add va;ue and data from l1 and l2*/
        int value = carry;
        if(l1 != null)
        {
            value+=l1.data;
        }
        
        if(l2 != null)
        {
            value+=l2.data;
        }
        
        result = new Node(value%10);
        
        if(l1 != null || l2 != null)
        {
            Node more = addLists(l1==null?null:l1.next, l2==null?null:l2.next, value >=10?1:0);
            result.setNext(more);
            
        }
        return result;
    }
    
}
