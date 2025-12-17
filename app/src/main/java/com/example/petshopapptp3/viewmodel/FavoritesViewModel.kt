package com.example.petshopapptp3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petshopapptp3.data.remote.Product
import com.example.petshopapptp3.repository.FavoritesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repo: FavoritesRepository
) : ViewModel() {

    init {
        viewModelScope.launch { repo.ensureAnonymousLogin() }
    }

    val favorites = repo.observeFavorites()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    val favoriteIds: StateFlow<Set<Int>> = repo.observeFavorites()
        .map { list -> list.map { it.id }.toSet() }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptySet())

    fun toggle(product: Product) = viewModelScope.launch {
        val isFav = favoriteIds.value.contains(product.id)
        if (isFav) repo.removeFavorite(product.id) else repo.addFavorite(product)
    }

    fun remove(productId: Int) = viewModelScope.launch {
        repo.removeFavorite(productId)
    }
}