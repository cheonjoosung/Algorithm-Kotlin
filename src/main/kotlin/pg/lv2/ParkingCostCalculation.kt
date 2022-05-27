package pg.lv2

import java.util.*
import kotlin.collections.HashMap

class ParkingCostCalculation {

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        /**
         * 기본요금 + [(기본시간 - 주차시간) / 단위시간 * 단위요금]
         */
        val hm: HashMap<String, Int> = hashMapOf()
        val sm: SortedMap<String, Int> = sortedMapOf()

        for (record in records) {
            val token = record.split(" ")

            val time = token[0]
            val translatedTime = time.substring(0, 2).toInt() * 60 + time.substring(3, 5).toInt()
            val carNumber = token[1]
            val inOut = token[2]

            if (inOut == "IN") {
                hm[carNumber] = translatedTime
            } else {
                val inTime = hm[carNumber] ?: 0

                if (sm.containsKey(carNumber)) {
                    val based = sm[carNumber] ?: 0
                    sm[carNumber] = based + (translatedTime - inTime)
                } else {
                    sm[carNumber] = translatedTime - inTime
                }

                hm.remove(carNumber)
            }
        }

        // 남은 것들은 23:59분으로 계산
        for (carNumber in hm.keys) {
            val inTime = hm[carNumber] ?: 0

            if (sm.containsKey(carNumber)) {
                val based = sm[carNumber] ?: 0
                sm[carNumber] = based + (23*60+59 - inTime)
            } else {
                sm[carNumber] = (23*60+59 - inTime)
            }
        }

        val list = mutableListOf<Int>()
        for (key in sm.keys) {
            val time = sm[key] ?: 0

            val diffTime = time - fees[0]
            var cost = fees[1]

            if (diffTime >= 0) {
                cost += if (diffTime % fees[2] == 0) {
                    (diffTime / fees[2]) * fees[3]
                } else {
                    (diffTime / fees[2] + 1) * fees[3]
                }
            }

            list.add(cost)
        }

        return list.toIntArray()
    }
}

fun main() {
    val f1 = intArrayOf(180, 5000, 10, 600) // 기본시간, 기본 요금, 단위 시간, 단위 요금
    val f2 = intArrayOf(120, 0, 60, 591)
    val f3 = intArrayOf(1, 461, 1, 10)

    val r1 = arrayOf(
        "05:34 5961 IN",
        "06:00 0000 IN",
        "06:34 0000 OUT",
        "07:59 5961 OUT",
        "07:59 0148 IN",
        "18:59 0000 IN",
        "19:09 0148 OUT",
        "22:59 5961 IN",
        "23:00 5961 OUT"
    )
    val r2 = arrayOf("16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN")
    val r3 = arrayOf("00:00 1234 IN")

    ParkingCostCalculation().solution(f1, r1) // [14600, 34400, 5000]
    ParkingCostCalculation().solution(f2, r2) // [0, 591]
    ParkingCostCalculation().solution(f3, r3) // [14841]
}