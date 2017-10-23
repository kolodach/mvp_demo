package com.obezhenar.yukontestapp.model.intecactor

import com.obezhenar.yukontestapp.common.AppSchedulers
import com.obezhenar.yukontestapp.model.repository.ProductRepository
import com.obezhenar.yukontestapp.model.repository.StoreRepository
import com.obezhenar.yukontestapp.model.repository.UserRepository
import io.reactivex.Completable

/**
 * Created by kolod on 21.10.2017.
 */
class LogOutInteractorImpl(
        private val userRepository: UserRepository,
        private val storeRepository: StoreRepository,
        private val productRepository: ProductRepository
) : LogOutInteractor {

    override fun logOut(): Completable =
            userRepository.removeUser()
                    .subscribeOn(AppSchedulers.database)
                    .andThen(storeRepository.removeAll())
                    .andThen(productRepository.removeAll())
}