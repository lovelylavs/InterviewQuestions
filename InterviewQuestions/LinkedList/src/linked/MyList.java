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
public class MyList 
{
    private Node head = null;
    
    public void append(int val) //appending list at the tail
    {
        Node lastNode = getLastNode();
        if (lastNode == null) //if last node was null imples that linkedlist size was 0
        {
            head = new Node(val);
        } else 
        {
            lastNode.next = new Node(val); //add a node to the tail which sets  
                                           //data to val and next to null
        }
    }

    //Add node to linked list
    public Node add(int val) { //method returns the node added to tail of linked list
        Node lastNode = getLastNode();
        if (lastNode == null) {
            head = new Node(val);
        } else {
            lastNode.next = new Node(val);
        }
        return head;
    }
    
    public void delete(int val) {
        if(head == null){
            return;
        }

        Node prevNode = null;
        Node currNode = head; 
        //to delete we find the previous node and set prev to current node
        while (currNode != null && currNode.data != val) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        if(prevNode == null){
            head = head.next;
            return;
        }
        if (currNode == null) {
            System.out.println("A node with that value does not exist.");
            return;
        }
        prevNode.next = currNode.next;
    }

    public void print() {
        System.out.println("");
        if(head == null){
            System.out.print("EMPTY");
            return;
        }
        Node tmpNode = head;
        while (tmpNode != null) {
            System.out.print(tmpNode.data + " -> ");
            tmpNode = tmpNode.next;
        }
    }
    
    public int findMiddle()
    {
        Node n1,n2;
        n1=n2=head;
        
        int i=0;
        while(n1.next != null)
        {
            if(i==0)
            {
                n1= n1.next;
                i=1;
            }
            else if(i==1)
            {
                n1=n1.next;
                n2=n2.next;
                i=0;
            }
                
        }
        return n2.data;
    }
    
    public int findmid()
    {
        Node current = head, mid = head;
        int length=0;
        while(current.next != null)
        {
            length++;
            
            if(length%2==0)
            {
                mid = mid.next;
            }
            current=current.next;
        }
        
        if(length%2==1)
            mid=mid.next;
        
        return mid.data;
    }
    public Node getHead()
    {
        if (head == null) {
            return null;
        }
        else
            return head;
    }
    public Node getLastNode() {
        if (head == null) {
            return null;
        }
        Node tmpNode = head;
        while (tmpNode.next != null) {//traverse until you find the last node
            tmpNode = tmpNode.next;   //traverse using the next pointer
        }
        return tmpNode; //return the last node
    }
    
    //method to add node at beginning of linked list
    public void insertBeginning(int val)
    {                
        if (head == null) { //if head was null list size 0
            head = new Node(val);
        } else {
            Node tmpNode = new Node(val);//new node
            tmpNode.next = head; //add head as next of new node
            head = tmpNode;     //make new node as head node
        }
    }

    //insert element after a value
    public void insertMiddle(int val,int newVal)
    {
        Node tmpNode = head;
        while (tmpNode.next != null ) {//traverse until you find the last node
            if(tmpNode.data == val)
            {
                Node newNode = new Node(newVal);
                newNode.next = tmpNode.next;
                tmpNode.next = newNode;
                break;
            
            }
            else
            {
            tmpNode = tmpNode.next;   //traverse using the next pointer
            }
        }
    }
    
    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.print();
        myList.append(35);
        myList.append(33);
        myList.print();
        myList.delete(33);
        myList.delete(35);
        myList.delete(35);
        myList.print();
        myList.append(34);
        myList.append(35);
        myList.insertBeginning(11);//insert at beginning
        myList.print();
        myList.insertMiddle(34, 23);
        myList.print();
        myList.insertMiddle(23, 100);
        System.out.println("\n Middle mode" + myList.findMiddle());
        System.out.println("\n Middle mode" + myList.findmid());
        myList.print();
    }
}
