package com.example.mvvmwithdagger.module

import com.example.mvvmwithdagger.model.MyViewModel
import com.example.mvvmwithdagger.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DaggerModule {

    @Provides
    fun provideRepository(): MyRepository {
        return MyRepository()
    }

    @Provides
    fun provideViewModel(repository: MyRepository): MyViewModel {
        return MyViewModel(repository)
    }
}
