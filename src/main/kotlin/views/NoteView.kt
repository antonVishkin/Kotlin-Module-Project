package views

import data.Note
import views.creationViews.NoteCreationView
import views.listViews.ListView
import java.util.*

class NoteView(val note:Note): ListView() {
    override val nameOfView = "Заметка: ${note.name}"
    override fun createCommands(): List<Pair<String, () -> Unit>> {
        val commands = mutableListOf<Pair<String,()->Unit>>()
        commands.add(Pair("Изменить имя заметки",changeNoteName()))
        commands.add(Pair("Изменить текст заметки",changeNoteText()))
        commands.add(Pair("look text ") { println(note.text) })
        commands.add(Pair("Выйти",exit()))
        return commands
    }

    fun changeNoteName(): () -> Unit = {
        println("Enter new name")
        note.name = Scanner(System.`in`).nextLine()
    }
    fun changeNoteText(): () -> Unit = {
        println("Enter new text")
        note.name = Scanner(System.`in`).nextLine()
    }
    fun exit() = {this.exit = true}
}