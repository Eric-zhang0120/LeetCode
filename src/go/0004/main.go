package main

import (
	"fmt"
	"sort"
)

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	l1, l2 := len(nums1), len(nums2)
	nums := make([]int, l1+l2, l1+l2)
	for i := 0; i < l1; i++ {
		nums[i] = nums1[i]
	}
	for i := l1; i < l1+l2; i++ {
		nums[i] = nums2[i-l1]
	}
	sort.Ints(nums)
	fmt.Println("nums: ", nums)

	l := len(nums)
	if (l & 1) == 0 {
		fmt.Sprintf("nums[l/2]: %d, nums[l/2-1]: %d", nums[l/2], nums[l/2-1])
		return float64(nums[l/2]+nums[l/2-1]) * 0.5
	} else {
		return float64(nums[l/2])
	}
}

func findMedianSortedArrays2(nums1 []int, nums2 []int) float64 {
	l1, l2 := len(nums1), len(nums2)
	// id1, id2分别表示数组nums1和nums2中元素的位置
	id1, id2 := 0, 0
	// l表示合并后数组的长度
	l := l1 + l2
	// prev和curr分别表示循环的上一次的值和当前值
	prev, curr := 0, 0
	for i := 0; i <= l/2; i++ {
		prev = curr
		// id1 右移动的条件为：id1没有到达数组nums1右边界且nums1[id1] < nums2[id2]
		// 或者id1没有到达数组nums1右边界，idx2到达nums2的有边界
		if id1 < l1 && (nums1[id1] < nums2[id2] || id2 >= l2) {
			curr = nums1[id1]
			id1++
		} else {
			curr = nums2[id2]
			id2++
		}
	}
	if (l & 1) == 0 {
		return float64(prev+curr) / 2.0
	} else {
		return float64(curr)
	}
}

func findMedianSortedArrays3(nums1 []int, nums2 []int) float64 {
	m := len(nums1)
	n := len(nums2)
	left := (m + n + 1) / 2
	right := (m + n + 2) / 2

	ans1 := getKth(nums1, 0, m-1, nums2, 0, n-1, left)
	//return float64(ans1)
	ans2 := getKth(nums1, 0, m-1, nums2, 0, n-1, right)
	return 0.5 * float64(ans1+ans2)
	//return 0.5 * float64(getKth(nums1, 0, m-1, nums2, 0, n-1, left)+getKth(nums1, 0, m-1, nums2, 0, n-1, right))
}

func getKth(nums1 []int, start1 int, end1 int, nums2 []int, start2 int, end2 int, k int) int {
	len1, len2 := end1-start1+1, end2-start2+1
	// 始终保持len1 < len2
	if len1 > len2 {
		return getKth(nums2, start2, end2, nums1, start1, end1, k)
	}
	fmt.Println("start1: ", start1)
	fmt.Println("start2: ", start2)
	//递归退出的条件:len1 == 0 or k == 1
	if len1 == 0 {
		return nums2[start2+k-1]
	}
	if k == 1 {
		return intMin(nums1[start1], nums2[start2])
	}

	i := start1 + intMin(k/2, len1) - 1
	j := start2 + intMin(k/2, len2) - 1

	if nums1[i] < nums2[j] {
		return getKth(nums1, i+1, end1, nums2, start2, end2, k-(i-start1+1))
	} else {
		return getKth(nums1, start1, end1, nums2, j+1, end2, k-(j-start2+1))
	}
}

func intMin(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func main() {
	nums1 := []int{1, 2}
	nums2 := []int{3, 4}
	ans := findMedianSortedArrays(nums1, nums2)
	fmt.Print(ans)
	//nums := make([]int, len(nums1)+len(nums2), len(nums1)+len(nums2))
	//copy(nums, nums1)
	//copy(nums, nums2)
	//fmt.Println(nums)
}
