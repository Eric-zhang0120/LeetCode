package medium.leet0430;

import java.util.Stack;

public class Solution0430 {
    /**
     * 展开链表，通过堆栈实现
     * 利用栈后进先出的特点，每次将next先添加到栈中，
     * 后将child添加到栈中，再出栈
     *
     * @param head
     * @return 展开链表的头节点
     */
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node pre = null;
        while (!stack.empty()) {
            Node cur = stack.pop();
            if (cur.next != null) {
                stack.push(cur.next);
            }
            if (cur.child != null) {
                stack.push(cur.child);
                cur.child = null;
            }
            if (pre != null) {
                pre.next = cur;
                cur.prev = pre;
            }
            pre = cur;
        }
        return head;
    }

    class Node {
        private int val;
        private Node prev;
        private Node next;
        private Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
