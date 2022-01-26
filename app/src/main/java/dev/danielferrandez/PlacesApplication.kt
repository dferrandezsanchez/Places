package dev.danielferrandez

import android.app.Application
import dev.danielferrandez.places.di.repositoryModule
import dev.danielferrandez.places.di.useCaseModule
import dev.danielferrandez.places.di.dataSourceModule
import dev.danielferrandez.places.di.placesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class PlacesApplication : Application() {

    val modules: List<Module> = listOf(
        placesModule,
        useCaseModule,
        repositoryModule,
        dataSourceModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PlacesApplication)
            modules(modules)
        }
    }
}