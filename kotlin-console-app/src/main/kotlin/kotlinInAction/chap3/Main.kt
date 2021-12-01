package kotlinInAction.chap3



//초안
fun <T> joinToStirng1(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String

):String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//디폴트 파라미터 추가
fun <T> joinToString2(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
):String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//확장함수 사용
fun <T> Collection<T>.joinToString3(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
):String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//확장 프로퍼티
val String.lastChar1: Char get() = get(length - 1)
var StringBuilder.lastChar2: Char
    get() =get(length - 1)
    set(value: Char) { this.setCharAt(length - 1, value) }

fun main(args: Array<String>) {
    //set
    val hashSetOf = hashSetOf(1, 6)
    //list
    val arrayListOf = arrayListOf(1, 2, 3)
    //map
    val hashMapOf = hashMapOf(1 to "one")

    //jointoString
    val list = listOf(1, 2, 3)
    println(joinToStirng1(list, ";", "(", ")"))

    //디폴트 사용
    joinToString2(list)
    joinToString2(list,postfix = "#")

    //확장함수 사용
    val el = arrayListOf(1, 2, 3)
    println(el.joinToString3(" "))



    //확장함수는 오버라이드할 수 없다
    open class View {
        open fun click() = println("View Click!")
    }
    class Button: View() {
        override fun click() = println("Button Click!")
    }
    fun View.showOff() = println("view")
    fun Button.showoff() = println("botton")
    val view: View = Button() //
    view.showOff() // <= view

    //확장 프로퍼티
    println("Kotlin".lastChar1)
    val sb = StringBuilder("Kotlin?")
    sb.lastChar2 = '!'
    println(sb)


}