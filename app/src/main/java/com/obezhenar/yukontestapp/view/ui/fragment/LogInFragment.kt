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
package com.obezhenar.yukontestapp.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.obezhenar.yukontestapp.R
import com.obezhenar.yukontestapp.common.extensions.*
import com.obezhenar.yukontestapp.presenter.LogInPresenter
import com.obezhenar.yukontestapp.view.LogInView
import com.obezhenar.yukontestapp.view.ui.activity.SplashScreenActivity
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Implements log in screen behaviour.
 */
class LogInFragment : MvpAppCompatFragment(), LogInView {
    @InjectPresenter
    lateinit var loginPresenter: LogInPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edEmail.doOnTextChanged { updateButtonState() }
        edPassword.doOnTextChanged { updateButtonState() }
        btnLogin.doOnClick {
            loginPresenter.logIn(edEmail.textString(), edPassword.textString())
        }
        btnRegistration.doOnClick {
            fragmentManager.beginTransaction()
                    .replace(R.id.vContent, RegistrationFragment())
                    .commit()
        }
    }

    private fun updateButtonState() {
        btnLogin.isEnabled = edEmail.isNotBlank() && edPassword.isNotBlank()
    }

    override fun setDisplayProgress(display: Boolean) {
        edEmail.isEnabled = !display
        edPassword.isEnabled = !display
        btnLogin.setVisible(!display)
        btnRegistration.setVisible(!display)
        progress.setVisible(display)
    }

    override fun invalidCredentialsError() {
        activity.showAlert(
                title = "Oops!",
                message = "It seems like the credentials are invalid. Please check them again"
        )
    }

    override fun onNetworkError() {
        activity.showAlert(
                title = "Oops!",
                message = "The network is not available at the moment"
        )
    }

    override fun onLogInSuccess() {
        activity.startActivity(SplashScreenActivity::class)
        activity.finish()
    }

    override fun onInvalidEmailFormat() {
        edEmail.error = "Invalid email format"
    }
}