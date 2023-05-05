// 기본생성자 constructor로 선언가능 하며, 생략해도 됨.
class Coffee constructor(
    val name: String,
    val price: Int, // 후행 쉼표 가능
    var brand: String = "스타벅스", // 기본값 설정 가능
) {
    // 커스텀 getter
    val beanName: String
        get() = "칠레산"

    // 커스텀 setter
    var quantity: Int = 0
        set(value) {
            if (value > 0) {
                field = value // field는 식별자임.실제 백킹필드에 접근한다. quantity를 사용하면 무한반복이 발생한다.
            }
        }
}

// 본문 생략 가능
class EmptuClass

fun main() {
    val coffee = Coffee("아메리카노", 2000)

    coffee.quantity = 1; // setter로 값 설정

    println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price}")
    println(coffee.quantity)

}