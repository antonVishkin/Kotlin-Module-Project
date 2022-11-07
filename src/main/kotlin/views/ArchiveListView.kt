package views

import data.Archive
import data.ArchiveList

class ArchiveListView: View() {
    override val nameOfView = "Список Архивов"
    override val commands:MutableMap<String, () -> Unit>
        get() = mutableMapOf(
            Pair("Создать архив" , ArchiveCreationView().creatView),

        )
    override val creatView: () -> Unit
        get() = { ArchiveListView().readCommand() }

}