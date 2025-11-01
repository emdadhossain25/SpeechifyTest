package com.example.speechifytest.di

import com.example.speechifytest.data.repository.ExpenseRepositoryImpl
import com.example.speechifytest.data.repository.IExpenseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindsExpenseRepository(expenseRepositoryImpl: ExpenseRepositoryImpl): IExpenseRepository
}