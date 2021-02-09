package pg.lv2

class CandidateKey {
//    [["100","ryan","music","2"],["200","apeach","math","2"],
//    ["300","tube","computer","3"],["400","con","computer","4"],
//    ["500","muzi","music","3"],["600","apeach","music","2"]]

   //유일성을 만족하는 최소의 후보키가 몇개인가? 위에서는 2개 [이름, 전공]
    fun solution(relation: Array<Array<String>>): Int {
        var answer = 0

        /*
        1. 선택한 ( 학번, 이름, 전공, 학년 ) 키의 중복이 있는지 체크
        2. 키 이외의 나머지 값들에서 중복이 발생하는지 체크
        3-1. 예를들면 학번을 선택하면 100,200,300,400,500,600 에서 중복이 안됨
        3-2. 나머지 벨류에서 이름 중복 (appeach), 전공 중복 (컴퓨터,뮤직), 학년 중복(2, 3)
        4. 정렬 활용하여 앞뒤로 체크?
         */
       
        return answer
    }
}
