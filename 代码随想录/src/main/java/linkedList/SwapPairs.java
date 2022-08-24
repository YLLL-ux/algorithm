package linkedList;

/**
 * @Description 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 例1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 例2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 例3：
 * 输入：head = [1]
 * 输出：[1]
 * @Author Phil
 * @CreateTime 2022/6/6
 **/

public class SwapPairs {

    // 虚拟头节点
    private ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next; // 缓存下一个head
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }
}
