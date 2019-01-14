package com.khaled.wakecap.wakecaptask.network

import com.khaled.wakecap.wakecaptask.network.model.WorkersListed
import io.reactivex.Single
import retrofit2.http.GET


interface ApiServices {
    @GET("api/sites/10010001/workers")
    fun getWorkersData(): Single<WorkersListed>
}