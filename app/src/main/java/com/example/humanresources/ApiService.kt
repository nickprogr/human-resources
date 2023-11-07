package com.example.humanresources

import com.example.humanresources.database.Employee
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

object ApiService {

    fun fetchEmployee(id: Int): Flow<Employee> {
        /* mockEmployee */
        return flow { Employee(999, "John", "Doe", Date(), hasReceivedLaptop = false) }
    }
}