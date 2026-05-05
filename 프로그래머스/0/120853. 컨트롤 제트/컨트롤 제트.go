import (
    "strconv"
    "strings"
)

func solution(s string) int {
    answer := 0
    arr := strings.Fields(s)
    
    var prev int
    for _, str := range arr {
        num, err := strconv.Atoi(str)
        
        if err == nil {
            prev = num
            answer += num
        } else {
            if str == "Z" {
                answer -= prev
            }
        }
    }
    return answer
}