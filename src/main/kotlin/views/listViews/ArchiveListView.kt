package views.listViews

import data.ArchiveList

class ArchiveListView : ListView(ArchiveList) {
    override val nameOfView = "Список Архивов"
    override val createElementText = "Создать Архив"
}