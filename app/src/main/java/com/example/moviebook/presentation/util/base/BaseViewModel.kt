package com.framework.desafio.android.presentation.util.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebook.presentation.util.dialog.DialogData
import com.example.moviebook.presentation.util.error.ErrorHandler
import com.example.moviebook.presentation.util.navigation.NavData

import com.example.moviebook.presentation.util.placeholder.Placeholder
import com.example.moviebook.presentation.util.placeholder.types.Hide
import com.example.moviebook.presentation.util.placeholder.types.Loading
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseViewModel : ViewModel(), KoinComponent {

    private val errorHandler: ErrorHandler by inject()

    val placeholder: LiveData<Placeholder> get() = _placeholder
    val goTo: LiveData<NavData> get() = _goTo
    val dialog: LiveData<DialogData> get() = _dialog

    private val _placeholder by lazy { MutableLiveData<Placeholder>() }
    private val _goTo by lazy { MutableLiveData<NavData>() }
    private val _dialog by lazy { MutableLiveData<DialogData>() }

    protected fun setPlaceholder(placeholder: Placeholder) {
        _placeholder.postValue(placeholder)
    }

    protected fun setDialog(dialogData: DialogData?) {
        _dialog.postValue(dialogData)
    }

    protected fun setDialog(
        throwable: Throwable,
        retryAction: (() -> Unit)
    ) {
        setDialog(errorHandler.getDialogData(throwable, retryAction))
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