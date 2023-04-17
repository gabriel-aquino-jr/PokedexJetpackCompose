package ca.michaelpierce.pokedex.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// Annotated as Dagger Module, and InstallIn SingletonComponent to make each
// dependency in this module a Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

}