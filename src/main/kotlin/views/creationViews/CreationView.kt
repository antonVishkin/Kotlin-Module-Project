package views.creationViews

import data.*
import views.View
import java.util.*

abstract class CreationView(private val list: ListOfData) : View() {
    override var exit = false
    fun createInstance(): () -> Unit = {
        val data: Data = when (list) {
            is ArchiveList -> {
                println("Введите имя архива")
                val name = Scanner(System.`in`).nextLine()
                Archive(name)
            }
            is NoteList -> {
                println("Введите имя заметки")
                val name = Scanner(System.`in`).nextLine()
                println("Введите текст заметки")
                val text = Scanner(System.`in`).nextLine()
                Note(name, text)
            }
        }
        list.list.add(data)
        println("Создание выполненно")
    }
}