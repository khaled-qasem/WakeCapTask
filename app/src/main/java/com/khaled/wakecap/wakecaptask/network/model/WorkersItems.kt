package com.khaled.wakecap.wakecaptask.network.model

import com.google.gson.annotations.SerializedName

data class WorkersItems(
    @SerializedName("items")
    val items: List<Worker>,
    @SerializedName("meta")
    val meta: Meta
)