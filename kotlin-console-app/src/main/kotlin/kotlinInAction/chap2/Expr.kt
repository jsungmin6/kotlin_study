package kotlinInAction.chap2

import java.lang.IllegalArgumentException

interface Expr
class Num(val value: Int) : Expr
class Sum(val left : Expr, val right : Expr) : Expr

//smart cast
fun eval(e: Expr):Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("unknown")
}

fun evalUseWhen(e: Expr): Int =
    when (e) {
        is Num ->
           e.value
        is Sum ->
            eval(e.right) + eval(e.left)
        else ->
            throw IllegalArgumentException("unknown")
    }

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1),Num(2)),Num(4))))
}