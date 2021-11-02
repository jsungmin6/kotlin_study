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
}