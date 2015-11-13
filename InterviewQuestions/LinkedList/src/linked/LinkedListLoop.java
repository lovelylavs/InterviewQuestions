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
public class LinkedListLoop 
{
    static boolean hasLoop(Node first) {

    if(first==null) return false;
        Node slow,fast;
        slow = fast = first; //two pointers one iwth one hop and other with two ho[s]
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
}
    
    public static Node detectCycle(Node head) {
        
        if(head == null)
          return head;
        Node slow= head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
             if(slow == fast)
            {
                while(head != slow)
                {
                    slow=slow.next;
                    head=head.next;
                }
                return slow;
            }
        }
       
        return null;
    }
    
    public static void main(String[] args)
    {
        MyList list = new MyList();
        list.append(3);/*
        list.append(29);
        list.append(3);
        list.append(12);
        list.append(29);
        list.append(29);
        list.append(23);
        list.append(34);
        list.append(3);

        list.print();*/
        System.out.println(hasLoop(list.getHead()));
        Node x = detectCycle(list.getHead());
        System.out.println(x.data);
    }
}
