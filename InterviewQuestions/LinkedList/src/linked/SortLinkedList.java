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
public class SortLinkedList 
{
    public static Node insertionSortList(Node head)
    {
        if(head == null || head.next == null)
           return head;
            
        Node newHead = new Node(head.data);//new list which is sorted
        Node pointer = head.next;//pointer holds next element of list
        
        //loop through each element in the list
        while(pointer != null)
        {
            //insert this element into the new list
            Node innerPointer = newHead;//new list
            Node next = pointer.next; //old list next pointer
            
            if(pointer.data <= newHead.data)//checks if new list has values less then old list
            {
                Node oldHead = newHead;
                newHead=pointer;
                newHead.next = oldHead;
                
            }
            else
            {
                while(innerPointer.next != null)
                {
                    if(pointer.data>innerPointer.data && pointer.data<=innerPointer.next.data)
                    {
                        Node oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }
                    innerPointer = innerPointer.next;
                }
                //check if element being added to new list has values greater 
                //than elements already present
                if(innerPointer.next == null &&pointer.data>innerPointer.data)
                {
                    innerPointer.next=pointer;
                    pointer.next = null;
                }
            }
            pointer=next;
            
            }
        return newHead;
    }
    public static void print(Node x) {
        System.out.println("");
        if(x == null){
            System.out.print("EMPTY");
            return;
        }
        Node tmpNode = x;
        while (tmpNode != null) {
            System.out.print(tmpNode.data + " -> ");
            tmpNode = tmpNode.next;
        }
    }
    public static void main(String[] args)
    {
        Node n1= new Node(5);
        Node n2= new Node(6);
        Node n3= new Node(2);
        Node n4= new Node(8);
        Node n5= new Node(3);
        Node n6= new Node(90);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        
        n1=insertionSortList(n1);
        print(n1);
    }
}
