package linkedList.hard;


/**
 * 链表按照k个分组，并将每个分组反转
 */
public class KNodeReverse {

    /**
     * 这个实现是把所有的内容都按照k个节点分组，然后每个分组中都进行反转，最后不够k个节点的也放到一个分组中，然后进行反转
     * @param head
     * @param k
     * @return
     */
    public ListNode doKNodeReverse(ListNode head,int k){
        ListNode newHead,preHead,preTail,curHead,curTail,tmpHead;

        newHead = new ListNode();
        preHead = preTail = curHead = curTail = newHead;
        int count = 1;
        while(head != null){

            tmpHead = head.next;
            if(count % k == 1){
                preHead = curHead;
                preTail = curTail;
                curHead = head;
                curTail = head;
                preTail.next = head;
                head.next = null;
            }else{
                preTail.next = head;
                head.next = curHead;
                curHead= head;
            }

            count++;
            head = tmpHead;
        }
        return newHead.next;
    }





    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    /**
     * 这个实现是把所有的内容都按照k个节点分组，然后每个分组中都进行反转
     * 最后不足k个的节点，不进行反转
     * @param head
     * @param k
     * @return
     */
    public ListNode doKNodeReverse2(ListNode head,int k){

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode end = dummy;
        ListNode start;
        ListNode pre = dummy;

        while(end != null){

            for(int i = 0;i < k && end != null;i++){
                end = end.next;
            }

            if(end == null){
                break;
            }
            ListNode tmpNext = end.next;

            start = pre.next;
            end.next = null;
            ListNode newStart = reverse1(start);
            start.next = tmpNext;
            pre.next = newStart;
            pre = start;
            end = start;

        }

        return dummy.next;

    }

    public ListNode reverse1(ListNode head){
        ListNode pre = null;

        ListNode curr = head;//这个地方重新使用了一个变量来遍历链表，这样能保证head这个指向的节点一直不会改变，经过反转后，head节点为反转后的最后一个节点
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;


    }



    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        KNodeReverse kNodeReverse = new KNodeReverse();
        ListNode newHead = kNodeReverse.doKNodeReverse(head,2);

        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
