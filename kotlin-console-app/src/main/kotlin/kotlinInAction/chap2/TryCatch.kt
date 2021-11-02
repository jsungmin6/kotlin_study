package kotlinInAction.chap2

import java.io.BufferedReader
import java.io.StringReader
import java.text.NumberFormat


fun main(args: Array<String>) {
    fun readNumber(reader: BufferedReader): Int? {
        try {
            val line = reader.readLine()
            return Integer.parseInt(line)
        } catch (e: NumberFormatException) {
            return null
        }
        finally {
            reader.close()
        }
    }
    val reader = BufferedReader(StringReader("236"))
    println(readNumber(reader))
}