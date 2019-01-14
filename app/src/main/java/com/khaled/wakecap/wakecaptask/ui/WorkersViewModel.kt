package com.khaled.wakecap.wakecaptask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khaled.wakecap.wakecaptask.network.model.Worker
import com.khaled.wakecap.wakecaptask.network.model.WorkersListed
import com.khaled.wakecap.wakecaptask.repository.WorkersRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class WorkersViewModel @Inject constructor(workersRepository: WorkersRepository) :
    ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private var workers = listOf<Worker>()
    val rolesLiveData = MutableLiveData<List<String>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorLiveData = MutableLiveData<Throwable>()

    init {
        showLoading()
        workersRepository.getWorkers().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<WorkersListed>() {
                override fun onSuccess(wokersListed: WorkersListed) {
                    workers = wokersListed.workersItems.items

                    rolesLiveData.value = wokersListed.workersItems.items.map {
                        it.attributes.roleString
                    }.distinct()

                    hideLoading()
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                    errorLiveData.value = e
                    hideLoading()
                }
            })
    }

    /**
     *  clear all [Disposable]s when the [ViewModel] get destroyed, to prevent a memory leaks
     */
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun getWorkersPerRole(role: String) =
        workers.filter { it.attributes.roleString == role }

    private fun showLoading() {
        isLoading.value = true
    }

    private fun hideLoading() {
        isLoading.value = false
    }
}