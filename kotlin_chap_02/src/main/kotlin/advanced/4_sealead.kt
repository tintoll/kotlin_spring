package advanced

//abstract class Developer {
//    abstract val name: String
//    abstract fun code(language: String)
//}

sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자 입니다. $language 를 사용합니다.")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자 입니다. $language 를 사용합니다.")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    // Developer 가 abstract 일경우에는 하위 클래스가 어떤게 있는지 알수 없기 때문에
    // when 에서 else를 무조건 구현해야 한다.
    // sealed 클래스 일경우에는 하위 클래스를 모두 알고 있기 때문에 else를 하지 않아도 된다.
    // sealed는 같은 파일 또는 모듈 안에 있어야 하위클래스를 알 수 있다.
    // 이걸 사용하면 추가로 하위 클래스를 추가하면 when에서 컴파일 단계에서 에러가 발생하기 때문에 구현해야되는부분을 잊어버리지 않을 수 있다.
    fun add(developer: Developer) = when (developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
//        else -> println("지원하지 않는 개발자입니다. ")
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name = "토니")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name = "엔써")
    DeveloperPool.add(frontendDeveloper)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("엔써"))

}