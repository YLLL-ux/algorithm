package linkedList.Design_ListNode_LinkedList;


/**
 * @Description 设计链表
 * 题意：
 * 在链表类中实现这些功能：
 * 1、get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * 2、addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * 3、addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * 4、addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
 * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 * 如果 index 大于链表长度，则不会插入节点。
 * 如果index小于0，则在头部插入节点。
 * 5、deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * 需要五个接口：
 * 获取链表第index个节点的数值
 * 在链表的最前面插入一个节点
 * 在链表的最后面插入一个节点
 * 在链表第index个节点前面插入一个节点
 * 删除链表的第index个节点
 * @Author Phil
 * @CreateTime 2022/5/25
 **/

public class SingleListNode {

    int size; // 存储链表元素的个数
    ListNode head; // 虚拟头节点

    // 初始化链表
    private SingleListNode() {
        size = 0;
        head = new ListNode(0);
    }

    // 获取index个节点的值
    private int get(int index) {
        // 索引是否有效
        if (index < 0 || index >= size) return -1;

        // 包含虚拟头节点的查找，所以查找index+1
        // 当前指针指向头节点
        ListNode current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // 在链表最前面添加元素
    private void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表的最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 大于链表的长度，则返回空
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    private void addAtIndex(int index, int val) {
        if (index > size) return;

        if (index < 0) index = 0;

        size++;
        // 找到要插入节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }

        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

}
