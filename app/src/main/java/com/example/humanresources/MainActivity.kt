package com.example.humanresources

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.coroutineScope
import com.example.humanresources.database.Employee
import com.example.humanresources.ui.theme.HumanresourcesTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        EmployeeRepository.initRepository(this)
//        lifecycle.coroutineScope.launch {
        GlobalScope.launch(Dispatchers.IO) {
//            EmployeeRepository.getEmployeeWithFlow(1).collect() { employee ->
//            EmployeeRepository.getOrFetchEmployeeWithFlow(1).collect() { employee ->
            val employee = EmployeeRepository.getEmployee(1)
                setContent {
                    HumanresourcesTheme {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Greeting("${employee?.firstName ?: "Unknown"} ${employee?.lastName ?: "Unknownson"}")
                        }
                    }
                }
//            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HumanresourcesTheme {
        Greeting("Android")
    }
}