package kotlinInAction.chap2

class Person (
    val name: String,
    val isMarried: Boolean,
)

fun main() {
    val person = Person("gona", false)
    println(person.name)
    println(person.isMarried)

}