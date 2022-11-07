package views.creationViews

import data.Archive
import data.ArchiveList
import data.Note
import views.View
import java.util.*

class NoteCreationView(private val archive: Archive) : View() {
    override val nameOfView = "Создание заметки"
    fun createNote(){
        println(nameOfView)
        println("Введите имя заметки")
        val name = Scanner(System.`in`).nextLine()
        println("Введите текст заметки")
        val text = Scanner(System.`in`).nextLine()
        archive.addNoteToArchive(Note(name,text))
    }
}