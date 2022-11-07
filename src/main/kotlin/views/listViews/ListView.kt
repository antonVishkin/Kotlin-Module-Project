package views.listViews

import views.View
import java.util.*

abstract class ListView: View() {
    abstract fun createCommands():List<Pair<String,()->Unit>>

    var exit = false
    private fun printView(elements:List<String>){
        println(nameOfView)
        elements.forEachIndexed{index, data ->  println("${index}. ${data}")}
    }
    fun readCommand(){
        while (!exit){
            val commandsWithFun = createCommands()
            val commands = commandsWithFun.map { it -> it.first }
            printView(commands)
            println("Выберите пожалуйста действие:")
            val command = Scanner(System.`in`).nextLine().toIntOrNull()
            if (command != null){
                commandsWithFun[command].second.invoke()
            } else {
                println("это была не цифра, давай попробуем снова!")
            }
        }
    }
}