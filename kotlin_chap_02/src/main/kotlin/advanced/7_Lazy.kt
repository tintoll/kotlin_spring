package advanced

class HelloBot {
    // 가변변수는 위험이 존재하기 때문에 불변을 사용하는 것이 좋다.
    // 하지만 지연초기화를 하려면 var를 사용해야 한다
//    var greeting: String? = null

    // 이때 by lazy를 이용한다. (불변일때만 사용가능)
    // 멀티쓰레드 환경에서도 안전하게 동작되도록 설계되어 있다.
    // LazyThreadSafetyMode.NONE으로도 변경가능하다,
    val greeting: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        // 초기화 로직은 한번만 실행된다.
        println("초기화 로직 수행")
        getHello()
    }

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"
fun main() {
    val helloBot = HelloBot()
    // helloBot.greeting = getHello() // 기존에 지연 초기화하려면 이렇게 가변변수를 변경해야했다.

//    helloBot.sayHello()
//    helloBot.sayHello()
//    helloBot.sayHello()

    for (i in 1 .. 5) {
        Thread {
            helloBot.sayHello()
        }.start()
    }
}