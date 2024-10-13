package com.example.mealsapp.data.network

import com.example.mealsapp.data.model.CategoryResponse
import retrofit2.Response

interface ApiService {
    fun getMealsData(): Response<CategoryResponse>
}