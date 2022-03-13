package com.plcoding.cryptocurrencyappyt.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinPrice

@Composable
fun CoinListItem(
    coin: Coin,
    coinPrice: CoinPrice?,
    onItemClick: (Coin) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis //cut text off it it's too long
        )
        Text(
            text = if (coin.isActive == true) "Active" else "Inactive",
            color = if (coin.isActive == true) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}

/*@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
private fun CoinListItemPreview() {
    CoinListItem(
        coin = Coin(rank = 1, name = "Bitcoin", symbol = "BTC"),
        coinPrice = CoinPrice(baseCurrencyId = "btc-bitcoin", quoteCurrencyId = "usd-us-dollars"),
        onItemClick = {}
    )
}*/
