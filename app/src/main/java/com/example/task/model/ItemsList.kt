package com.example.task.model

data class ItemsList(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)