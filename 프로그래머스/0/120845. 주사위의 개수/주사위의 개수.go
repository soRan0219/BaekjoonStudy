func solution(box []int, n int) int {
    horizontal := box[0] / n
    vertical := box[1] / n
    height := box[2] / n
    return horizontal * vertical * height
}