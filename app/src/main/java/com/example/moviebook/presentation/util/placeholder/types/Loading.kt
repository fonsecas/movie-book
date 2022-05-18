package com.example.moviebook.presentation.util.placeholder.types

import com.example.moviebook.presentation.util.placeholder.Placeholder

class Loading : Placeholder {
    override val progressVisible: Boolean get() = true
    override val visible: Boolean get() = true
}