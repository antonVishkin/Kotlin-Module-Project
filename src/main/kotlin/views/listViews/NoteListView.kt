package views.listViews

import data.Archive

class NoteListView(archive: Archive) : ListView(archive.content) {
    override val nameOfView = "Список заметок"
    override val createElementText = "Создать заметку"
}