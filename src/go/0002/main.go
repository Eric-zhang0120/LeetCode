package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var (
		head *ListNode
		tail *ListNode
	)
	bit, temp := 0, 0
	for l1 != nil || l2 != nil {
		n1, n2 := 0, 0
		if l1 != nil {
			n1 = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			n2 = l2.Val
			l2 = l2.Next
		}
		bit, temp = (n1+n2+bit)/10, (n1+n2+bit)%10
		node := &ListNode{Val: temp}
		if head == nil {
			head = node
			tail = head
		} else {
			tail.Next = node
			tail = tail.Next
		}
	}
	// 循环完后需要判断是否存在进位
	if bit != 0 {
		tail.Next = &ListNode{Val: bit}
	}

	return head
}

func main() {
	nums1 := []int{2, 4, 3}
	nums2 := []int{5, 4, 6}

	var (
		l1Root *ListNode
		l2Root *ListNode
		l1Tail *ListNode
		l2Tail *ListNode
	)

	for _, v := range nums1 {
		if l1Root == nil {
			l1Root = &ListNode{Val: v}
			l1Tail = l1Root
		} else {
			l1Tail.Next = &ListNode{Val: v}
			l1Tail = l1Tail.Next
		}
	}

	for _, v := range nums2 {
		node := &ListNode{Val: v}
		if l2Root == nil {
			l2Root = node
			l2Tail = l2Root
		} else {
			l2Tail.Next = node
			l2Tail = l2Tail.Next
		}
	}

	head_sum := addTwoNumbers(l1Root, l2Root)
	for head_sum != nil {
		fmt.Print(head_sum.Val)
		head_sum = head_sum.Next
	}
}
