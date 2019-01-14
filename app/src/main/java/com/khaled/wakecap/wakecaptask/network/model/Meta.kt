package com.khaled.wakecap.wakecaptask.network.model

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("last_page")
    val lastPage: Int,
    @SerializedName("next")
    val next: Any,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("total")
    val total: Int
)