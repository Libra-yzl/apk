package com.example.hardcodedcertdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hardcodedcertdemo.ui.theme.HardcodedCertDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HardcodedCertDemoTheme {
                // 打印硬编码证书到 Logcat
                Log.d("CertHolder", CertHolder.CERT)
            }
        }
    }
}
