package advanced

// 자동으로 toString, equals, hashCode등을 자동생성한다.
data class Person(val name: String, val age: Int)

fun main() {
    val person = Person(name="tony", age=12)
    val person2 = Person(name="tony", age=12)

    // equals를 자동생성하므로 객체가 아닌 프로퍼니 정보로 비교한다.
    println(person ==  person2) // true
    // toString을 자동생성하여 객제주소가 아닌 값정보가 출력된다.
    println(person) // Person(name=tony, age=12)

    val set = hashSetOf(person2)
    println(set) // [Person(name=tony, age=12)]
    println(set.contains(person)) // true

    // copy 메서드를 이용하여 객체 복사를 할수 있다. 인자를 넘겨 값을 변경하여 copy할 수도 있다.
    val person3 = person.copy()
    val person4 = person.copy(name="copyPerson")

    // conponentN이라는 메서드가 자동 생성된다. 프러퍼티 갯수에따라 존재한다.
    println("이름은 ${person4.component1()} 이고 나이는 ${person4.component2()}");

    // 구조분해할당도 사용가능하다
    val (name, age) = person3
    println("구조분해할당 이름 : ${name}, 나이 : $age")
}