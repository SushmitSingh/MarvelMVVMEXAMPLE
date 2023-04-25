package com.example.task1marvel.data

import com.google.gson.annotations.SerializedName


data class Marvel(
    @SerializedName("name") var name: String? = null,
    @SerializedName("realname") var realname: String? = null,
    @SerializedName("team") var team: String? = null,
    @SerializedName("firstappearance") var firstappearance: String? = null,
    @SerializedName("createdby") var createdby: String? = null,
    @SerializedName("publisher") var publisher: String? = null,
    @SerializedName("imageurl") var imageurl: String? = null,
    @SerializedName("bio") var bio: String? = null

)