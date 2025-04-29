package com.example.hardcodedcertdemo

import java.net.URL
import javax.net.ssl.*

object VulnerableSSL {

    fun makeUnsafeRequest() {
        try {
            val trustAllCerts = arrayOf<TrustManager>(
                object : X509TrustManager {
                    override fun checkClientTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {}
                    override fun checkServerTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {}
                    override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = arrayOf()
                }
            )

            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, trustAllCerts, java.security.SecureRandom())
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.socketFactory)

            HttpsURLConnection.setDefaultHostnameVerifier { _, _ -> true }

            val url = URL("https://example.com")
            val conn = url.openConnection() as HttpsURLConnection
            conn.inputStream.bufferedReader().use {
                println(it.readText())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
