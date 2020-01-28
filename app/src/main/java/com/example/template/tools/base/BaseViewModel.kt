package com.example.template.tools.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val disposable = CompositeDisposable()

    override fun onCleared() {
        if (disposable.isDisposed)
            disposable.dispose()
        super.onCleared()
    }
}