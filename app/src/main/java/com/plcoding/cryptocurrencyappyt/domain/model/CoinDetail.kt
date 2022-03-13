package com.plcoding.cryptocurrencyappyt.domain.model

import com.plcoding.cryptocurrencyappyt.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String? = "",
    val name: String? = "",
    val description: String? = "",
    val symbol: String? = "",
    val rank: Int? = null,
    val isActive: Boolean? = null,
    val tags: List<String>? = emptyList(),
    val team: List<TeamMember>? = emptyList()
)