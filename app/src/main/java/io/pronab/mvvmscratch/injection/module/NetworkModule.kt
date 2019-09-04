package io.pronab.mvvmscratch.injection.module

import dagger.Module
import dagger.Provides
import io.pronab.mvvmscratch.model.Businesses
import io.pronab.mvvmscratch.network.BusinessApi
import io.pronab.mvvmscratch.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Module which provides all required dependencies about network
 */
@Module

@Suppress("unused")
object NetworkModule {
    /**
     * Provides the Business service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Business service implementation.
     */


    @Provides
    fun provideBusinesstApi(retrofit: Retrofit): Call<Businesses> {
        return retrofit.create(BusinessApi::class.java)
            .getBusiness()
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object ,client intercepted
     */
    @Provides

    internal fun provideRetrofitInterface(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()



        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }
}