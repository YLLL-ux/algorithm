package linkedList;

/**
 * @Description 链表相交
 * @Author Phil
 * @CreateTime 2022/6/9
 **/

public class GetIntersectionNode {

    // 双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 两个链表是否有效
        if (headA == null || headB == null) return null;

        // 双指针不同指向
        ListNode curA = headA;
        ListNode curB = headB;
        // 两个链表的长度
        int lenA = 0, lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            // swap (lenA,lenB)
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;
            // swap (curA,curB)
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }

        // 计算长度差
        int gap = lenA - lenB;
        // 将curA与curB转移到同一起点
        while (gap-- > 0) {
            curA = curA.next;
        }

        // 遍历curA与curB，遇到相同直接返回 （循环终止条件curA指向null）
        while (curA != null) {
            if (curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
