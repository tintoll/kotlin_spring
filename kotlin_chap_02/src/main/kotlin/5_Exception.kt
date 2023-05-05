import java.lang.Exception

fun main() {
    Thread.sleep(1)

    try {
        Thread.sleep(1)
    } catch (e: Exception) {
        println("에러 발생")
    } finally {
        println("finally 발생")
    }

    // try-catch는 표현식이다.
    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        println("에러 발생")
    }
    println(a)

    // 앞에서 널에대한 안전성을 보장해주면 안전연산자를 사용하지 않아도 된다.
    val b: String? = null
    val c = b ?: "11"
    println(c.length) // 안전연산자 ? 를 안해도 length를 사용가능하다

    failFast("빠른 예외 발생 ")
    println("앞에 예외가 있어서 컴파일단에서 경고를 해준다.") // 컴파일단게에서 경고가 나옴.

}

// 예외를 발생시키면 리턴타입이 Nothing 이다.
fun failFast(message: String): Nothing {
    throw IllegalArgumentException(message)
}