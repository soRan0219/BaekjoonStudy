import "sort"

func solution(numbers []int) int {
    sort.Ints(numbers)
    last := len(numbers) - 1
    
    return numbers[last] * numbers[last-1]
}