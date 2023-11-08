package com.example.humanresources.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Employee ADD COLUMN has_received_smartphone INTEGER DEFAULT 0 NOT NULL")
    }
}
