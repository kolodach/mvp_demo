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
package com.obezhenar.yukontestapp.model.repository

import com.obezhenar.yukontestapp.model.api.UserApi
import com.obezhenar.yukontestapp.model.dao.UserDao
import com.obezhenar.yukontestapp.model.entity.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * User repository implementation
 */
class UserRepositoryImpl(
        private val userDao: UserDao,
        private val userApi: UserApi
) : UserRepository {

    override fun removeUser() =
            getUser().flatMapCompletable {
                userDao.removeUser(it)
                        .subscribeOn(Schedulers.io())
            }

    override fun getUser(): Observable<User?> = userDao.getUser()

    override fun basicAuth(email: String, password: String) = userApi
            .basicAuth(email, password)
            .flatMapCompletable {
                userDao.logIn(it.user, it.token)
                        .subscribeOn(Schedulers.io())
            }

    override fun refreshToken(): Completable =
            userDao.getToken()
                    .flatMapCompletable {
                        userApi.refreshToken(it.refreshToken)
                                .subscribeOn(Schedulers.io())
                                .flatMapCompletable {
                                    userDao.updateUserData(
                                            it.user, it.token
                                    )
                                }
                    }

    override fun createAccount(user: User): Completable =
            userApi.registration(user)
                    .flatMapCompletable {
                        userDao.logIn(it.user, it.token)
                                .subscribeOn(Schedulers.io())
                    }
}