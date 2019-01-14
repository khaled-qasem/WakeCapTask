package com.khaled.wakecap.wakecaptask.di

import com.khaled.wakecap.wakecaptask.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity
}
