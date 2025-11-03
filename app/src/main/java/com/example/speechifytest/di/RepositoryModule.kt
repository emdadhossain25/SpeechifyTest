package com.example.speechifytest.di

import com.example.speechifytest.data.repository.IItemRespository
import com.example.speechifytest.data.repository.ItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(itemRepositoryImpl: ItemRepositoryImpl): IItemRespository

}