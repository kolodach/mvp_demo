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
package com.obezhenar.yukontestapp.common

import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors

/**
 * Created by 1 on 10/20/2017.
 */
class AppSchedulers {
    companion object {
        val database by lazy { Schedulers.from(Executors.newSingleThreadExecutor()) }

        val single by lazy { Schedulers.from(Executors.newSingleThreadExecutor()) }
    }
}