package linkedList.Design_ListNode_LinkedList;

/**
 * @Description 链表的定义
 * @Author Phil
 * @CreateTime 2022/5/24
 **/

public class ListNode {

    int val; // 节点值
    ListNode next; // 下一个节点

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
