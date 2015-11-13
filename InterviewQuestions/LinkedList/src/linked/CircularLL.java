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
public class CircularLL 
{
    protected Node start;
    protected Node end;
    public int size;
    
    
    public CircularLL()
    {
        start = null;
        end = null;
        size =0;
    }
    
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val);
        
        nptr.setNext(start);
        
        if(start==null)
        {
            start=nptr;
            nptr.setNext(start);
            end=start;
        }
        else
        {
            end.setNext(nptr);
            end=nptr;
        }
        size++;
    }
    
    //Node at beginning of loop
    //1. Create pointers slow and fast
    //2. fast moves twice as fast as slow and break where slow meets fast, the meeting point
    //3 make slow the head
    public Node findBegin(Node head)
    {
        Node slow = head;
        Node fast = head;
        
        //finding the meeting point. This would be LOOP_SIZE - k steps into linked list
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                break;
        }
        
        //Check no meeting point and hence no loop
        if(fast == null || fast.next == null)
            return null;
        
        //Move slow to head. Keep fast at meeting point.
        //Each are k steps from loop start. If they move at the same pace, they must meet
        //at Loop start
        //Node at beginning of loop
        slow = head;
        while( slow != fast)
        {
            slow=slow.next;
            fast = fast.next;
        }
        return fast;
    }
    
    public static void main(String[] args)
    {
        MyList myList = new MyList();
        myList.print();
        myList.append(35);
        myList.append(33);
        myList.append(31);
        myList.append(309);
        myList.append(337);
        myList.append(318);
        myList.append(302);
        CircularLL cl = new CircularLL();
        Node x = cl.findBegin(myList.getHead());
        if(x==null)
            System.out.println("This linked list does not have a loop");
        
    }
}
