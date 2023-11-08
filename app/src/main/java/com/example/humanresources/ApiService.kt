package com.example.humanresources

import com.example.humanresources.database.Employee
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

object ApiService {
    fun fetchEmployee(id: Int): Flow<Employee?> {
        /* mockEmployee */
        return flow {
            val employee = Employee(
                999,
                "John",
                "Doe",
                startingDate = Date(),
                hasReceivedLaptop = false,
                hasReceivedSmartphone = false
            )
            emit(employee)
        }
    }
}