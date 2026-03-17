import (
    "unicode"
    "strconv"
)

func solution(my_string string) int {
    var answer int
    digitStr := ""
    
    for _, r := range my_string {
        if unicode.IsDigit(r) {
            digitStr += string(r)
        } else {
            if digitStr != "" {
                num, _ := strconv.Atoi(digitStr)
                answer += num
                digitStr = ""
            }
        }
    }
    
    if digitStr != "" {
        num, _ := strconv.Atoi(digitStr)
        answer += num
    }
    
    return answer
}