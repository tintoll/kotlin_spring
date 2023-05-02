// 탑레벨에 변수 선언이 가능 하다
var x = 5

fun main(args: Array<String>) {
    //  변수 할당
    val a : Int = 1
    val b = 2 // 타입 추론이 가능합

    // 지연할당
    val c : Int
    c = 3
    // 지연할당시에는 무조건 타입을 줘야함.
    val d : Int
    d = 123

    // val(value) - 재할당 불가능
    // var(variable) - 재할당 가능
    val e : String  = "hello"
    // e = "world" // error
    var f = 123
    f = 22

    x += 1
    println(x)
}