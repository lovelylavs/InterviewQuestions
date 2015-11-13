/*
 Implement an algorithm to delete a node in the middle of a singly linked list,
given only access to that node.
EXAMPLE
Input: the node c from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a- >b- >d->e
 */

package linked;

/**
 *
 * @author Lavanya
 */
public class DeleteNodeMiddle 
{
    public static boolean deleteMiddle(Node node)
    {
        if(node==null || node.next==null)
        {
            return false;
        }
        Node next = node.next; //next node
        node.data = next.data; //edit current node to pint to next node data
        node.next = next.next;
        return true;
    }
    public static void deleteNode(Node node)
    {
         while(node != null && node.next != null)
        {
            Node next = node.next;
            node.data = next.data;
            
            if(node.next == null)
            {
                node.next = null;
            }
            node = node.next;
        }
    }
    public static void main(String[] args)
    {
        MyList list = new MyList();
        list.append(0);
        Node n = list.add(1);
        deleteNode(n);
        
       /* Node n = list.add(9);
         list.append(15);
       
        deleteNode(n);
        list.append(6);
        list.append(6);
        list.print();
        System.out.println("Deleting the middle element");
        DeleteNodeMiddle.deleteMiddle(n);
        list.print();*/
    }
}
