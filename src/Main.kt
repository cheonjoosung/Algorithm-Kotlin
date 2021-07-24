import backjun.s1.SetPresentation
import backjun.s1.Tomato
import pg.lv1.CountDividor
import pg.lv2.ArrayRotation
import pg.lv3.BestAlbum
import pg.lv3.EditPyo
import pg.lv3.StarSequence
import pg.lv3.TripRoute

fun main() {

    val s = EditPyo()

    val cmd1 = arrayOf("D 2","C","U 3","C","D 4","C","U 2","Z","Z")
    val cmd2 = arrayOf("D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C")

    println(s.solution(8, 2, cmd1))
    println(s.solution(8, 2, cmd2))
}

