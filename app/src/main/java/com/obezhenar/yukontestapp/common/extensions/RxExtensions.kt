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

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by 1 on 10/20/2017.
 */
fun <T> Observable<T>.observeOnMainThread() = observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.observeOnMainThread() = observeOn(AndroidSchedulers.mainThread())

fun <T> Maybe<T>.observeOnMainThread() = observeOn(AndroidSchedulers.mainThread())

fun Completable.observeOnMainThread() = observeOn(AndroidSchedulers.mainThread())