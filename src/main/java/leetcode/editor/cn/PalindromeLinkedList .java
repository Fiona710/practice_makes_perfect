//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 2261 👎 0

 
package leetcode.editor.cn;
public class PalindromeLinkedList{
    public static void main(String[] args) {
         Solution solution = new PalindromeLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

        int len = 0;
        ListNode countNode = head;
        while(countNode != null){
            len++;
            countNode = countNode.next;
        }

        int step = len % 2 == 0 ? len / 2 : len /2 + 1;

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        for(int i = 0;i < step;i++){
            pre = fast;
            fast = fast.next;
        }

        pre.next = null;

        fast = revertList(fast);

        for(int i = 1;i <= len /2;i++){
            if(head.val == fast.val){
                head = head.next;
                fast = fast.next;
            }else{
                return false;
            }
        }
        return true;
    }

    public ListNode revertList(ListNode head){

        ListNode f = head;
        ListNode s = null;
        ListNode tmp = null;

        while(f !=null){
            tmp = f.next;
            f.next = s;
            s = f;
            f = tmp;
        }

        return s;


    }

    //奇数个  1，2，3，4，5    （n+1）/2+1  step = 3
    //偶数个 1，2，3，4      n/2+1
}
//leetcode submit region end(Prohibit modification and deletion)

}