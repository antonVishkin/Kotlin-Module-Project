package views.creationViews

import data.ArchiveList

class ArchiveCreationView : CreationView(ArchiveList) {
    override val nameOfView = "Создание архива:"
    override fun createCommands(): List<Pair<String, () -> Unit>> {
        val commands = mutableListOf<Pair<String, () -> Unit>>()
        commands.add(Pair("Создать архив",createInstance()))
        commands.add(Pair("Вернуться к списку", exit()))
        return commands
    }
}