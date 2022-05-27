package structure

class 잡기술 {

    companion object {
        /**
         * 패턴을 상수로 만들고 호출하면 정규식을 체크할때 마다음
         * 만들어지는 불필요한 객체의 생성을 막을 수 있음
         */
        val EMAIL = Regex("^a")
    }

    fun test() {
        EMAIL.matches("abcd")
    }
}

data class Student(val age: Int, val name: String)