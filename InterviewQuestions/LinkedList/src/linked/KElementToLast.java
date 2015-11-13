/*
 Implement an algorithm to find the kth to last element of a singly linked list.
 */

package linked;

/**
 *
 * @author Lavanya
 */
public class KElementToLast 
{
    public static int kLast(MyList list, int n)
    {
        Node next = list.getHead();

        int count = 1;
        //I am trying to travserse until i found the kth last
        while(count< n && next!= null)
        {
            next = next.getNext();
            count++;
        }
        if(next==null)
        {
            System.out.println("List is too small");
            return 0;
        }
        //Walk to the last node
        Node target = list.getHead();
        while(next != null)
        {
            target = target.getNext();
            next = next.getNext();
        }
        return target.getData();
        
    }
    
    
    public static void main(String[] args)
    {
        MyList list = new MyList();
        list.append(20); //8
        list.append(10); //7
        list.append(40); //6
        list.append(80); //5
        list.print();
        System.out.println("n=" + 3 + ": " + KElementToLast.kLast(list, 3));
        list.append(30); //4
        list.append(90); //3
        list.append(11); //2
        list.append(6); //1
        list.print();
        System.out.println("n=" + 5 + ": " + KElementToLast.kLast(list, 5));
        System.out.println("n=" + 6 + ": " + KElementToLast.kLast(list, 6));
        System.out.println("n=" + 2 + ": " + KElementToLast.kLast(list, 2));
    }
}
