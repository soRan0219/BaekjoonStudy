func solution(my_string string) string {
    var result []rune
    visited := make(map[rune]bool)
    
    for _, char := range my_string {
        if !visited[char] {
            visited[char] = true
            result = append(result, char)
        }
    }
    return string(result)
}