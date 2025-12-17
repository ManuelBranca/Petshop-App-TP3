package com.example.petshopapptp3.di


import android.app.Application
import androidx.room.Room
import com.example.petshopapptp3.data.local.AppDatabase
import com.example.petshopapptp3.data.local.CartDao
import com.example.petshopapptp3.repository.CartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore






@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "cart_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideCartDao(db: AppDatabase): CartDao = db.cartDao()

    @Provides
    fun provideCartRepository(cartDao: CartDao): CartRepository =
        CartRepository(cartDao)

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
}


