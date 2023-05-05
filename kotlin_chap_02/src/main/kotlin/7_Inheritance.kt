// 상속 가능하려면 open 키우드를 사용해야 한다.
open class Dog {
    open var age: Int = 0
    open fun bark() {
        println("멍멍")
    }
}

// 상속
open class BullDog(override var age: Int = 0) : Dog() {
    // 재정의시 override 키워드 사용
    // 하위클래스에서 override된 프로퍼티및함수는 open 상태가 된다.
    // 하위에서 재정의 못하도록 하려면 final 키워드 사용
    final override fun bark() {
        println("컹컹")
    }
}

class ChildBullDog : BullDog() {
    override var age: Int = 0
    // bark 함수를 재정의 못함.
}


// 추상클래스
abstract class Developer {
    // 하위클래스에서재정의 필요한것은 abstract를 붙여준다.
    abstract var age: Int
    abstract fun code(language: String)
}

class BackendDeveloper(override var age: Int) : Developer() {
    override fun code(language: String) {
        println("I code with $language")
    }
}


fun main() {
    val dog = BullDog(age = 5)
    println(dog.age)
    dog.bark()

    val backendDeveloper = BackendDeveloper(20)
    println(backendDeveloper.age)
    backendDeveloper.code("Kotlin")

}