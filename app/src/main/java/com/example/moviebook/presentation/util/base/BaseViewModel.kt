package com.framework.desafio.android.presentation.util.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebook.presentation.util.navigation.NavData

import com.example.moviebook.presentation.util.placeholder.Placeholder
import com.example.moviebook.presentation.util.placeholder.types.Hide
import com.example.moviebook.presentation.util.placeholder.types.Loading
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    val placeholder: LiveData<Placeholder> get() = _placeholder
    val goTo: LiveData<NavData> get() = _goTo

    private val _placeholder by lazy { MutableLiveData<Placeholder>() }
    private val _goTo by lazy { MutableLiveData<NavData>() }

    protected fun setPlaceholder(placeholder: Placeholder) {
        _placeholder.postValue(placeholder)
    }

    protected fun goTo(navData: NavData) {
        _goTo.postValue(navData)
    }

    protected fun launchDataLoad(
        shouldLoad: Boolean = false,
        onFailure: (Throwable) -> Unit = {},
        block: suspend () -> Unit
    ): Job {
        return viewModelScope.launch {
            try {
                if (shouldLoad) setPlaceholder(Loading())
                block()
            } catch (error: Throwable) {
                onFailure(error)
            } finally {
                setPlaceholder(Hide())
            }
        }
    }
}