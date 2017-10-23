/**
 * Copyright © 2017 Oleg Bezhenar
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.obezhenar.yukontestapp.system

import android.accounts.AbstractAccountAuthenticator
import android.accounts.Account
import android.accounts.AccountAuthenticatorResponse
import android.accounts.AccountManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import com.obezhenar.yukontestapp.R
import com.obezhenar.yukontestapp.model.api.UserApi
import com.obezhenar.yukontestapp.model.api.model.AuthResponse
import com.obezhenar.yukontestapp.model.api.model.Token
import com.obezhenar.yukontestapp.model.entity.User
import com.obezhenar.yukontestapp.view.ui.activity.AuthenticationActivity
import javax.inject.Inject

/**
 * Android Account Authenticator partial implementation.
 */
class AppAuthenticator(private val context: Context)
    : AbstractAccountAuthenticator(context) {

    @Inject
    lateinit var userApi: UserApi

    override fun getAuthTokenLabel(authTokenType: String?): String? = null

    override fun confirmCredentials(response: AccountAuthenticatorResponse?, account: Account?, options: Bundle?): Bundle? = null

    override fun updateCredentials(response: AccountAuthenticatorResponse?, account: Account?, authTokenType: String?, options: Bundle?): Bundle {
        val result = Bundle()
        val intent = Intent(context, AuthenticationActivity::class.java)
        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response)
        intent.putExtra(AccountManager.KEY_ACCOUNT_TYPE, ACCOUNT_TYPE)
        intent.putExtra(AccountManager.KEY_ACCOUNT_NAME, account?.name)
        result.putParcelable(AccountManager.KEY_INTENT, intent)
        return result
    }

    override fun getAuthToken(response: AccountAuthenticatorResponse?, account: Account?, authTokenType: String?, options: Bundle?): Bundle? {
        val am = AccountManager.get(context)

        var authToken = am.peekAuthToken(account, ACCOUNT_TYPE)

        //attempt to refresh the token
        if (TextUtils.isEmpty(authToken)) {
            val refreshToken = am.getUserData(account, KEY_REFRESH_TOKEN)
            if (refreshToken != null && !refreshToken.isEmpty()) {
                val authResponse = refreshAuthToken(refreshToken)
                if (authResponse != null) {
                    authToken = authResponse.token.accessToken
                    am.setUserData(account, KEY_REFRESH_TOKEN, authResponse.token.refreshToken)
                    updateUserData(context, account!!, authResponse.user)
                }
            }
        }

        //attempt to relogin
        if (TextUtils.isEmpty(authToken)) {
            val password = am.getPassword(account)
            if (password != null) {
                val authResponse = signIn(account!!.name, password)
                if (authResponse != null) {
                    authToken = authResponse.token.accessToken
                    am.setUserData(account, KEY_REFRESH_TOKEN, authResponse.token.refreshToken)
                    updateUserData(context, account!!, authResponse.user)
                }
            }
        }

        if (!TextUtils.isEmpty(authToken)) {
            val result = Bundle()
            result.putString(AccountManager.KEY_ACCOUNT_NAME, account?.name)
            result.putString(AccountManager.KEY_ACCOUNT_TYPE, ACCOUNT_TYPE)
            result.putString(AccountManager.KEY_AUTHTOKEN, authToken)
            return result
        }

        val intent = Intent(context, AuthenticationActivity::class.java)
        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response)
        intent.putExtra(AuthenticationActivity.ARG_ACCOUNT_TYPE, ACCOUNT_TYPE)
        intent.putExtra(AuthenticationActivity.ARG_AUTH_TYPE, ACCOUNT_TOKEN_TYPE)
        val bundle = Bundle()
        bundle.putParcelable(AccountManager.KEY_INTENT, intent)
        return bundle
    }

    private fun signIn(email: String, password: String): AuthResponse? = userApi
            .basicAuth(email, password).blockingFirst()

    private fun refreshAuthToken(refreshToken: String): AuthResponse? = userApi
            .refreshToken(refreshToken).blockingFirst()

    override fun hasFeatures(response: AccountAuthenticatorResponse?, account: Account?, features: Array<out String>?): Bundle? = null

    override fun editProperties(response: AccountAuthenticatorResponse?, accountType: String?): Bundle? = null

    override fun addAccount(response: AccountAuthenticatorResponse?, accountType: String?, authTokenType: String?, requiredFeatures: Array<out String>?, options: Bundle?): Bundle {
        val intent = Intent(context, AuthenticationActivity::class.java)
        intent.putExtra(AuthenticationActivity.ARG_ACCOUNT_TYPE, ACCOUNT_TYPE)
        intent.putExtra(AuthenticationActivity.ARG_AUTH_TYPE, ACCOUNT_TOKEN_TYPE)
        intent.putExtra(AuthenticationActivity.ARG_IS_ADDING_NEW_ACCOUNT, true)
        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response)
        val bundle = Bundle()
        bundle.putParcelable(AccountManager.KEY_INTENT, intent)
        return bundle
    }

    companion object {
        private val KEY_NAME = "username"
        private val KEY_EMAIL = "email"
        private val KEY_REFRESH_TOKEN = "refresh_token"
        val ACCOUNT_TYPE = "com.obezhenar.lcbotest.account"
        val ACCOUNT_TOKEN_TYPE = "com.obezhenar.lcbotest.token"

        fun getAccount(context: Context): Account? {
            val am = AccountManager.get(context)
            if (am.accounts.isEmpty())
                return null
            return am.accounts[am.accounts.size - 1]
        }

        fun updateUserData(context: Context, account: Account, user: User) {
            val am = AccountManager.get(context)
            am.setUserData(account, KEY_NAME, user.name)
            am.setUserData(account, KEY_EMAIL, user.email)
        }

        fun updateToken(context: Context, token: Token) {
            val am = AccountManager.get(context)
            val account = getAccount(context)
            am.setAuthToken(account, ACCOUNT_TOKEN_TYPE, token.accessToken)
            am.setUserData(account, KEY_REFRESH_TOKEN, token.refreshToken)
        }

        fun getUserData(context: Context): User {
            val am = AccountManager.get(context)
            val account = getAccount(context)
            return User(
                    name = am.getUserData(account, KEY_NAME),
                    email = am.getUserData(account, KEY_EMAIL),
                    password = am.getPassword(account)
            )
        }

        fun getUserData(user: User, refreshToken: String): Bundle {
            val data = Bundle()
            data.putString(KEY_NAME, user.name)
            data.putString(KEY_EMAIL, user.email)
            data.putString(KEY_REFRESH_TOKEN, refreshToken)
            return data
        }

        fun getToken(context: Context): Token {
            val am = AccountManager.get(context)
            return Token(
                    am.peekAuthToken(getAccount(context), ACCOUNT_TOKEN_TYPE),
                    am.getUserData(getAccount(context), KEY_REFRESH_TOKEN)
            )
        }

        fun addAccount(context: Context, user: User, token: Token) {
            val am = AccountManager.get(context)
            val account = Account(user.email, ACCOUNT_TYPE)
            am.addAccountExplicitly(account, user.password,
                    AppAuthenticator.getUserData(user, token.refreshToken))
            am.setAuthToken(account, ACCOUNT_TOKEN_TYPE, token.accessToken)
        }
    }
}
