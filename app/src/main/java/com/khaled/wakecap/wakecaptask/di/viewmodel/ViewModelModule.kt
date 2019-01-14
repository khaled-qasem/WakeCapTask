package com.khaled.wakecap.wakecaptask.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khaled.wakecap.wakecaptask.ui.WorkersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(WorkersViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: WorkersViewModel): ViewModel

}
