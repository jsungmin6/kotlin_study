package kotlinInAction.chap5

fun alphabet() : String {
    val result = StringBuilder()
    for (letter in 'A'..'Z'){
        result.append(letter)
    }
    result.append("\nGona")
    return result.toString()
}

fun alphabetWith() : String {
    val stringbuilder = StringBuilder()
    return with(stringbuilder){
        for (letter in 'A'..'Z'){
            this.append(letter) //명시적으로 this 사용
        }
        append("\nGona")//this 생략
        this.toString()//람다에서 값 반환
    }

}

fun alphabetWithAdvance() = with(StringBuilder()) {
    for (letter in 'A'..'Z'){
        append(letter) //명시적으로 this 사용
    }
    append("\nGona")//this 생략
    this.toString()//람다에서 값 반환
}

fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z'){
        append(letter)
    }
    append("\nGona")
}.toString()

fun alphabetApplyBuildString() = buildString {
    for (letter in 'A'..'Z'){
        append(letter)
    }
    append("\nGona")
}

fun main() {
    println(alphabet())
    println(alphabetApplyBuildString())
}
