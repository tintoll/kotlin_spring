package advanced

import java.time.LocalDateTime

// object 키워드로 클래스를 만들면 싱글톤 클래스다
object Singleton {
    val a = 1234
    fun printA() = println(a)
}

object DatetimeUtils {
    val now: LocalDateTime
        get() = LocalDateTime.now()

    // 상수로 표현할때 const 키워드를 사용한다.
    const val DEFAULT_FORMAT = "YYYY-MM-DD"

    fun same(a: LocalDateTime, b: LocalDateTime): Boolean {
        return a == b
    }

}


class MyClass {

    private constructor()

    // 동반객체 (클래스명을 주어도 된다)
    companion object {
        val a = 1234
        fun newInstance() = MyClass()
    }
}


fun main() {
    // Static 메서드,프러퍼티 호출하듯 사용된다.
    // Jvm에서 UTIL 클래스를 object 클래스로 많이 사용한다.
    println(Singleton.a)
    Singleton.printA()

    println("==============")
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)

    println(DatetimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DatetimeUtils.same(now, now))


    println("==============")
    println(MyClass.a)
    println(MyClass.newInstance())
    // Companion 붙여서 호출되 된다. 하지만 사용하지 않는다.
    // 클래스 이름을 주면 그이름을 주면 된다.
    println(MyClass.Companion.a)
    println(MyClass.Companion.newInstance())

}