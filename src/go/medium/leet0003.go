package medium

import "strings"

/**
* 使用滑动窗口实现
 */
func lengthOfLongestSubstring(s string) int {
	//if len(s) <= 0 {
	//	return -1
	//}
	//
	////记录每个字母出现的次数，下标为字母对应的ascii
	//var pChar = [256]int{0}
	////记录每个字母出现的位置，下标为字母对应的ascii
	//var index = [256]int{0}
	//max, l := 0, 0
	//
	//for i, v := range s {
	//	//跟新当前字母v的出现的次数
	//	pChar[v]++
	//	if pChar[v] > 1 {
	//		//字符出现次数大于1，则移动窗口的左边界
	//		if index[v]+1 > l {
	//			l = index[v] + 1
	//		}
	//	}
	//	//记录当前字母v的索引
	//	index[v] = i
	//
	//	//更新不重复子串的长度
	//	if max < i-l+1 {
	//		max = i - l + 1
	//	}
	//}
	//return max
	subLength, start := 0, 0
	for key := 0; key < len(s); key++ {
		isExist := strings.Index(s[start:key], string(s[key]))
		//不存在字符s[key]
		if isExist == -1 {
			if subLength < key-start+1 {
				subLength = key - start + 1
			}
		} else {
			//包含字符s[key], isExist返回字符key出现的索引
			start = isExist + start + 1
		}
	}
	return subLength
}
