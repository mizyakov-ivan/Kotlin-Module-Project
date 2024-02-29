fun archivesMenu() {
    selectAction(
        "Список архивов",
        listOf("Создать архив", "Выбрать архив"),
        ::getMenuArchive
    )
}

fun getMenuArchive(action: Int) {
    when (action) {
        0 -> addArchive()
        1 -> selectArchive()
    }
}

fun addArchive() {
    val archiveName: String = getNewItem("Введите название архива:")
    val archiveNotes: MutableList<String> = mutableListOf()
    nameNotes[archiveName] = archiveNotes
    println("Архив $archiveName записан.\n")
}

fun selectArchive() {
    selectAction("Выберите архив", nameNotes.keys.toList(), ::ArchivesListMenu)
}

fun ArchivesListMenu(action: Int) {
    currentArchive = nameNotes.keys.toList()[action]
    viewNotesMenu()
}