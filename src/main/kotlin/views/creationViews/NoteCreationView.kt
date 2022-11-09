package views.creationViews

import data.NoteList

class NoteCreationView(noteList: NoteList) : CreationView(noteList) {
    override val nameOfView = "Создание заметки:"
    override fun createCommands(): List<Pair<String, () -> Unit>> {
        val commands = mutableListOf<Pair<String, () -> Unit>>()
        commands.add(Pair("Создать заметку",createInstance()))
        commands.add(Pair("Вернуться к списку", exit()))
        return commands
    }
}