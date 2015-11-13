/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedleet;

/**
 *
 * @author Lavanya
 */
public class LinkedLeet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      /*  ListNode n1 = new ListNode(1);
        ListNode n11 = new ListNode(1);
        ListNode n111 = new ListNode(1);
        ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
/*ListNode n4 = new ListNode(4);
ListNode n5 = new ListNode(5);
		n1.next = n11;
                n11.next=n111;
                n111.next = n2;
		n2.next = n3;
                n3.next = n4;
                n4.next = n5;*/
                ListNode n1 = new ListNode(3);
                ListNode n2 = new ListNode(4);
                ListNode n3 = new ListNode(2);
                ListNode n4 = new ListNode(4);
                n1.next = n2;
                n2.next = n3;
                n3.next = n4;
               /* ListNode n4 = new ListNode(4);
                ListNode n5 = new ListNode(6);
                ListNode n6 = new ListNode(5);
        
                n4.next = n5;
                n5.next = n6;*/
                printList(n1);
                //printList(reverseList(n1));
                //ListNode n = deleteAllDuplicates(n1);
                ListNode n = swapPairs(n1);
               printList(n);
    }
    
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode preM=result; //preM is the node before orignal M
        ListNode mNode=head;    //M is after preM

        for(int i=1;i<m;i++){ //Move preM and M to orignal place
            preM=preM.next;
            mNode=mNode.next;
        }

        for(int i=0;i<n-m;i++){ 
            ListNode current=mNode.next; //Both preM and M are all fixed, only current is assigned every time to M.next. M is pushed back everytime
            mNode.next=current.next;     //Move current to the position after preM
            current.next=preM.next;
            preM.next=current;
        }

        return result.next;       
    }
    
    public static ListNode deleteAllDuplicates(ListNode head) {
        if(head == null)
          return null;
        ListNode t1 = new ListNode(0);
        t1.next = head;
        ListNode temp = t1;

        while(temp.next != null && temp.next.next != null)
        {
         
            if(temp.next.val == temp.next.next.val)
            {
                int dupVal = temp.next.val;
                while(temp.next != null && temp.next.val == dupVal)
                {
                    temp.next = temp.next.next;
                }
            }
            else
            {
                temp=temp.next;
            }
        }
        return t1.next;
        
    }
    public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.val+"->");
			n = n.next;
		}
		System.out.println();
	}
    
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
        {
            return null;
        }
        ListNode temp = head;
        while( temp.next != null)
        {
            ListNode nxtNode = temp.next;
            if(temp.val == nxtNode.val)
            {
                temp.next = nxtNode.next;
            }
            else
            {
                temp = temp.next;
            }
            
        }
        
        return head;
    }
    
    public static ListNode reverseList(ListNode head) {
       
        ListNode list1 =head;
        ListNode list2 = head.next;
        
        //set the head pointer to last to reverse
        head.next = null;
        
        while(list1 != null && list2 != null)
        {
            ListNode temp = list2.next;
            list2.next = list1;
            list1 = list2;
            
            if(temp != null)
            {
                list2 = temp;
            }
            else
            {
                break;
            }

        }
        return list2;
    }
    
    public static ListNode revList(ListNode head)
    {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = result;
            result = cur;
            cur = temp;
        }
        return result; 
    }
    
    public static ListNode recRevList(ListNode head)
    {
        if( head == null)
        {
            return null;
        }
        if(head.next == null)
        {
            return head;
        }
        ListNode newNode = recRevList(head.next);
        head.next.next = head;
        head.next = null;
        
        return newNode;
    }
    public static ListNode reverseRange(ListNode start, int len) {
    ListNode result = null;
    ListNode cur = start;
    while (len > 0) {
        ListNode temp = cur.next;
        cur.next = result;
        result = cur;
        cur = temp;
        len--;
    }
    start.next = cur;
    return result;
}
    public static ListNode addDigits(ListNode n1, ListNode n2)
    {
        int carry =0;
 
        ListNode newHead = new ListNode(0);
        ListNode list1 = n1, list2 = n2, result=newHead;
 
        while(list1 != null || list2 != null){
            if(list1 != null){
                carry += list1.val;
                list1 = list1.next;
            }
 
            if(list2 != null){
                carry += list2.val;
                list2 = list2.next;
            }
 
            result.next = new ListNode(carry%10);
            result = result.next;
            carry /= 10;
        }
 
        if(carry==1) 
            result.next=new ListNode(1);
 
        return newHead.next;
    }

    public static ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null)   
        return head;
 
    ListNode h = new ListNode(0);
    h.next = head;
    ListNode p = h;
 
    while(p.next != null && p.next.next != null){
        //use t1 to track first node
        ListNode t1 = p;
        p = p.next;
        t1.next = p.next;
 
        //use t2 to track next node of the pair
        ListNode t2 = p.next.next;
        p.next.next = p;
        p.next = t2;
    }
 
    return h.next;
}
}
