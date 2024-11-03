package com.batuhan.koincryptocrazy.di

import com.batuhan.koincryptocrazy.repository.CryptoDownload
import com.batuhan.koincryptocrazy.repository.CryptoDownloadImpl
import com.batuhan.koincryptocrazy.service.CryptoAPI
import com.batuhan.koincryptocrazy.viewmodel.CryptoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule  = module {

    //creates a singleton
    single {
        val BASE_URL = "https://raw.githubusercontent.com/"
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)
    }

    single<CryptoDownload> {
        //since we defined retrofit above, this repository will asks for retrofit and we can simply
        //say get() in order to inject it even here
        CryptoDownloadImpl(get())

        //since we are injecting the abstraction, we should explicitly state the
        //implementation and abstraction here
    }

    viewModel{
        //since we defined repo above, we can call get() here as well
        CryptoViewModel(get())
    }

    //creates a factory, everytime we inject a new instance is created.
    factory {

    }
}