package advanced

import java.lang.Exception

fun getStr() : Nothing = throw Exception("예외 발생 기본 값으로 초기화")

fun main() {

//    val result = try {
//        getStr()
//    } catch (e: Exception) {
//        println(e.message)
//        "기본값"
//    }

    // runCatching 이용해서 처리
    val result = runCatching { getStr() }.getOrElse {
        println(it.message)
        "기본값"
    }

    // getOrNull() : 실패시 Null을 반환
    // exceptionOrNull() : 실패시 Exception을 반환
    // getOrDefault("기본값") : 실패시 기본값을 반환한다.
    // getOrElse() : 실패시 수신자 객체로 예외를 받고 리턴을 할수 있다.
    // getOrThrow() : 실패시 예외를 발생한다.
    // map : 성공일 경우 원하는 값으로 변경할 수 있다. 반환이 Result라서 다른 함수들가 같이 사용한다.
    // mapCatching : map 안에서 예외가 발생하는 경우에 사용한다.map을 쓰면 처리가 안된다.
    // recover : 실패시 원하는 값으로 변경할 수있다. map의 반대
    // recoverCatching : mapCatching의 반대


    println(result)
}