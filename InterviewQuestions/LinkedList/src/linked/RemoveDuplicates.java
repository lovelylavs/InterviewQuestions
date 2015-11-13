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
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates 
{
    
    public static void removeDuplicates(MyList list) {
        Map<Integer, Boolean> buffer = new HashMap<>();
        Node curr = list.getHead();
        
        Node next;
        while (curr.getNext() != null) {
            next = curr.getNext();
            if(buffer.get(next.getData()) != null) {
                // already seen it, so delete
                curr.setNext(next.getNext());
            } else {
                buffer.put(next.getData(), true);
                curr = curr.getNext();
            }
        }
    }

    // without a temporary buffer O(n^2), another option is to sort the list but that is no allowed according to the
    // question
    public static void removeDuplicates2(MyList list) {
        Node curr = list.getHead().getNext();
        if(curr == null || curr.getNext() == null) {
            return; // 0 or 1 nodes in the list so no duplicates
        }
        Node curr2;
        Node prev;
        while(curr != null) {
            curr2 = curr.getNext();
            prev = curr;
            while(curr2 != null) {
                // check and see if curr and curr2 values are the same, if they are then delete curr2
                if(curr.getData() == curr2.getData()) {
                    prev.setNext(curr2.getNext());
                }
                prev = curr2;
                curr2 = curr2.getNext();
            }
            curr = curr.getNext();
        }
    }

    public static void main(String[] args) {
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
        RemoveDuplicates.removeDuplicates(list);
        System.out.println("After duplicates removed");
        list.print();

        list = new MyList();
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
        RemoveDuplicates.removeDuplicates2(list);
        System.out.println("After duplicates removed");
        list.print();
}
}
