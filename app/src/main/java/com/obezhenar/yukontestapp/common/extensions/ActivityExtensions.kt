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
package com.obezhenar.yukontestapp.common.extensions

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AlertDialog
import kotlin.reflect.KClass

/**
 * Displays simple Alert dialog with specified title and message
 */
fun Activity.showAlert(
        title: String?,
        message: String?
) = AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(android.R.string.ok, { dialog, which ->
        }).show()

fun Activity.startActivity(clazz: KClass<out Activity>) {
    startActivity(Intent(this, clazz.java))
}


