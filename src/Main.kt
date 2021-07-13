import backjun.s1.SetPresentation
import backjun.s1.Tomato
import pg.lv1.CountDividor
import pg.lv2.ArrayRotation
import pg.lv3.BestAlbum
import pg.lv3.StarSequence
import pg.lv3.TripRoute

fun main() {

    val s = BestAlbum()
    val sArr = arrayOf("classic", "pop", "classic", "classic", "pop")
    val intArr = intArrayOf(500, 600, 150, 800, 2500)
    println(s.solution(sArr, intArr))
}

