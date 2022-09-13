package linkedList;

/**
 * @Description 删除链表的倒数第 N个节点.
 * @Author Phil
 * @CreateTime 2022/6/8
 **/

public class RemoveNthFromEnd {

    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // fast移动n+1
        while (n-- > 0 && fast != null) fast = fast.next;
        fast = fast.next; //让slow知道删除谁

        // fast、slow同时移动
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
