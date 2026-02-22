func solution(num_list []int) []int {
    reversed := make([]int, len(num_list))
    
    for i, num := range num_list {
        reversed[len(num_list)-i-1] = num
    }
    return reversed
}