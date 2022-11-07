package data

data class Archive(override var name:String):Data{
    private val content: MutableList<Note> = mutableListOf()
        get() = field
    fun addNoteToArchive(note: Note) = content.add(note)
}
