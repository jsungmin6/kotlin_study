package kotlinInAction.chap2



//반환타입 명시
fun max(a: Int, b:Int) : Int {
    return if (a > b) a else b
}

//반환타입 생략, 타입 추론
fun max2(a: Int, b:Int) = if (a>b) a else b


fun test(){
    //타입 표기 생략
    val question = "q"
    //기본적으로 Int 타입
    val answer = 1
    //기본적을으로 Double 타입
    val ytc = 7.5e6

    //타입 표기
    val m1 : Int = 1

    //초기화만 할때는 변수타입 명시
    val m2 : Int
    m2 = 1

    //val var
    val v1 : Int = 1
    var v2 : Int = 2
    // v1 = 1 < = 에러
    v2 = 3 //< = 대입 가능

    //val 내부 값 변경 가능
    val lang = arrayListOf("Java")
    lang.add("hi")

}

fun main(args: Array<String>) {

    println(max(4,5))
    println("max2 : ${max2(4,5)}")

    val lang = arrayListOf("Java")
    lang.add("hi")
    println(lang)

    println("Hello, ${if (args.size > 0) args[0] else "someone"}")

}
