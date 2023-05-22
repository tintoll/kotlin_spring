package advanced

class `7_LateInit` {
    lateinit var text: String
    fun printText() {
        text = "안녕하세요"
        // isInitailized는 클래스 내부에서만 사용가능
        if (this::text.isInitialized) {
            println("초기화됨")
        } else {

        }

        println(text)
    }
}

fun main() {
    val test = `7_LateInit`()
    test.printText()
}