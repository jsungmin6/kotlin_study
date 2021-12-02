package kotlinInAction.chap4

import java.io.Serializable

interface Clickable {
    fun click()

    //디폴트 메서드
    fun showOff() = println("나 디폴트 메서드")

}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I`m focusable!")
}

class Button : Clickable,Focusable{
    override fun click() {
        println()
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

//상속 가능
open class RichButton : Clickable {
    fun disble() {} // 오버라이드 불가
    open fun animate() {} // 오버라이드 가능
    final override fun click() {} // final 을 붙여야 오버라이드 불간으

}

//추상 클래스
abstract class Animated {
    abstract fun animate() //하위에서 반드시 오버라이드
    open fun stopAnimating() {} // 오버라이드 허용
    fun animateTwice(){} // 오버라이드 불간능
}

interface State : Serializable

interface View {
    fun getCurrentState():State
    fun restoreState(state: State) {}

}

class Button2 : View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {
    }
    class ButtonState() : State {} // 자바의 정적 중첩 크래스와 대응한다.
}

