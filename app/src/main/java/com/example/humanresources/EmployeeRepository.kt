package com.example.humanresources

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.humanresources.database.AppDatabase
import com.example.humanresources.database.Employee
import kotlinx.coroutines.flow.first

object EmployeeRepository {
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

    suspend fun getEmployee(id: Int): Employee? {
        return db.employeeDao().getById(id).first()
    }

    suspend fun getOrFetchEmployee(id: Int): Employee {
        return db.employeeDao().getById(id).first() ?: ApiService.fetchEmployee(id).first()
    }

    fun getNumberOfEmployees() {
        db.employeeDao().count()
    }
}