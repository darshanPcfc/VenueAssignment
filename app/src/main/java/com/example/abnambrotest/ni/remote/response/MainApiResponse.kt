package com.example.abnambrotest.ni.remote.response

data class MainApiResponse(
    val ok: Boolean,
    val users: List<Users>
)