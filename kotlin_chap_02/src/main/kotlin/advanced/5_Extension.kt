package advanced

fun String.first(): Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}


// 조심할 부분 (동일한 메서드를 확장하면 기존에 메서드가 호출된다.)
class MyExample {
    fun printMessage() = println("클랙스 출력")
}

fun MyExample.printlnMessage() = println("확장 출력")
fun MyExample?.printNullOrNotNull() {
    if (this == null) println("널이다.")
    else println("널이 아니다.")
}

fun main() {
    println("ABCD".first()) // A
    println("ABCD".addFirst('Z')) // ZABCD

    println("============")
    MyExample().printlnMessage() // 클래스 출력

    println("============")
    var myExample : MyExample? = null
    myExample.printNullOrNotNull() // 안전연산자?를 하지 않아도 된다. 내부적으로 널처리가 되어있으면 안해도 된다.

    myExample = MyExample()
    myExample.printNullOrNotNull()

}