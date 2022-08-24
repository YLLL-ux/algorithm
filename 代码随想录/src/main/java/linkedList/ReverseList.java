package linkedList;

/**
 * @Description 翻转列表
 * <p>
 * 题意：反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Author Phil
 * @CreateTime 2022/6/6
 **/

public class ReverseList {
    public static void main(String[] args) {

    }

    // 双指针
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
