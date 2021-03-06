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
package com.obezhenar.yukontestapp.common.di

import android.content.Context
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.obezhenar.yukontestapp.BuildConfig
import com.obezhenar.yukontestapp.model.api.ProductApi
import com.obezhenar.yukontestapp.model.api.StoreApi
import com.obezhenar.yukontestapp.model.api.UserApi
import com.obezhenar.yukontestapp.model.api.UserApiMockImpl
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dagger 2 module.Provides API interfaces implementations.
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideUserApi(context: Context): UserApi = UserApiMockImpl(context)

    @Provides
    @Singleton
    fun provideStoreApi(retrofit: Retrofit): StoreApi = retrofit.create(StoreApi::class.java)

    @Provides
    @Singleton
    fun provideProductsApi(retrofit: Retrofit): ProductApi = retrofit.create(ProductApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://lcboapi.com/")
            .client(OkHttpClient.Builder()
                    .addInterceptor {
                        it.proceed(it.request().newBuilder()
                                .addHeader("Authorization", "Token ${BuildConfig.API_KEY}")
                                .build())
                    }
                    .addInterceptor(LoggingInterceptor.Builder()
                            .loggable(BuildConfig.DEBUG)
                            .setLevel(Level.BASIC)
                            .log(Platform.INFO)
                            .request("Request")
                            .response("Response")
                            .build())
                    .build())
            .build()
}