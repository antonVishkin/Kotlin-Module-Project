package views

import data.Note
import java.util.*

class NoteView(val note: Note) : View() {
    override var exit = false
    override val nameOfView = "Заметка: ${note.name}"
    override fun createCommands(): List<Pair<String, () -> Unit>> {
        val commands = mutableListOf<Pair<String, () -> Unit>>()
        commands.add(Pair("Изменить имя заметки", changeNoteName()))
        commands.add(Pair("Изменить текст заметки", changeNoteText()))
        commands.add(Pair("Посмотреть текст заметки ") { println(note.text) })
        commands.add(Pair("Вернуться к списку заметок", exit()))
        return commands
    }

    fun changeNoteName(): () -> Unit = {
        println("Введите новое имя заметки")
        note.name = Scanner(System.`in`).nextLine()
    }

    fun changeNoteText(): () -> Unit = {
        println("Введите новый текст заметки")
        note.name = Scanner(System.`in`).nextLine()
    }
}