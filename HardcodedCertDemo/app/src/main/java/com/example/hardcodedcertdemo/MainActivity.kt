package com.example.hardcodedcertdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hardcodedcertdemo.ui.theme.HardcodedCertDemoTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HardcodedCertDemoTheme {
                Greeting(name = "Android")
            }
        }

        // 调用存在漏洞的方法
        VulnerableSSL.makeUnsafeRequest()
    }
}
