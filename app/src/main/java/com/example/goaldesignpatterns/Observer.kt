package com.example.goaldesignpatterns

import kotlin.properties.Delegates

interface TextChangedListener {
    fun onTextChanged(oldText: String, newText: String)
}

class PrintingTextChangedListener : TextChangedListener {

    private var text = ""

    override fun onTextChanged(oldText: String, newText: String) {
        text = "Text is changed: $oldText -> $newText"
    }
}

class TextView {

    private val listeners = mutableListOf<TextChangedListener>()

    fun addListeners(listener: TextChangedListener) {
        listeners.add(listener)
    }

    var text: String by Delegates.observable("<empty>") { _, old, new ->
        listeners.forEach { it.onTextChanged(old, new) }
    }
}
