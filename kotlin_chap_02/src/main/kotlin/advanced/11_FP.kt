package advanced

fun main() {
    // 1급객체
    // 함수도 타입이다. 함수는 값이 될수 있고 값도 함수가 될수 있다.
    // val func : () -> String = {""}
    val list = mutableListOf(printHello)
    list[0]() // Hello

    // 다른 함수의 인자로도 넣을수 있다.
    call(printHello) // Hello
//    call(printHello2) // Compile Error : 1급객체가 아님

    val result: Int = plus(1, 3)
    println(result)  // 4

    // 고차함수 : 함수를 인자로 받거나 결과로 돌려주는 함수
    val list2 = listOf("a", "b", "c")
    val printStr: (String) -> Unit = { println(it) }
    forEachStr(list2, printStr)

    // forEach, map도 고차함수있다.
    list2.forEach(printStr)

    // 익명함수
    outerFunc()()

    // 람다표현식
    // 함수의 마지막인자로 함수(함수식의 인자를 1개만받아야함)를 인자로 받을 경우 : 후행 람다표현식 forEach, filter 등
    list2.filter { it == "a" }

    // 람다레퍼런스
    val callReference: () -> Unit = { printHello() }
    val callReference2 = ::printHello  // 람다레퍼런스
    callReference()
    callReference2()

    val numberList = listOf("1", "2", "3")
    numberList.map { it.toInt() }.forEach { println(it) }
    numberList.map(String::toInt).forEach(::println) // 람다레퍼런스
    
}

// 람다 표현식의 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

// 최대한 생략함 람다식
val sum2 = { x: Int, y: Int -> x + y }


fun outerFunc(): () -> Unit {
    return fun() {
        println("이것이 익명함수")
    }
}

fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}


// 인자를 받는 함수형태
val printMessage: (String) -> Unit = { message: String -> println(message) }
val printMessage2: (String) -> Unit = { message -> println(message) }
val printMessage3: (String) -> Unit = { println(it) }

// 여러 인자를 받는 형태
val plus: (Int, Int) -> Int = { a, b -> a + b }

// 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block()
}

val printHello: () -> Unit = { println("Hello") }


// fun으로 선언한 함수는 1급객체의 특성인 값이되거나 함수의 인자로 넣을수 있는 역할을 할 수 없다.
fun printHello2() {
    println("Hello")
}