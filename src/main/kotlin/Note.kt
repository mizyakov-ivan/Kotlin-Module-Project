fun viewNotesMenu() {
    selectAction(
        "Список заметок для $currentArchive",
        listOf("Создать заметку", "Выбрать заметку"),
        ::onNotesMenuAction
    )
}

fun onNotesMenuAction(action: Int) {
    when (action) {
        0 -> addNote()
        1 -> nameNotes[currentArchive]?.let { viewNotes(it) }
    }
}

fun addNote() {
    val noteName = getNewItem("Введите имя заметки:")
    val noteContent = getNewItem("Введите содержание заметки:")
    nameNotes[currentArchive]?.add("$noteName\n$noteContent")
    println("Заметка записана.\n")
}

fun viewNotes(notes: MutableList<String>) {
    if (notes.isEmpty()) println("Ещё не введено ни одной заметки.\n")
    else {
        selectAction(
            caption = "Выберите заметку",
            notes.map { it.substringBefore("\n") },
            ::onNotesListMenuAction
        )
    }
}

fun onNotesListMenuAction(action: Int) {
    val selectedNote = nameNotes[currentArchive]?.get(action)
    println("Заметка из архива $currentArchive:")
    selectedNote?.let {
        val noteParts = it.split("\n")
        println("Имя заметки: ${noteParts[0]}")
        println("Содержание заметки:")
        println(noteParts[1])
        println("*****")
        getNewItem("Для перехода на список заметок, введите любой символ.")
    }
}