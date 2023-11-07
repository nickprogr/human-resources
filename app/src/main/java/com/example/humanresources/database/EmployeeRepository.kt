package com.example.humanresources.database

import android.content.Context
import android.util.Log
import androidx.room.Room

class EmployeeRepository {
    private val TAG = EmployeeRepository::class.java.name

    private lateinit var db: AppDatabase

    private fun isDbInitialized(): Boolean = this::db.isInitialized

    fun initRepository(context: Context) {
        if (isDbInitialized()) return

        Log.i(TAG, "Initializing Employee Repository...")
        db = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "employees"
        ).build()
    }

    fun addEmployee(employee: Employee) {
        db.employeeDao().insert(employee)
    }

    fun updateEmployee(employee: Employee) {
        db.employeeDao().update(employee)
    }

    fun getEmployee(id: Int) {
        db.employeeDao().getById(id)
    }

    fun getNumberOfEmployees() {
        db.employeeDao().count()
    }
}