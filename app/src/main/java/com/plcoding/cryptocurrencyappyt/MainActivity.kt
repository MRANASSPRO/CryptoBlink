package com.plcoding.cryptocurrencyappyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.cryptocurrencyappyt.presentation.Screen
import com.plcoding.cryptocurrencyappyt.presentation.coin_detail.CoinDetailScreen
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListScreen
import com.plcoding.cryptocurrencyappyt.presentation.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }

            //iconbtn shortcut for live template
            /*IconButton(
                onClick = {

                },
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }*/

            //centerbox shortcut for live template
            /*Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

            }*/

            //comp shortcut for live template
            /*@Composable
            fun myApp() {

            }*/

            //remember shortcut for live template
            /*var showOnBoarding by remember {
                mutableStateOf("Anass")
            }*/

        }
    }
}