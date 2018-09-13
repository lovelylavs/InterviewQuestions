public boolean isPalinDrome(){
        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next; // fast runs to end
            slow = slow.next; // slow becomes second head now
        }

        if( fast != null) // for odd list
            slow = slow.next;


        slow = reverse(slow); // reverse of halfway list
        fast = head; // start of list


        while(slow != null){
            if(fast.value != slow.value)
                return false;

            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next; // the next ptr
            head.next = prev; // to reverse head next should point to prev
            prev = head; // prev gets curr
            head = next;
        }
        return prev;
    }
