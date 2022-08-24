package linkedList;

/**
 * @Description 删除链表的倒数第 N个节点.
 * @Author Phil
 * @CreateTime 2022/6/8
 **/

public class RemoveNthFromEnd {

    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 设置虚拟头
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 创建快慢指针，两个指针初始均指向dummy
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 遍历fast指针，知道遇到n
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }

        // slow节点的上一节点，到时这个节点会直接指向slow的下一节点
        ListNode prev = new ListNode();
        while (fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        // 跳过slow
        prev.next = slow.next;
        return dummy.next;
    }
}
