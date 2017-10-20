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
package com.obezhenar.yukontestapp.view

import com.arellomobile.mvp.MvpView

/**
 * MVP View interface. Defines the behaviour of Log In screen.
 */
interface LogInView : MvpView {

    fun setDisplayProgress(display: Boolean)

    fun invalidCredentialsError()

    fun onInvalidEmailFormat()

    fun onNetworkError()

    fun onLogInSuccess()
}