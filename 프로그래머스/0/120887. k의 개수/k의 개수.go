func solution(i int, j int, k int) int {
    answer := 0

	for i <= j {
		numMap := make(map[int]int)

		var num = i
		for num > 0 {
			digit := num % 10
			numMap[digit]++
			num /= 10
		}

		answer += numMap[k]
		i++
	}
	return answer
}