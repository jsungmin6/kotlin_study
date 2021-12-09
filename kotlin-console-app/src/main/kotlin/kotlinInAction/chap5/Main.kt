package kotlinInAction.chap5

import kotlinInAction.chap3.joinToString3

data class Person(
    val name: String,
    val age: Int
)


fun main() {
    val people = listOf(Person("Chess", 28), Person("Gona", 25))

    //람다활용
    println(people.maxByOrNull { it.age })

    //멤버 참조
    println(people.maxByOrNull (Person::age))

    //번잡한 람다
    println(people.maxByOrNull ({p:Person -> p.age}))
    //개선1
    println(people.maxByOrNull {p:Person -> p.age})
    //개선2
    println(people.maxByOrNull {p -> p.age})

    //joinToString
    val names = people.joinToString(separator = " ", transform = {p:Person -> p.name})
    println(names)

    //람다를 괄호 밖으로 이동
    println(people.joinToString(" "){p:Person -> p.name})

    //
    val sum = {x:Int, y:Int -> println("gona hi $y")
        x+y}
    println(sum(1,2))

    //생성자 참조
    val createPerson = ::Person
    val p = createPerson("Aplice",22)
    println(p)

    //확장함수 멤버 함수 방식
    fun Person.isAdult() = age>21
    val predicate = Person::isAdult

    //filter
    val list = listOf(1,2,3,4)
    list.filter { it % 2 == 0 }

    //map
    list.map { it*it } // [1,4,9,16]
    people.map(Person::name)
    people.filter{it.age > 20}.map(Person::name)

    //시퀀스
    people.asSequence()
        .map(Person::name)
        .filter{ it.startsWith("A")}
        .toList()




}