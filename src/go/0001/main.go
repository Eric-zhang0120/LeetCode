package main

import (
	"errors"
	"fmt"
)

func TwoSum(nums []int, target int) (err error, ans []int) {
	m := make(map[int]int, len(nums))
	for i := 0; i < len(nums); i++ {
		temp := target - nums[i]
		if v, ok := m[temp]; ok {
			ans = []int{i, v}
			return
		}
		m[nums[i]] = i
	}
	err = errors.New("not such two numbers")
	return
}

func main() {
	nums := []int{1, 2, 3, 4, 5}
	target := 5
	err, idxs := TwoSum(nums, target)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("idx: ", idxs)
	}
}
