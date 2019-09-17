package leet0109;

import java.util.*;

public class Solution0109 {

    private List<Integer> values = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {
        //将链表转化为数组
        listToValues(head);

        //通过递归，构造BST
        TreeNode root = convertListToBST(0, values.size()-1);
        return root;
    }

    private void listToValues(ListNode head) {
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
    }

    private TreeNode convertListToBST(int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(values.get(mid));

        if (left == right)
            return node;

        //构造左右子树
        node.left = convertListToBST(left, mid - 1);
        node.right = convertListToBST(mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] str = line.trim().split(" ");

        ListNode listNode = new ListNode(Integer.parseInt(str[0]));
        final ListNode head = listNode;
        for (int i = 1; i < str.length; i++) {
            listNode.next = new ListNode(Integer.parseInt(str[i]));
            listNode = listNode.next;
        }

        Solution0109 solution = new Solution0109();
        TreeNode treeNode = solution.sortedListToBST(head);
        solution.printBST(treeNode);
    }

    private void printBST(TreeNode root) {
        levelOrderTraversal(root);
    }

    /**
     * 广度优先遍历二叉树
     *
     * @param root
     */
    private void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return ;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        System.out.print("[");
        while (!deque.isEmpty()) {
            TreeNode node = deque.remove();
            System.out.print(node.val + " ");
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }
        System.out.println("]");
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
