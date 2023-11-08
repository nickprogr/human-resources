package com.example.humanresources

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.humanresources.database.AppDatabase
import com.example.humanresources.database.Employee
import com.example.humanresources.database.MIGRATION_1_2
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
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
        ).addMigrations(MIGRATION_1_2).build()
    }

    fun addEmployee(employee: Employee) {
        db.employeeDao().insert(employee)
    }

    fun updateEmployee(employee: Employee) {
        db.employeeDao().update(employee)
    }

    fun getEmployee(id: Int): Employee? {
        return db.employeeDao().getById(id)
    }

    fun getEmployeeWithFlow(id: Int): Flow<Employee?> {
        return db.employeeDao().getByIdWithFlow(id)
    }

    suspend fun getOrFetchEmployeeWithFlow(id: Int): Flow<Employee?> {
        return if (db.employeeDao().getByIdWithFlow(id).first() == null) {
            ApiService.fetchEmployee(id)
        } else db.employeeDao().getByIdWithFlow(id)
    }

    fun getNumberOfEmployees() {
        db.employeeDao().count()
    }
}