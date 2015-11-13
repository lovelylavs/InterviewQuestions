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
class Result
{
    public Node node;
    public boolean result;
    
    public Result(Node node, boolean result)
    {
        this.node = node;
        this.result = result;
    }
}
public class PalindromeRecurse {
    
    public static void main(String[] args) {
        MyList myList = new MyList();
        
        myList.append(1);
        myList.append(3);
        myList.append(4);
        myList.append(4);
        myList.append(3);
        myList.append(1);
        PalindromeRecurse palin = new PalindromeRecurse();
        System.out.println(palin.isPalindrome(myList.getHead()));
    }
    Result isPalindromeRecurse(Node head, int length)
    {
        if(head == null || length ==0)
            return new Result(null, true);
        
        else if(length==1)
        {
            return new Result(head.next, true);
        }
        else if(length ==2)
        {
            return new Result(head.next.next, head.data == head.next.data);
        }
        
        Result res = isPalindromeRecurse(head.next, length -2);
        if(!res.result || res.node == null)
            return res;
        else
        {
            res.result = head.data == res.node.data;
            res.node = res.node.next;
            return res;
        }
    }
    
    boolean isPalindrome(Node head)
    {
        int length=0;
        Node temp = head;
        while(temp != null)
        {
            temp = temp.next;
            length++;
        }
        Result p = isPalindromeRecurse(head,length);
        return p.result;
    }
}
