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
package com.obezhenar.yukontestapp.common.extensions

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView

/**
 * Created by 1 on 10/18/2017.
 */
fun View.doOnClick(body: (View) -> Unit) {
    setOnClickListener(body)
}

fun View.setVisible(boolean: Boolean) {
    if (boolean)
        visibility = View.VISIBLE
    else
        visibility = View.GONE
}

fun TextView.doOnTextChanged(body: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            body.invoke(s.toString())
        }
    })
}

fun TextView.isBlank(): Boolean = text.toString().isBlank()

fun TextView.isNotBlank(): Boolean = text.toString().isNotBlank()

fun TextView.textString(): String = text.toString()