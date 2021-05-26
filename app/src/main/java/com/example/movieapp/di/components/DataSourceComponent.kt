package com.example.movieapp.di.components

import com.example.movieapp.data_source.DataSource
import com.example.movieapp.di.modules.DataBaseModule
import dagger.Component


@Component(modules = [DataBaseModule::class])
interface DataSourceComponent {
    val dataSource: DataSource
}