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

// 개선
func solution2(num_list []int, n int) [][]int {
    var result [][]int
    
    // n개씩 건너뛰면서
    for i:=0; i<len(num_list); i+=n {
        // 슬라이싱으로 필요한 만큼 한번에 잘라넣기
        result = append(result, num_list[i:i+n])
    }
    return result
}
