package com.example.humanresources.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Employee(
    @PrimaryKey(autoGenerate = true) val id: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") var lastName: String,
    @ColumnInfo(name = "starting_date") var startingDate: Date = Date(),
    @ColumnInfo(name = "has_received_laptop") var hasReceivedLaptop: Boolean
)