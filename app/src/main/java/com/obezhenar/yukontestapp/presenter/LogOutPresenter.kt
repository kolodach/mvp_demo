package com.obezhenar.yukontestapp.presenter

import com.arellomobile.mvp.InjectViewState
import com.obezhenar.yukontestapp.common.RxMvpPresenter
import com.obezhenar.yukontestapp.common.di.AppInjector
import com.obezhenar.yukontestapp.common.extensions.observeOnMainThread
import com.obezhenar.yukontestapp.model.intecactor.LogOutInteractor
import com.obezhenar.yukontestapp.view.LogOutView
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Mvp presenter. Defines and implements operations available for Log out view.
 */
@InjectViewState
class LogOutPresenter : RxMvpPresenter<LogOutView>() {
    @Inject
    lateinit var logOutInteractor: LogOutInteractor

    init {
        AppInjector.inject(this)
    }

    fun logOut() {
        addDisposable(logOutInteractor.logOut()
                .subscribeOn(Schedulers.io())
                .observeOnMainThread()
                .subscribe({
                    viewState.onLogOutDone()
                }, {
                    it.printStackTrace()
                    viewState.onLogOutDone()
                }))
    }
}