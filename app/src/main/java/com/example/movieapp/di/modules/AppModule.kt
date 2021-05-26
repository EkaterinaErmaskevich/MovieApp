package com.example.movieapp.di.modules

import android.app.Application
import com.example.movieapp.di.scopes.AppScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides


@Module
class AppModule(private val mApp: Application) {

    @Provides
    @AppScope
    fun provideApplication(): Application {
        return mApp
    }

    @Provides
    @AppScope
    fun provideGson(): Gson {
        return Gson()
    }
}