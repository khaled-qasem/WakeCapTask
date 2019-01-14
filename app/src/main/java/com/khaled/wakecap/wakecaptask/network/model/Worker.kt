package com.khaled.wakecap.wakecaptask.network.model

import com.google.gson.annotations.SerializedName

data class Worker(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String
)