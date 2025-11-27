package util;

/**
 * 链表节点类
 * 用于单向链表的节点定义
 * 
 * @author practice_makes_perfect
 */
public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {}
    
    public ListNode(int val) { 
        this.val = val; 
    }
    
    public ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
    
    @Override
    public String toString() {
        return "ListNode{val=" + val + "}";
    }
}

