package example.java.exception;
import java.io.IOException

class KotlinThrow {

    // java 에서 처럼 예외를 전파하려면 @Throws를 사용해야한다.
    @Throws(IOException::class)
    fun throwIOException() {
        throw IOException("체크드 익셉션인 IOException 발생")
    }

}

fun main() {
    val javaThrow = JavaThrow()
    // 코틀린에서는 예외를 잡아주지 않아도 된다.
    javaThrow.throwIOException()

    val kotlinThrow = KotlinThrow()
    kotlinThrow.throwIOException()
}

