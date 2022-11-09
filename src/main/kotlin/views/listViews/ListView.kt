package views.listViews

import data.*
import views.NoteView
import views.View
import views.creationViews.ArchiveCreationView
import views.creationViews.NoteCreationView

abstract class ListView(private val list: ListOfData) : View() {
    override var exit = false
    abstract val createElementText: String
    override fun createCommands(): List<Pair<String, () -> Unit>> {
        val commands = mutableListOf<Pair<String, () -> Unit>>()
        commands.add(Pair(createElementText, creationView()))
        for (el in list.list)
            commands.add(Pair(el.name, goInto(el)))
        commands.add(Pair("Выйти", exit()))
        return commands

    }

    private fun goInto(data: Data): () -> Unit = {
        val view = when (data) {
            is Archive -> {
                NoteListView(data)
            }
            is Note -> {
                NoteView(data)
            }
        }
        view.readCommand()
    }

    private fun creationView(): () -> Unit = {
        val creationVew = when (list) {
            is ArchiveList -> {
                ArchiveCreationView()
            }
            is NoteList -> {
                NoteCreationView(list)
            }
        }
        creationVew.readCommand()
    }
}