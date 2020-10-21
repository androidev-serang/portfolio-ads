package com.ads.portfolioads.core.domain.usecase

import com.ads.portfolioads.core.domain.repository.ISampleRepository

class SampleInteractor(private val sampleRepository: ISampleRepository) : SampleUseCase