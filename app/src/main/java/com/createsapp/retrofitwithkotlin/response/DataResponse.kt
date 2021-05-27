package com.createsapp.retrofitwithkotlin.response

data class DataResponse(
    var albumId: Int,
    var id: Int,
    var thumbnailUrl: String,
    var title: String,
    var url: String
)

data class LoginResponse(
    var code: String,
    var message: String
)