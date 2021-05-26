package com.example.movieapp.di.modules

import com.example.movieapp.di.scopes.RemoteDataSourceScope
import com.example.movieapp.remote_data_source.MovieApi
import com.example.movieapp.remote_data_source.RemoteDataSource
import com.example.movieapp.remote_data_source.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class RemoteDataSourceModule {
    companion object {
        val API_URL = "https://api.themoviedb.org/3/"
    }

    @RemoteDataSourceScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        var httpsClient = OkHttpClient.Builder()
            .connectionPool(ConnectionPool(5, 30, TimeUnit.SECONDS))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        return httpsClient.build()
    }

    @Provides
    @RemoteDataSourceScope
    fun provideRetrofitBuilder(client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    }

    @Provides
    @RemoteDataSourceScope
    fun providesRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(API_URL).build()
    }

    @Provides
    @RemoteDataSourceScope
    fun provideApiService(retrofit: Retrofit): MovieApi {
        return retrofit.create<MovieApi>(
            MovieApi::class.java
        )
    }


    @Provides
    @RemoteDataSourceScope
    fun providesFeedRemoteDataSource(apiService: MovieApi): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }

}