package pg.lv3

class BestAlbum {

    fun solution(genres: Array<String>, plays: IntArray): IntArray {

        return genres.indices.groupBy { genres[it] } // { classic = [0,2,3], pop = [1,4] }
            .toList() // Pair<K, V> [(classic, [0,2,3]) , (pop, [1,4])]
            .sortedByDescending { it -> it.second.sumBy { plays[it] } } // [(pop, [1,4]), (classic, [0,2,3])]
            .map { it -> it.second.sortedByDescending { plays[it] }.take(2) } // [[4,1],[3,0]]
            .flatten() // [4, 1, 3, 0]
            .toIntArray()

        //val sortedList = list.sortedWith(compareBy(Person::age, Person::name))
    }
}

data class Test(val age: Int, var name: String, val address: String)