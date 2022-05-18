package com.example.moviebook.presentation.util.placeholder.types

import com.example.moviebook.presentation.util.placeholder.Placeholder

class Hide : Placeholder {
    override val progressVisible: Boolean get() = false
    override val visible: Boolean get() = false
}