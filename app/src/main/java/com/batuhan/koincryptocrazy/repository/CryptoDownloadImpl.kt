package com.batuhan.koincryptocrazy.repository

import com.batuhan.koincryptocrazy.model.CryptoModel
import com.batuhan.koincryptocrazy.service.CryptoAPI
import com.batuhan.koincryptocrazy.util.Resource

class CryptoDownloadImpl(private val api : CryptoAPI) : CryptoDownload {

    override suspend fun downloadCryptos() : Resource<List<CryptoModel>> {
        return try {
            val response = api.getData()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)
            } else {
                Resource.error("Error",null)
            }
        } catch (e: Exception) {
            Resource.error("No data!",null)
        }
    }
}