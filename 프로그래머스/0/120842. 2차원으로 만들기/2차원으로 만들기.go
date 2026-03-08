func solution(num_list []int, n int) [][]int {
    var result [][]int
    inner := []int{}
    
    idx := 0
    for idx < len(num_list) {
        inner = append(inner, num_list[idx])
        
        if len(inner) == n {
            result = append(result, inner)
            inner = []int{}
        }
        idx++
    }
    return result
}