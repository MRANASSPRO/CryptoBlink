package com.mranasspro.cryptoblink.domain.use_case.get_coin_price

import com.mranasspro.cryptoblink.common.Resource
import com.mranasspro.cryptoblink.data.remote.dto.toCoinPrice
import com.mranasspro.cryptoblink.domain.model.CoinPrice
import com.mranasspro.cryptoblink.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinPriceUseCase @Inject constructor(
    private val repo: CoinRepository
) {
    //we override the invoke operator to call this use case as a function
    operator fun invoke(
        baseCurrencyId: String
    ): Flow<Resource<CoinPrice>> = flow {
        try {
            emit(Resource.Loading<CoinPrice>())
            val coinPrice = repo.getCoinPrice(baseCurrencyId).toCoinPrice()
            emit(Resource.Success<CoinPrice>(coinPrice))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinPrice>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinPrice>("Couldn't reach server. Check your internet connection."))
        }
    }
}