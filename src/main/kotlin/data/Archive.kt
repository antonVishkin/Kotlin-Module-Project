package data

data class Archive(override var name: String) : Data(name) {
    internal val content = NoteList()
}
