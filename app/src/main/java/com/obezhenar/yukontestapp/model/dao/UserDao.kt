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

import com.obezhenar.yukontestapp.model.api.model.Token
import com.obezhenar.yukontestapp.model.entity.User
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * User Data Access Object. Defines operations on local User objects.
 */
interface UserDao {
    fun getUser(): Observable<User?>

    fun getToken() : Observable<Token?>

    fun updateUserData(user : User, token : Token) : Completable

    fun logIn(user : User, token: Token) : Completable

    fun removeUser(user: User): Completable
}