package com.khaled.wakecap.wakecaptask.network.model

import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("attributes")
    val roleAttributes: RoleAttributes,
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String
)