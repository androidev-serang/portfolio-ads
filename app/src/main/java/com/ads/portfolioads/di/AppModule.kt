package com.ads.portfolioads.di

import com.ads.portfolioads.core.domain.usecase.SampleInteractor
import org.koin.dsl.module

/**
 * Created by FAJAR SEPTIAN on 21/10/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */

val useCaseModule = module {
    factory<SampleInteractor> { SampleInteractor(get()) }
}

val viewModelModule = module {
    // viewModel { NameOfViewModel(get()) }

}