import java.lang.NullPointerException

fun basicNullSafety() {
    // 컴파일 단계에서 null로 초기화가 불가능하도록 처리 됨
//    val a : String = null
//    var b : String = "aabbcc"
//    b = null // null로 값을 할달 할 수도 없음

    // nullable 하여 주려면 타입에 ?를 붙여 줘야함
    var c: String? = null
    // nullable 변수는 safety 연산자(?)를 붙여줘야 해당 메서드및 속성을 사용할 수 있다.
    println(c?.length)

    // 값이 널이면 조건처리하는 구문 (앨비스 연산자로 대체가능)
    val e: Int = if (c != null) c.length else 0
    println(e)

    // 앨비스 연산자 (?:)
    val d = c?.length ?: 0
    println(d)
}

fun getNullStr(): String? = null
fun getLengthIfNotNull(str: String?) = str?.length ?: 0

fun main() {
    basicNullSafety();

    // Java_NullSafety 클래스와 사용방법 비교
    val nullableStr = getNullStr();
    val nullableStrLength = nullableStr?.length ?: "null인 경우 반환".length
    println(nullableStrLength)

    var length = getLengthIfNotNull(null)
    println(length)


    // NPE를 발생될 수 있는 경우
    // 1. NullPointerException을 발생시키기
//    throw NullPointerException();

    // 2. !! 단언연산자 (널이 발생할 수없을때 사용) 사용
//    val c : String? = null
//    val d = c!!.length

    // 3. 자바코드의 값을 사용할때
//    println(Java_NullSafety.getNullStr().length)

}