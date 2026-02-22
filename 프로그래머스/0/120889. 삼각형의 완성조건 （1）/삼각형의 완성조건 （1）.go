import "sort"

func solution(sides []int) int {
    sort.Ints(sides)
    
    if sides[0]+sides[1] > sides[2] {
        return 1
    }
    return 2
}