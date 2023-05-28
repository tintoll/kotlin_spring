package advanced

fun main() {
    // with는 결과 반환 없이 내부에서 수신객체를 이용해서 다른 함수를 호출하고 싶을때 사용

    // run과 유사하게 사용한다. 그런데 with는 확장함수가 아니다.
    val str = "안녕하세요"
    with(str) {
        println("length = $length")
    }
}