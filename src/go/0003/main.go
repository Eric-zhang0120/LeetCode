package main

func lengthOfLongestSubstring(s string) int {
	var (
		ans  int
		left int
	)
	m := make(map[rune]int)
	for i, v := range s {
		// 移动左指针到max(m[v]+1, left)处 abca, left = 1
		if _, ok := m[v]; ok {
			left = max(left, m[v]+1)
		}
		m[v] = i
		ans = max(ans, i-left+1)
	}
	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
