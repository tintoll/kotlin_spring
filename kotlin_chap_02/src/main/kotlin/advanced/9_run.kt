package advanced


class DatabaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null

    fun connect(): Boolean {
        println("DB 접속중 ..")
        Thread.sleep(1000)
        println("DB 접속 완료")
        return true
    }
}

fun main() {
    // run을 사용안했을때
//    val config = DatabaseClient()
//    config.url = "localhost:3306"
//    config.username = "mysql"
//    config.password = "1234"
//    val connected = config.connect()

    // run은 수신객체의 프러퍼티를 구성하거나 새로운 결과를 반환하고 싶을때 사용
    // run 사용
    val connected = DatabaseClient().run {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()
    }

    println(connected)

}