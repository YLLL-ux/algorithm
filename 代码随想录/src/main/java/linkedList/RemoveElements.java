package linkedList;

/**
 * @Description 移除链表元素.
 * 题意：删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * @Author Phil
 * @CreateTime 2022/5/25
 **/

public class RemoveElements {


    /**
     * 创建虚拟头节点
     */
    private ListNode removeElements(ListNode head, int val) {
        // 空链表
        if (head == null) return null;

        // 虚拟节点
        ListNode dummy = new ListNode(-1, head);
        // 前节点
        ListNode pre = dummy;
        // 当前节点
        ListNode cur = head;
        // 链表不为空
        while (cur != null) {
            if (val == cur.val) { // 删除头节点
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        // 链表为空
        return dummy.next;
    }
}
