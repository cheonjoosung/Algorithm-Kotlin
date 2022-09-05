package pg.lv2


fun solution(numbers: LongArray): LongArray {
    val answer = LongArray(numbers.size)

    for (i in numbers.indices) {
        var binaryString = java.lang.Long.toBinaryString(numbers[i])

        if (numbers[i] % 2 == 0L) {
            answer[i] = numbers[i] + 1
        } else {
            val lastIdx = binaryString.lastIndexOf("0")
            val firstIdx = binaryString.indexOf("1", lastIdx)

            if (lastIdx == -1) {

                numbers[i] += 1L
                binaryString = java.lang.Long.toBinaryString(numbers[i])
                binaryString = binaryString.substring(0, 2) +
                        binaryString.substring(2, binaryString.length).replace("0", "1")
            } else {
                binaryString = binaryString.substring(0, lastIdx) + "1" +
                        binaryString.substring(lastIdx + 1, firstIdx) + "0" +
                        binaryString.substring(firstIdx + 1, binaryString.length)
            }

            answer[i] = binaryString.toLong(2)
        }
    }

    return answer
}
