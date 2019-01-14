package com.khaled.wakecap.wakecaptask.network.model

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("Inventories")
    val inventories: List<Any>,
    @SerializedName("Role")
    val role: Role,
    @SerializedName("contractor")
    val contractor: Any,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("helmet_color")
    val helmetColor: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("mobile_number")
    val mobileNumber: Any,
    @SerializedName("role")
    val roleString: String,
    @SerializedName("role_id")
    val roleId: Int,
    @SerializedName("site_id")
    val siteId: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("worker_tag_id")
    val workerTagId: Any
)