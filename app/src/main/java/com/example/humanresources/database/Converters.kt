package com.example.humanresources.database

import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun timestampToDate(value: Long?): Date? = value?.let { Date(it) }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time
}