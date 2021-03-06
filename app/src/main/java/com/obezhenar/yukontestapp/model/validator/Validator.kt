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
package com.obezhenar.yukontestapp.model.validator

/**
 * This interface defines the Validator which checks validity of specific item
 * (for example, email field)
 */
interface Validator<T> {

    /**
     * Decides whether the object valid
     * @param T - object to validate
     * @return true if the object is valid and false otherwise
     */
    fun valid(objectToValidate: T): Boolean
}