package com.ads.portfolioads.core.data

import com.ads.portfolioads.core.data.source.local.LocalDataSource
import com.ads.portfolioads.core.data.source.remote.RemoteDataSource
import com.ads.portfolioads.core.domain.repository.ISampleRepository
import com.ads.portfolioads.core.utils.AppExecutors

/**
 * Created by FAJAR SEPTIAN on 21/10/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */

class SampleRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISampleRepository

