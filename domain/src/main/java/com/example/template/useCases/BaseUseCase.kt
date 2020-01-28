package com.example.template.useCases

import io.reactivex.disposables.CompositeDisposable

internal abstract class BaseUseCase {
    protected val disposable = CompositeDisposable()

    fun onCleared() {
        if (disposable.isDisposed)
            disposable.dispose()
    }
}