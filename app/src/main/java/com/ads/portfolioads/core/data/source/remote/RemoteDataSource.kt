package com.ads.portfolioads.core.data.source.remote

import com.ads.portfolioads.core.data.source.remote.network.ApiService

/**
 * Created by FAJAR SEPTIAN on 21/10/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */

class RemoteDataSource(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

    }
}