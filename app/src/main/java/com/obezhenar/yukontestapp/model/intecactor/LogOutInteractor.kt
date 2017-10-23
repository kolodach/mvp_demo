package com.obezhenar.yukontestapp.model.intecactor

import io.reactivex.Completable

/**
 * Contains all logic, related with log out feature
 */
interface LogOutInteractor {
    fun logOut(): Completable
}