package advanced

class User(val name:String, val password: String) {
    fun validate() {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            println("검증 성공")
        } else {
            println("검증 실패")
        }
    }
}
fun main() {
    // 부수작업을 수행, 전달받은 수신객체를 결과로 반환하고 싶을때 사용

    val user: User = User(name="tony", password = "1234")
    user.validate()

    // also 사용 
    User(name="tony", password = "1234").also { it.validate() }
}