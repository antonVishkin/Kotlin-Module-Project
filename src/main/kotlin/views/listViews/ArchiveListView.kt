package views.listViews

import data.Archive
import data.ArchiveList
import views.creationViews.ArchiveCreationView

class ArchiveListView: ListView() {
    override val nameOfView = "Список Архивов"
    override fun createCommands(): List<Pair<String,()->Unit>> {
        val commands = mutableListOf<Pair<String,()->Unit>>()
        commands.add(Pair("Создать Архив") { ArchiveCreationView().createArchive() })
        for (el in ArchiveList.list)
            commands.add(Pair(el.name,goToArchive(el as Archive)))
        commands.add(Pair("Выйти",exit()))
        return commands
    }
    fun goToArchive(archive: Archive): () -> Unit = {
        val noteListView = NoteListView(archive)
        noteListView.readCommand()
    }
    fun exit(): () -> Unit = {this.exit = true}

}