package com.example.movieapp

import android.app.Application
import androidx.room.Room
import com.example.movieapp.data_source.MovieRoomDataBase
import com.example.movieapp.di.components.ViewModelComponent
import com.example.movieapp.di.modules.*
import com.example.movieapp.di.components.*

class MovieApp : Application() {

    private lateinit var viewModelComponent: ViewModelComponent
    private lateinit var database: MovieRoomDataBase


    override fun onCreate() {
        super.onCreate()
        initRoom()
        initDagger()
    }

    private fun initRoom() {
        database = Room.databaseBuilder(this, MovieRoomDataBase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

    private fun initDagger() {
        val appComponent = DaggerComponents.builder()
            .appModule(AppModule(this))
            .build()

        val remoteDataSourceComponent = DaggerRemoteDataComponent.builder()
            .appComponent(appComponent)
            .remoteDataModule(RemoteDataSourceModule())
            .build()

        val databaseComponent = DaggerDataComponent.builder()
            .dataModule(DataBaseModule(database))
            .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
            .remoteDataComponent(remoteDataSourceComponent)
            .dataComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        val useCaseComponent = DaggerUseCaseComponent.builder()
            .repositoryComponent(repositoryComponent)
            .useCaseModule(UseCaseModule())
            .build()

        viewModelComponent = DaggerViewModelComponent.builder()
            .useCaseComponent(useCaseComponent)
            .viewModelModule(ViewModelModule(this))
            .build()
    }

    fun getViewModelComponent(): ViewModelComponent {
        return this.viewModelComponent
    }
}
