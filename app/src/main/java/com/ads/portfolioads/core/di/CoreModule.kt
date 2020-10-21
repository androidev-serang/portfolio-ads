package com.ads.portfolioads.core.di

import androidx.room.Room
import com.ads.portfolioads.core.data.SampleRepository
import com.ads.portfolioads.core.data.source.local.LocalDataSource
import com.ads.portfolioads.core.data.source.local.room.SampleDatabase
import com.ads.portfolioads.core.data.source.remote.RemoteDataSource
import com.ads.portfolioads.core.data.source.remote.network.ApiService
import com.ads.portfolioads.core.domain.repository.ISampleRepository
import com.ads.portfolioads.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by FAJAR SEPTIAN on 21/10/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */

val databaseModule = module {
    factory { get<SampleDatabase>().sampleDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            SampleDatabase::class.java, "Tourism.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dicoding-tourism-api.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ISampleRepository> { SampleRepository(get(), get(), get()) }
}