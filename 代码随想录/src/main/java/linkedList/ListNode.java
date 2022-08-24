package linkedList;

/**
 * @Description 链表的定义
 * 链表时一个包含零个或多个元素的数据结构。每个元素都包含一个值和到另一个元素的链接。根据链接数的不同，可以分为单链表，双链表和多重链表。
 * <p>
 * 单链表是最简单的一种，它提供了在常数时间内的 addAtHead 操作和在线性时间内的 addAtTail 的操作。
 * 双链表是最常用的一种，因为它提供了在常数时间内的 addAtHead 和 addAtTail 操作，并且优化的插入和删除。
 * <p>
 * 双链表在 Java 中的实现为 LinkedList，在 Python 中为 list。这些结构都比较常用，有两个要点：
 * <p>
 * ** 哨兵节点：**
 *      哨兵节点在树和链表中被广泛用作伪头、伪尾等，通常不保存任何数据。
 *      我们将使用伪头来简化我们简化插入和删除。在接下来的两种方法中应用此方法。
 * ** 双链表的双向搜索：**
 *      我们可以从头部或尾部进行搜索
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
