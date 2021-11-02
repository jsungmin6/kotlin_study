package kotlinInAction.chap2

import java.util.*

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "${i}"
}



fun mapIter() {
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}

fun indexIter(){
    val list = arrayListOf("10","11","12")
    for ((index, element) in list.withIndex()) {
        println("$index : $element")
    }
}

// in으로 컬렉션이나 범위 검사
fun isLetter(c: Char): Boolean = c in 'a'..'z' || c in 'A'..'Z'


fun main() {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    mapIter()
    indexIter()

}

