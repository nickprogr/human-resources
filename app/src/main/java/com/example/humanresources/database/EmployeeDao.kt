package com.example.humanresources.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(employee: Employee)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg employee: Employee)

    @Update
    fun update(vararg employees: Employee): Int

    @Query("SELECT * FROM employee")
    fun getAll(): List<Employee>?

    @Query("SELECT * FROM employee WHERE id = :employeeId")
    fun getById(employeeId: Int): Employee?

    @Query("SELECT * FROM employee")
    fun getAllWithFlow(): Flow<List<Employee>?>

    @Query("SELECT * FROM employee WHERE id = :employeeId")
    fun getByIdWithFlow(employeeId: Int): Flow<Employee?>

    @Delete
    fun delete(employee: Employee): Int

    @Query("DELETE FROM employee WHERE id = :employeeId")
    fun deleteById(employeeId: Int): Int

    @Query("DELETE FROM employee")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM employee")
    fun count(): Int
}