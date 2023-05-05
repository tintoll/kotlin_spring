class Product(val name: String, val price: Int)

// 인터페이스는 상위 인터페이스를 가질수 있다.
interface Wheel {
    fun roll()
}

interface Cart : Wheel {

    var coin : Int
    val weight : String
        get() = "20KG" // 인터페이스에서는 백킹필드를 사용할 수 없다.

    fun add(product: Product)

    // default method
    fun rent() {
        if (coin > 0) {
            println("카트를 대여합니다.")
        }
    }

    override fun roll() {
        println("카트가 굴러갑니다.")
    }

    fun printId() = println("5678")
}

// 여러개의 인터페이스를 구현할 수 있다
interface Order {
    fun add(product: Product) {
        println("${product.name} 을 구매하였습니다.")
    }

    fun printId() = println("5678")
}

// 클래스 extends 할 경우에는 생성자가들어가는데 인터페이스는 명만 들어간다.
class MyCart(override var coin: Int) : Cart, Order {
    override fun add(product: Product) {
        if(coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이 카트에 추가되었습니다.")

        // 상위 인터페이스를 참조하려면 아래와같이 사용해야한다.
        super<Order>.add(product)
    }

    // 강제로 override 해줘야한다.
    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}
fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name="장난감", price = 1000))


}