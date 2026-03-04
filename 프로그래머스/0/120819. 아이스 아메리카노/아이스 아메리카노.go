
func solution(money int) []int {
    coffee := money / 5500
    change := money % 5500
    return []int{ coffee, change }
}