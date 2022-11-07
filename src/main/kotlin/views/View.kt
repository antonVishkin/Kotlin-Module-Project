package views

import data.ListOfData
import java.util.*

abstract class View{
    abstract val nameOfView: String
    abstract val commands: Map<String,()->Unit>
    abstract val creatView:()->Unit
    fun printView(elements:List<String>){
        println(nameOfView)
        elements.forEachIndexed{index, data ->  println("${index}. ${data}")}
    }
    fun readCommand(){
        printView(commands.keys.toList())
        while (true){
            println("Выберите пожалуйста действие:")
            val command = Scanner(System.`in`).nextLine().toIntOrNull()
            if (command != null){
                commands.get(commands.keys.elementAt(command))
                break
            } else {
                println("это была не цифра, давай попробуем снова!")
                printView(commands.keys.toList())
            }
        }}
}