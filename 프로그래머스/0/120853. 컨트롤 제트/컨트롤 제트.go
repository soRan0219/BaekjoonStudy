import (
    "strconv"
    "strings"
)

func solution(s string) int {
    answer := 0
    arr := strings.Fields(s)
    var stack []int
    
    for _, str := range arr {
        if str != "Z" {
            if num, err := strconv.Atoi(str); err == nil {
                answer += num
                stack = append(stack, num)
            }
        } else {
            if len(stack) > 0 {
                lastIdx := len(stack) - 1
                answer -= stack[lastIdx]
                stack = stack[:lastIdx]
            }
        }
    }
    return answer
}
