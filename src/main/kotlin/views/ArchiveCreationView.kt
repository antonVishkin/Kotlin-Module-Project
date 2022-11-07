package views

import data.Archive

class ArchiveCreationView :View(){
    override val nameOfView = "Создание архива"
    override val commands: Map<String, () -> Unit>
        get() = TODO("Not yet implemented")
    override val creatView: () -> Unit
        get() = { ArchiveListView().readCommand() }
}