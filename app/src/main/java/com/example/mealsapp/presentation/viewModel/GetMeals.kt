package com.example.mealsapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealsapp.data.model.CategoryResponse
import com.example.mealsapp.data.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GetMealsViewModel:ViewModel() {
    val apiService = RetrofitInstance.apiService
    private val _CategoryResponse = MutableStateFlow<CategoryResponse?>(null)
    val categoryResponse: StateFlow<CategoryResponse?> get() = _CategoryResponse

    fun category() {
        viewModelScope.launch { 
            try {
                _CategoryResponse.value = apiService.getMealsData().body()

            }catch (e:Exception){
                Log.e("MealsViewModel",e.message.toString())
            }



        }
    }
}