package com.example.tugaspertemuan11_api.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("name") //harus ada kalo pake Api
    val universityName:String
)
