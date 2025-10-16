package linkedList.simple;

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

    public static class ListNode {
          int val;
          ListNode next;
          public ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
