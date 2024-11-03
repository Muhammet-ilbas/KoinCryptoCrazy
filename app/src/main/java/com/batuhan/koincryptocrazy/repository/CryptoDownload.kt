package com.batuhan.koincryptocrazy.repository

import com.batuhan.koincryptocrazy.model.CryptoModel
import com.batuhan.koincryptocrazy.util.Resource


interface CryptoDownload {
    suspend fun downloadCryptos() : Resource<List<CryptoModel>>
}