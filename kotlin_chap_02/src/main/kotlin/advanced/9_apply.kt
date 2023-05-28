package advanced

fun main() {
    // 수신객체의 프러퍼티를 구성하고 수신객체를 그대로 반환하고 싶을때 사용
    // 수신자 객체의 초기화 작업시 유용하다

    // run과 차이는 반환하는 값이 수신자객체라는것이다.
    val client: DatabaseClient = DatabaseClient().apply {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }
    val connected = client.connect()
    println(connected)
    // 위 작업을 동일하게 run으로 만들수 도 있다.
    client.connect().run { println(this) }
}