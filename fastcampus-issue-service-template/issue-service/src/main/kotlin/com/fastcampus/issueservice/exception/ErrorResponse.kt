package com.fastcampus.issueservice.exception

import java.lang.RuntimeException

data class ErrorResponse(
    val code: Int,
    val message: String
)
