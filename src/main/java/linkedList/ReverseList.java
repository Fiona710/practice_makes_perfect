package linkedList;

public class ReverseList {

    public ListNode reverseList(ListNode head){

        ListNode  newHead = new ListNode();
        ListNode tmp = null;

        while(head !=  null){
            tmp = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = tmp;

        }

        return newHead.next;
    }
}
