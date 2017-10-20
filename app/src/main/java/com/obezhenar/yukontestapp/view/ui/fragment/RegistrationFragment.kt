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
import com.obezhenar.yukontestapp.model.entity.User
import com.obezhenar.yukontestapp.presenter.RegistrationPresenter
import com.obezhenar.yukontestapp.view.RegistrationView
import com.obezhenar.yukontestapp.view.ui.activity.SplashScreenActivity
import kotlinx.android.synthetic.main.fragment_registration.*

/**
 * Implements Registration screen behaviour.
 */
class RegistrationFragment : MvpAppCompatFragment(), RegistrationView {
    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_registration, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edName.doOnTextChanged { updateRegisterButtonState() }
        edEmail.doOnTextChanged { updateRegisterButtonState() }
        edPassword.doOnTextChanged { updateRegisterButtonState() }
        edConfirmPassword.doOnTextChanged { updateRegisterButtonState() }

        btnCreateAccount.doOnClick {
            if (edPassword.textString() == edConfirmPassword.textString())
                presenter.registerUser(User(
                        edName.textString(),
                        edEmail.textString(),
                        edPassword.textString()
                ))
            else
                edConfirmPassword.error = getString(R.string.error_password_dont_match)
        }

        btnLogin.doOnClick {
            fragmentManager.beginTransaction()
                    .replace(R.id.vContent, LogInFragment())
                    .commit()
        }
    }

    private fun updateRegisterButtonState() {
        btnCreateAccount.isEnabled = edName.isNotBlank()
                && edEmail.isNotBlank()
                && edPassword.isNotBlank()
                && edConfirmPassword.isNotBlank()
    }

    override fun displayProgress(display: Boolean) {
        progress.setVisible(display)
        btnCreateAccount.setVisible(!display)
        tvLogInHint.setVisible(!display)
        btnLogin.setVisible(!display)
        edName.isEnabled = !display
        edEmail.isEnabled = !display
        edPassword.isEnabled = !display
        edConfirmPassword.isEnabled = !display
    }

    override fun onInvalidEmailError() {
        edEmail.error = getString(R.string.error_invalid_email)
    }

    override fun onNetworkError() {
        activity.showAlert("Oops!", "An error occurred while creating new account")
    }

    override fun onSuccess() {
        activity.startActivity(SplashScreenActivity::class)
        activity.finish()
    }

    override fun onUserExistsError() {
        activity.showAlert("Oops!", "User with this email already exists")
    }
}