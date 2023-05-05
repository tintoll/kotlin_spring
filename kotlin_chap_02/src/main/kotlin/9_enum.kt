// java랑 다르게 enum class 라고 선언해야한다.
enum class PaymentStatus(val label: String) : Payable {
    UNPAID("미지급") {
        override fun isPayable(): Boolean = true

    },
    PAID("지급완료") {
        override fun isPayable(): Boolean = false

    },
    FAILED("지급실패") {
        override fun isPayable(): Boolean = false

    },
    REFUNDED("환불") {
        override fun isPayable(): Boolean = false
    };

    //    fun isPayable() = false
    // 각 상태에 isPayable를 적용하고 싶으면 abstract 메서드로 만들어주면된다. enum 내부보다는 interface로 빼주는게 낫다.
//    abstract fun isPayable(): Boolean

}

// enum 도 클래스이기 때문에 인터페이스를 구현할 수 있다.
interface Payable {
    fun isPayable(): Boolean
}


fun main() {
    println(PaymentStatus.UNPAID.label)
    if (PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능 상태")
    }

    val paymentStatus = PaymentStatus.valueOf("PAID");
    println(paymentStatus.label)

    // 동등비교  ==
    if (paymentStatus == PaymentStatus.PAID) {
        println("결재완료 상태")
    }

    // values() 함수를 이용하여 상태를 가져올수 있다.
    for (status in PaymentStatus.values()) {
        println("$status 의 이름은 ${status.label}")

        // 기본적으로 제공해주는 속성 name(키), ordianl (순서값을 출력)
        println("${status.name} ${status.ordinal}")
    }

}