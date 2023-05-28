package advanced

fun main() {
    // 널이 아닌 경우 사용 될 로직에 사용하고 새로운 결과를 반화하고 싶을때 사용
    val str: String = "안녕"
    val result: Int = str.let {
        println(it)

        // 또다른 let을 중첩되게해서 사용된다. 중첩을 많이 사용하면 콜백헬처럼 가독성이 좋지 않음
//        val abc:String = "abc"
//        abc.let {
//            val def : String = "def"
//            def.let {
//                println("abcded가 null이 아님 ")
//            }
//        }
        // 중첩 let보다는 if~else를 사용하는게 더 낳음
        val abc:String = "abc"
        val def : String = "def"
        if (!abc.isNullOrEmpty() && !def.isNullOrEmpty()) {
            println("abcded가 null이 아님 ")
        }





        // 마지막에 나오는 코드가 리턴값이 된다.
        1234
    }

    println(result)
}