/**
 * Copyright © 2017 Oleg Bezhenar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.obezhenar.yukontestapp.model.dao

import android.accounts.AccountManager
import android.content.Context
import com.obezhenar.yukontestapp.model.api.model.Token
import com.obezhenar.yukontestapp.model.entity.User
import com.obezhenar.yukontestapp.system.AppAuthenticator
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Implementation of User DAO which uses Android Authenticator as account storage.
 */

class UserDaoAuthenticatorImpl(private val context: Context) : UserDao {
    override fun getUser(): Observable<User?> =
            Observable.fromCallable { AppAuthenticator.getUserData(context) }

    override fun logIn(user: User, token: Token): Completable =
            Completable.fromAction {
                AppAuthenticator.addAccount(context, user, token)
                AppAuthenticator.updateUserData(context, AppAuthenticator.getAccount(context)!!, user)
                AppAuthenticator.updateToken(context, token)
            }

    override fun removeUser(user: User): Completable =
            Completable.create { emitter ->
                val am = AccountManager.get(context)
                am.removeAccount(AppAuthenticator.getAccount(context), {
                    emitter.onComplete()
                }, null)
            }

    override fun getToken() = Observable.fromCallable { AppAuthenticator.getToken(context) }

    override fun updateUserData(user: User, token: Token) = Completable.fromAction {
        AppAuthenticator.updateUserData(context, AppAuthenticator.getAccount(context)!!, user)
        AppAuthenticator.updateToken(context, token)
    }
}