package advanced

import java.io.FileWriter

fun main() {
    FileWriter("text.txt")
        .use {
            it.write("Hello Kotlin")
        }
}