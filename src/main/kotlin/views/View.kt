package views

import java.util.*

abstract class View {
    abstract var exit:Boolean
    abstract val nameOfView: String
    abstract fun createCommands():List<Pair<String, () -> Unit>>
    private fun printView(elements: List<String>) {
        println(nameOfView)
        elements.forEachIndexed { index, data -> println("${index}. $data") }
    }
    fun readCommand() {
        while (!exit) {
            val commandsWithFun = createCommands()
            val commands = commandsWithFun.map { it.first }
            printView(commands)
            println("Выберите пожалуйста действие:")
            val command = Scanner(System.`in`).nextLine().toIntOrNull()
            if (command != null) {
                if (command < commandsWithFun.size)
                    commandsWithFun[command].second.invoke()
                else {
                    println("такой команды нет, давай попробуем снова!")
                }
            } else {
                println("это была не цифра, давай попробуем снова!")
            }
        }
    }
    internal fun exit(): () -> Unit = { this.exit = true }
}