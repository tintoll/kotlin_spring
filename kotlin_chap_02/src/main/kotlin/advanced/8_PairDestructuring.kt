package advanced

// 아래 함수에 튜플을 적용할 수 있다.
// f((1,3)) = 1 + 3 = 4
// f(1,3) = 1 + 3 = 4 // 괄호 생략가능
//fun plus(a:Int, b:Int) = a + b
//data class Tuple(val a :Int, val b: Int)
//fun plus(tuple: Tuple) = tuple.a + tuple.b

// 튜플과 같은 2개의 인자를 받아서 처리하는 Pair 클래스가 존재한다.

fun plus(pair: Pair<Int, Int>) = pair.first + pair.second

fun main() {
    println(plus(Pair(1,3)))

    // Pair 은 불변이다.
    val pair = Pair("A", 1)
    // copy를 이용하여 복사해서 변경해서 사용해야 한다.
    val newPair = pair.copy(first = "B")
    println(newPair)

    val second = newPair.component2()
    println(second)

    val list = newPair.toList()
    println(list)

    // 3개의 인자를 받는 Triple이 존재한다.
    val triple = Triple("A","B","C")

    // 구조분해할당을 사용할수 있다. 리스트나, 튜플, 트리플등
    val (a,b,c) = triple
    val (f:String,d:String,e:String) = triple

    // to 중위표현식도 실제는 Pair 로 변환할수도 있다.
    val map = mutableMapOf("이상훈" to "개발자")
    // map도 구조분해할당이 된다.
    for ( (key, value) in map) {
        println("${key}의 직업은 $value")
    }

}