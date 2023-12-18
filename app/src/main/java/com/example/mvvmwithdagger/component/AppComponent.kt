package com.example.mvvmwithdagger.component

import com.example.mvvmwithdagger.MainActivity
import com.example.mvvmwithdagger.module.DaggerModule
import dagger.Component

// DaggerComponent.kt
@Component(modules = [DaggerModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
}
