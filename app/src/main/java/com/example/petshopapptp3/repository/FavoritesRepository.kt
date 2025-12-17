package com.example.petshopapptp3.repository

import com.example.petshopapptp3.data.remote.FavoriteItem
import com.example.petshopapptp3.data.remote.Product
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoritesRepository @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
) {
    private fun favoritesCol() =
        firestore.collection("users")
            .document(requireUid())
            .collection("favorites")

    private fun requireUid(): String =
        auth.currentUser?.uid ?: error("No hay usuario autenticado (Anonymous).")

    suspend fun ensureAnonymousLogin() {
        if (auth.currentUser == null) {
            auth.signInAnonymously().await()
        }
    }

    fun observeFavorites(): Flow<List<FavoriteItem>> = callbackFlow {
        val reg = favoritesCol().addSnapshotListener { snap, err ->
            if (err != null) {
                close(err)
                return@addSnapshotListener
            }
            val items = snap?.documents.orEmpty().mapNotNull { d ->
                d.toObject(FavoriteItem::class.java)
            }.sortedByDescending { it.addedAt }

            trySend(items)
        }
        awaitClose { reg.remove() }
    }

    suspend fun addFavorite(product: Product) {
        val docId = product.id.toString()
        val item = FavoriteItem(
            id = product.id,
            title = product.title,
            price = product.price,
            thumbnail = product.thumbnail,
            addedAt = System.currentTimeMillis()
        )
        favoritesCol().document(docId).set(item).await()
    }

    suspend fun removeFavorite(productId: Int) {
        favoritesCol().document(productId.toString()).delete().await()
    }
}