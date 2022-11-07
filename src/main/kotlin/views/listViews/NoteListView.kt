package views.listViews

import data.Archive
import data.Note
import data.NoteList
import views.NoteView
import views.creationViews.NoteCreationView

class NoteListView(val archive: Archive):ListView() {
    override val nameOfView = "Список заметок"
    override fun createCommands(): List<Pair<String, () -> Unit>> {
        val commands = mutableListOf<Pair<String,()->Unit>>()
        commands.add(Pair("Создать Заметку") {NoteCreationView(archive).createNote()})
        for (el in archive.content)
            commands.add(Pair(el.name,goToNote(el)))
        commands.add(Pair("Выйти",exit()))
        return commands
    }
    fun exit(): () -> Unit = {this.exit = true}
    fun goToNote(note:Note): () -> Unit = {
        val noteView = NoteView(note)
        noteView.readCommand()
    }
}