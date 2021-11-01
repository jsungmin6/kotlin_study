package kotlinInAction.chap2

enum class Color(val r: Int, val g :Int, val b:Int) {
    RED(255,0,0),
    ORANGE(255,165,0),
    GREEN(0,255,0),
    BLUE(0,0,255); // 반드시 세미콜론 사용

    fun rgb() = (r*256 +g) * 256 + b; // enum 클래스 안에서 정의
}



fun getMnemonic(color: Color) =
    when (color) {
        Color.BLUE -> "Battle"
        Color.GREEN -> "Gave"
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
    }

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED,Color.BLUE) -> Color.ORANGE
        else -> throw Exception("Dirty Color")
    }

fun main(args: Array<String>) {
    println(Color.BLUE.rgb())
    println(mix(Color.RED,Color.BLUE))
}