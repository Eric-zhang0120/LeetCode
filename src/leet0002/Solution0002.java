package leet0002;

import java.util.Scanner;

public class Solution0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode tmpNode = null;
        int tmp = 0, bit = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                tmp = l1.val + l2.val+bit;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                tmp = bit + l2.val;
                l2 = l2.next;
            } else {
                tmp = bit + l1.val;
                l1 = l1.next;
            }

            bit = tmp / 10;
            tmp %= 10;

            if (root == null) {
                root = tmpNode = new ListNode(tmp);
            } else {
                tmpNode.next = new ListNode(tmp);
                tmpNode = tmpNode.next;
            }
        }
        return root;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

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
