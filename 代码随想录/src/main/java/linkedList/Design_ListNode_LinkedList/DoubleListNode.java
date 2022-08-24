package linkedList.Design_ListNode_LinkedList;

/**
 * @Description 双链表
 * @Author Phil
 * @CreateTime 2022/6/2
 **/

public class DoubleListNode {

    class ListNode {
        int val;
        ListNode prev, next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private int size;
    ListNode head, tail;

    public DoubleListNode() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    // 获取index索引处的数值
    public int get(int index) {
        // 索引无效
        if (index < 0 || index > size) return -1;
        // 指定当前节点位置
        ListNode current = head;
        // 通过index、size-index，判断从哪边搜索更快
        if (index + 1 < size - index) { // 从头获取
            for (int i = 0; i < index + 1; ++i) current = current.next;
        } else {
            current = tail;
            for (int i = 0; i < size - index; ++i) current = current.prev;
        }
        return current.val;
    }

    // addAtHead
    private void addAtHead(int val) {
        ListNode pred = head, succ = head.next; // 第一个节点和此节点的下一个点
        ++size; // 扩展一个空间
        ListNode toAdd = new ListNode(val); // 要添加的数据
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    // addAtTail
    private void addAtTail(int val) {
        ListNode succ = tail, pred = tail.prev; // 最后一个节点和此节点的上一个点
        ++size; // 扩展一个空间
        ListNode toAdd = new ListNode(val); // 要添加的数据
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    // 添加在index处
    private void addAtIndex(int index, int val) {
        if (index < 0) index = 0;
        if (index > size) return;

        ListNode pred, succ;
        if (index < size - index) { // 从头部开始找到要插入的位置
            pred = head;
            for (int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next;
        } else { // 从尾部开始找到要插入的位置
            succ = tail;
            for (int i = 0; i < size - index; ++i) succ = succ.prev;
            pred = succ.prev;
        }

        // 插入节点
        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    // 删除index处的值
    private void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; ++i) succ = succ.prev;
            pred = succ.prev;
        }

        // 删除节点
        --size;
        pred.next = succ;
        succ.prev = pred;
    }
}


