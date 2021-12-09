package kotlinInAction.chap5

class Message {
}

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String){
    messages.forEach{
        println("$prefix $it") //람다 안에서 prefix를 사용한다!
    }
}

fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors,"Error: ")
}