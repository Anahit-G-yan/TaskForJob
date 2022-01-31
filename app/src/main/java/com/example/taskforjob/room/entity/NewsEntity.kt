package com.example.taskforjob.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "news",
    indices = [
        Index(value = ["id"], unique = true),
        Index(value = ["news_id"], unique = true)
    ]
) //make news_id unique so that there are no duplicates

data class NewsEntity(
    @ColumnInfo(name = "apiUrl")
    val apiUrl: String,
    @ColumnInfo(name = "news_id")
    val newsId: String,
    @ColumnInfo(name = "isHosted")
    val isHosted: Boolean,
    @ColumnInfo(name = "pillarId")
    val pillarId: String,
    @ColumnInfo(name = "pillarName")
    val pillarName: String,
    @ColumnInfo(name = "sectionId")
    val sectionId: String,
    @ColumnInfo(name = "sectionName")
    val sectionName: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "webPublicationDate")
    val webPublicationDate: String,
    @ColumnInfo(name = "webTitle")
    val webTitle: String,
    @ColumnInfo(name = "webUrl")
    val webUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}