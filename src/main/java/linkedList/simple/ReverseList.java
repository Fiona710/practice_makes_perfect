package linkedList.simple;

public class ReverseList {

    /**
     * 通过临时变量，来处理链表反转问题
     * 1. 通过临时变量，保存当前节点的下一个节点
     * 2. 将当前节点的下一个节点指向新链表的头节点
     * 3. 将新链表的头节点指向当前节点
     * 4. 将当前节点指向临时变量
     * 5. 重复以上步骤，直到当前节点为空
     * 6. 返回新链表的头节点
     *
     * @param head
     * @return
     */
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
