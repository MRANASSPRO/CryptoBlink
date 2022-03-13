package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin_price

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinPrice
import com.plcoding.cryptocurrencyappyt.domain.model.CoinPrice
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
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