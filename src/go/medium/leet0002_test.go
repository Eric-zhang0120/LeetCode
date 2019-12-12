package medium

import (
	"fmt"
	"strconv"
	"strings"
	"testing"
)

func buildList(s string) (root *ListNode) {
	var temp *ListNode
	strs := strings.Split(s, ",")
	for _, v := range strs {
		t, e := strconv.Atoi(v)
		if e != nil {
			fmt.Errorf("Atoi出错")
			return
		}

		if root == nil {
			root = &ListNode{Val: t}
			temp = root
		} else {
			temp.Next = &ListNode{Val: t}
			temp = temp.Next
		}
	}
	return
}

func printList(list *ListNode) {
	s := make([]int, 0)
	for list != nil {
		s = append(s, list.Val)
		list = list.Next
	}
	fmt.Println(s)
}

func TestAddTwoNumbers(t *testing.T) {

	s1 := "5"
	s2 := "5"

	l1 := buildList(s1)
	l2 := buildList(s2)
	l := addTwoNumbers(l1, l2)
	printList(l)
}
