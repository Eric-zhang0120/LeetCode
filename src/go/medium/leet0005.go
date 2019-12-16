package medium

func longestPalindrome(s string) string {
	if len(s) < 1 {
		return s
	}

	start, end := 0, 0
	max_len := 0
	for i, _ := range s {
		len1 := expendAroundCenter(s, i, i)
		len2 := expendAroundCenter(s, i, i+1)

		if len1 > len2 {
			max_len = len1
		} else {
			max_len = len2
		}

		//计算回文子串在原串的索引
		if max_len > end-start {
			//这里len-1是为了避免i-len/2时前移了一个单位
			start = i - (max_len-1)/2
			end = i + max_len/2
		}
	}
	return s[start:end]
}

func expendAroundCenter(s string, left, right int) int {
	for left >= 0 && right < len(s) && s[left] == s[right] {
		left--
		right++
	}
	return right - left - 1
}
