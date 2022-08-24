package linkedList;

/**
 * @Description 环形链表II
 * @Author Phil
 * @CreateTime 2022/6/10
 **/

public class DetectCycleII {

    // 双指针
    public ListNode detectCycle(ListNode head) {
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            // slow走一步，fast走两步
            slow = slow.next;
            fast = fast.next.next;
            // 判断有环
            if (slow == fast) {
                // 找入口
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针个走一次，直到相遇，相遇点就是入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
