package advanced

class MyGeneric<T>(val t: T) {

}

class MyGenericOut<out T>(val t: T) {
}

class Bag<T> {
    fun saveAll(
        to : MutableList<in T>, // 반공변성 사용
        from : MutableList<T>
    ) {
        to.addAll(from)
    }
}
fun main() {
    // 제네릭을 사용한 클래스의 인스턴스를 만드려면 타입아규먼트를 제공
    val generic = MyGeneric<String>("테스트")

    // 생략가능
    val generic2 = MyGeneric("테스트2")

    // 변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()
    // 타입아규먼트를 생성자에서 추가
    val list2 = mutableListOf<String>()

    // 타입을 모두 정의하고 싶을때
    val list3: List<*> = listOf("테스트")
    val list4: List<*> = listOf(1, 2, 3, 4)

    // 변성
    // 이펙티브 자바 PECS Producer - Extends, Consumer - Super
    // 공변성 자바 제네릭 extends, 코틀린 제네릭 out
    val genericOut = MyGenericOut("테스트2")
    //val charSequence : MyGeneric<CharSequence>  = generic; // 사용불가
    val charSequence: MyGenericOut<CharSequence> = genericOut // CharSequence 상위가 String이라서 가능

    // 반공변성 자바 제네릭 super, 코틀린 제네릭 in
    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1","2"), mutableListOf<String>("3","4")) // error
    // 반공변성을 사용하면 사용할수 있음


}