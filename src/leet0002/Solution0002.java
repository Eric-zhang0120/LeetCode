package leet0002;

import java.util.Scanner;

public class Solution0002 {
    /**
     * 链表数值相加
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 两数之和的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode tmpNode = null;
        int tmp = 0, bit = 0;

        //遍历链表l1和l2
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) { //l1和l2的该位都有数值(l1+l2+进位)
                tmp = l1.val + l2.val+bit;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {  //l1的该位没有值且l2的该位有值(0+l2+进位)
                tmp = bit + l2.val;
                l2 = l2.next;
            } else {                 //l2的该位没有值且l1的该位有值(l1+0+进位)
                tmp = bit + l1.val;
                l1 = l1.next;
            }
            //分离进位和该位的数值
            bit = tmp / 10;
            tmp %= 10;
            //创建链表
            if (root == null) {
                root = tmpNode = new ListNode(tmp);
            } else {
                tmpNode.next = new ListNode(tmp);
                tmpNode = tmpNode.next;
            }
        }
        //当l1和l2的最高位有进位时，需要加上进位
        if (bit != 0) {
            tmpNode.next = new ListNode(bit);
        }

        return root;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     * 创建单向链表
     *
     * @param str 字符串，以,分隔链表节点值
     * @return 链表的根节点
     */
    private static ListNode buildList(String str) {
        ListNode node = null, root = null;
        for (String s :str.split(",")) {
            if (root == null) {
                root = node= new ListNode(Integer.parseInt(s));
            } else {
                node.next = new ListNode(Integer.parseInt(s));
                node = node.next;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode l1 = buildList(in.nextLine());
        ListNode l2 = buildList(in.nextLine());

        ListNode listNode = new Solution0002().addTwoNumbers(l1, l2);
        System.out.print(listNode.val);
        listNode = listNode.next;
        while (listNode != null) {
            System.out.print(","+listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }
}
