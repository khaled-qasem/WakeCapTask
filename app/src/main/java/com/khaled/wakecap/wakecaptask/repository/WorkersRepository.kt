package com.khaled.wakecap.wakecaptask.repository

import com.khaled.wakecap.wakecaptask.network.ApiServices
import javax.inject.Inject

class WorkersRepository @Inject constructor(
    private val apiServices: ApiServices
) {
    fun getWorkers() =
        apiServices.getWorkersData()
}