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
package com.obezhenar.yukontestapp.view.ui.activity

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.obezhenar.yukontestapp.R
import com.obezhenar.yukontestapp.view.ui.fragment.LogInFragment

/**
 * Authentication screen activity
 */
class AuthenticationActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)

        supportFragmentManager.beginTransaction()
                .add(R.id.vContent, LogInFragment())
                .commit()
    }

    companion object {
        val ARG_ACCOUNT_TYPE = "ARG_ACCOUNT_TYPE"
        val ARG_AUTH_TYPE = "ARG_AUTH_TYPE"
        val ARG_IS_ADDING_NEW_ACCOUNT = "ARG_IS_ADDING_NEW_ACCOUNT"
    }
}