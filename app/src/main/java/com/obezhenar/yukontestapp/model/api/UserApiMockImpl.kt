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
package com.obezhenar.yukontestapp.model.api

import android.content.Context
import com.obezhenar.yukontestapp.model.api.model.AuthResponse
import com.obezhenar.yukontestapp.model.api.model.Token
import com.obezhenar.yukontestapp.model.entity.User
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.util.*

/**
 * Since the API doesn't have an authorization feature, the app uses this mock implementation
 * to emulate it's work. It returns HttpException from Retrofit2 library as an error.
 */
class UserApiMockImpl(private val context: Context) : UserApi {

    override fun basicAuth(email: String, password: String): Observable<AuthResponse> =
            Observable.fromCallable {
                Thread.sleep(1000) // add some delay
                if (email == "joe.doe@test.com"
                        && password == "12345678")
                    AuthResponse(
                            User(
                                    "Joe",
                                    "Doe",
                                    "12345678"
                            ),
                            Token(
                                    UUID.randomUUID().toString(),
                                    UUID.randomUUID().toString()
                            )
                    )
                else
                    throw HttpException(Response.error<ResponseBody>(401, ResponseBody.create(MediaType.parse("text"),
                            "Unauthorized")))
            }

    override fun refreshToken(refreshToken: String): Observable<AuthResponse> =
            Observable.fromCallable {
                Thread.sleep(1000)
                AuthResponse(
                        User(
                                "Joe",
                                "Doe",
                                "12345678"
                        ),
                        Token(
                                UUID.randomUUID().toString(),
                                UUID.randomUUID().toString()
                        )
                )
            }

    override fun registration(user: User): Observable<AuthResponse> =
            Observable.fromCallable {
                Thread.sleep(1000)
                if (user.email == "joe.doe@test.com")
                    throw HttpException(Response.error<ResponseBody>(409, ResponseBody.create(MediaType.parse("text"),
                            "Conflict")))
                AuthResponse(
                        user,
                        Token(
                                UUID.randomUUID().toString(),
                                UUID.randomUUID().toString()
                        )
                )
            }
}