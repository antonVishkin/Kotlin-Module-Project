package views.listViews

import data.ArchiveList
import data.Note
import data.NoteList
import views.creationViews.ArchiveCreationView

class NoteListView:ListView() {
    override val nameOfView = "Список заметок"

    override fun createCommands(): List<Pair<String, () -> Unit>> {
        val commands = mutableListOf<Pair<String,()->Unit>>()
        commands.add(Pair("Создать Заметку") {NoteList.list.add(Note("test"))})
        for (el in NoteList.list)
            commands.add(Pair(el.name,goToNote()))
        commands.add(Pair("Выйти",exit()))
        return commands
    }
    fun exit(): () -> Unit = {this.exit = true}
    fun goToNote() = {}
}