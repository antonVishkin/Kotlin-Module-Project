package views.creationViews

import data.Archive
import data.ArchiveList
import views.View
import java.util.*

class ArchiveCreationView : View(){
    override val nameOfView = "Создание архива:"
    fun createArchive(){
        println(nameOfView)
        println("Введите имя архива")
        val name = Scanner(System.`in`).nextLine()
        ArchiveList.list.add(Archive(name))
    }
}