package pg.lv1

class TwoChoiceSum {
    private fun solution(numbers: IntArray): IntArray {
        var answer: MutableList<Int> = mutableListOf()

        for( i in 0 until numbers.size-1){
            for( j in i+1 until numbers.size){
                answer.add(numbers[i] + numbers[j])
            }
        }

        answer = answer.sorted().distinct().toMutableList()
        return answer.toIntArray()

    }
}