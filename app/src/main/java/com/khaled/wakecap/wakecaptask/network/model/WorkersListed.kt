package com.khaled.wakecap.wakecaptask.network.model

import com.google.gson.annotations.SerializedName

data class WorkersListed(
    @SerializedName("data")
    val workersItems: WorkersItems,
    @SerializedName("message")
    val message: String
)