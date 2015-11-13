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
public class PartitionLinkedL 
{
    public Node partitionList(Node head,int val)
    {
        Node LessStart = null;//start of less node
        Node LessEnd = null; //end of less node
        Node GreatStart = null; //start of greater
        Node GreatEnd = null; //end of greater
        

        while(head != null)
        {
            Node next = head.next;
            head.next = null;
            if(head.data < val)
            {
                
                if(LessStart==null)
                {
                    LessStart = head;
                    LessEnd = LessStart;
                }
                else
                {
                    LessEnd.next = head;
                    LessEnd = head;
                }
            }
            else
            {
                if(GreatStart==null)
                {
                    GreatStart = head;
                    GreatEnd = GreatStart;
                }
                else
                {
                    GreatEnd.next = head;
                    GreatEnd = head;
                }
            }
            head = next;
        }
        
        
        if(LessStart == null)
        {
            return GreatStart;
        }
        
        LessEnd.next = GreatStart;
        return LessStart;
    }
    public static void main(String[] args)
    {
        MyList list = new MyList();
        list.append(3);
        list.append(29);
        list.append(3);
        list.append(12);
        list.append(29);
        list.append(29);
        list.append(23);
        list.append(34);
        list.append(3);

        list.print();
        PartitionLinkedL part = new PartitionLinkedL();
        Node newNode = part.partitionList(list.getHead(),25);
        
        if(newNode == null){
            System.out.print("EMPTY");
            return;
        }
        System.out.println("New llist");
        Node tmpNode = newNode;
        while (tmpNode != null) {
            System.out.print(tmpNode.data + " -> ");
            tmpNode = tmpNode.next;
        }

        
    }
}
