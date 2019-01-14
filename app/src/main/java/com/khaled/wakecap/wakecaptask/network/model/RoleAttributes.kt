package com.khaled.wakecap.wakecaptask.network.model

import com.google.gson.annotations.SerializedName

data class RoleAttributes(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: String
)