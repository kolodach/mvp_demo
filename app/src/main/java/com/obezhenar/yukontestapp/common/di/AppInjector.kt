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
package com.obezhenar.yukontestapp.common.di

import com.obezhenar.yukontestapp.App
import com.obezhenar.yukontestapp.common.extensions.typeOf

/**
 *  Application injector. This class resolves all application dependencies delegating
 *  them to the appropriate Dagger2 component. This implementation uses reflection
 *  to analyze component methods. Also, this application uses a convention of component's
 *  injection method naming. The injection method should be named "inject", otherwise
 *  it won't be invoked.
 */
class AppInjector {
    companion object {
        private val appComponent: AppComponent by lazy {
            DaggerAppComponent.builder()
                    .appModule(AppModule(App.instance))
                    .domainModule(DomainModule())
                    .apiModule(ApiModule())
                    .daoModule(DaoModule())
                    .build()
        }

        /**
         * This method resolves incoming injection looking for the "inject" method
         * with appropriate param type using reflection and invokes it. If method doesn't
         * found then it throws an IllegalArgumentException
         *
         * @param injection - Incoming injection
         * @throws IllegalArgumentException - when injection can't be resolved
         */
        fun inject(injection: Any) {
            var resolved = false
            appComponent::class.members
                    .forEach { member ->
                        if (member.name == "inject")
                            member.parameters.forEach { param ->
                                if (injection typeOf param.type) {
                                    member.call(appComponent, injection)
                                    resolved = true
                                }
                            }
                    }
            if (!resolved)
                throw IllegalArgumentException("The injection ${injection.javaClass.name} can not be resolved. Please make sure you define it in your Dagger component.")
        }
    }
}
