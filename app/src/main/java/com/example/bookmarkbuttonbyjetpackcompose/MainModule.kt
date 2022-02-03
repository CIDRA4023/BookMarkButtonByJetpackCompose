package com.example.bookmarkbuttonbyjetpackcompose

import android.content.Context
import androidx.room.Room
import com.example.bookmarkbuttonbyjetpackcompose.model.database.ItemDAO
import com.example.bookmarkbuttonbyjetpackcompose.model.database.ItemDatabase
import com.example.bookmarkbuttonbyjetpackcompose.model.database.ItemRepository
import com.example.bookmarkbuttonbyjetpackcompose.model.database.ItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindItemRepository(impl: ItemRepositoryImpl): ItemRepository
}

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun provideItemDatabase(@ApplicationContext context: Context) : ItemDatabase {
        return Room.databaseBuilder(
            context,
            ItemDatabase::class.java,
            "item.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideItemDAO(db: ItemDatabase): ItemDAO {
        return db.itemDao()
    }
}