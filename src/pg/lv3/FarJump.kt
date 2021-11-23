package pg.lv3

class FarJump {
    fun solution(n: Int): Long {
        if (n == 1) return 1
        if (n == 2) return 2

        val arr = LongArray(n + 1) { 0 }
        arr[1] = 1
        arr[2] = 2

        for (i in 3..n) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567L
        }

        return arr[n] % 1234567L
    }
}