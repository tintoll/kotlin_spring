package advanced

import java.util.LinkedList

fun main() {
    // immutable
    val currencyList = listOf("달러", "유료", "원")

    // mutable
//    val mutableCurrencyList = mutableListOf<String>()
//    mutableCurrencyList.add("달러")
//    mutableCurrencyList.add("유료")
//    mutableCurrencyList.add("원")
    val mutableCurrencyList = mutableListOf<String>().apply {
        add("달러")
        add("유료")
        add("원")
    }

    // immutable set
    val numberSet = setOf(1, 2, 3, 4)
    // mutable set
    val mutableNumberSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }


    // immutable map (key to value 형태로 저장된다.)
    val numberMap = mapOf("one" to 1, "two" to 2)
    // mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1
    mutableNumberMap.put("two", 2)  // 권장하지 않는다.
    mutableNumberMap["three"] = 3


    // 컬렉션 빌더 (생성할때는 mutable처럼  add가 가능하지만 생성 된 다음에는 immutable이다.
    val numberBuildList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }


    // linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    // arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }


    // 출력 iterator 방식
    println("============= iterator 방식 =============")
    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    // 출력 for 방식
    println("============= for 방식 =============")
    for (currency in currencyList) {
        println(currency)
    }

    println("============= forEach 방식 =============")
    currencyList.forEach {
        println(it)
    }

    println("============= for loop 으로 map 처리 =============")
    val lowerList = listOf("a", "b", "c")
    val upperList = mutableListOf<String>()
    for (lowerCase in lowerList) {
        upperList.add(lowerCase.uppercase())
    }
    println(upperList)

    println("=============  map 사용 =============")
    var upperList2 = lowerList.map { it.uppercase() }
    println(upperList2)

    println("=============  for loop 으로 필터 처리 =============")
    val filteredList = mutableListOf<String>()
    for (upperCase in upperList) {
        if (upperCase == "A" || upperCase == "C") {
            filteredList.add(upperCase)
        }
    }
    println(filteredList)

    println("=============  filter 사용 =============")
    // 여러번 filter를 하면 사용할때마다 collection을 생성하기 때문에 메모리 낭비가 심하다
    // 하지만 5만건정도는 그냥 해도 성능차이가 나지 않음
    val filteredList2 = upperList.filter { it == "A" || it == "C" }
    println(filteredList2)

    // java의 stream api하고 다르다
    // 많은 데이터는 asSecu 를 사용 - java stream api 하고 동일하다. 마지막에 연산을 실행
    val filteredList3 = upperList
        .asSequence()
        .filter { it == "A" || it == "C" }
        .toList()

}