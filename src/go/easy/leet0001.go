package easy

func solution0001(nums []int, target int) []int {
	if len(nums) < 2 {
		return nil
	}

	//使用map, key --> 加数, value --> 在nums中的索引
	var m = make(map[int]int)
	for i, v := range nums {
		temp := target - v
		if _, ok := m[temp]; ok {
			return []int{i, m[temp]}
		}
		m[temp] = v
	}
	//遍历完后没有找到相应的两数之和为target
	return nil
}
