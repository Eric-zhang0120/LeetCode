package medium

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1, l2 *ListNode) *ListNode {
	var root, tmpNode *ListNode
	var temp, bit int
	//遍历l1和l2的值
	for l1 != nil || l2 != nil {
		if l1 != nil && l2 != nil {
			//l1, l2该位有值时,和为l1+l2+bit
			temp = l1.Val + l2.Val + bit
			l1 = l1.Next
			l2 = l2.Next
		} else if l1 != nil {
			//l1该位有值时,和为l1+bit
			temp = l1.Val + bit
			l1 = l1.Next
		} else {
			//l2该位有值时,和为l1+bit
			temp = l2.Val + bit
			l2 = l2.Next
		}

		//计算进位
		bit = temp / 10
		temp %= 10
		//构建结果
		if root == nil {
			root = &ListNode{Val: temp}
			tmpNode = root
		} else {
			tmpNode.Next = &ListNode{Val: temp}
			tmpNode = tmpNode.Next
		}
	}

	//最后还应该判断是否l1和l2的最高位是否有进位
	if bit != 0 {
		tmpNode.Next = &ListNode{Val: bit}
	}
	return root
}
