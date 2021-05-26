package com.example.movieapp.di.components

import com.example.movieapp.di.modules.AppModule
import com.example.movieapp.di.scopes.AppScope
import com.google.gson.Gson
import dagger.Component


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    val gson: Gson
}