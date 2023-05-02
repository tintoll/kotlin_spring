fun main() {
    // 자바의 for..each와 유사
    // 범위 연산자 .. 를 사용해 for loop 돌리기
    // 마지막 숫자까지 출력된다.
    for (i in 0 .. 3) {
        println(i) // 0~3
    }

    // until을 사용해 반복한다
    // 뒤에 온 숫자는 포함되지 않는다.
    for (i in 0 until  3) {
        println(i) // 0~2
    }

    // step에 들어온 값 만큼 증가한다.
    for (i in 0 .. 6 step 2) {
        println(i) // 0,2,4,6
    }

    // downTo를 사용해 반복하면서 값을 감소시킨다.
    for (i in 6 downTo 2) {
        println(i) // 6,5,4,3,2
    }

    // 전달받은 배열을 반복
    val numbers = arrayOf(1,2,3)
    for (i in numbers) {
        println(i)
    }
}