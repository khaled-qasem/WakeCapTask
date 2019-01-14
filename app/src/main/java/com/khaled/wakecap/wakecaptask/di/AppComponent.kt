package com.khaled.wakecap.wakecaptask.di

import android.app.Application
import com.khaled.wakecap.wakecaptask.WakeCapApplication
import com.khaled.wakecap.wakecaptask.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        MainActivityModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(wakeCapApplication: WakeCapApplication)

}
