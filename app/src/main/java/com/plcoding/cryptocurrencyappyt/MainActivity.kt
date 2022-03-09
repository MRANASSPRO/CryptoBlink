package com.plcoding.cryptocurrencyappyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.plcoding.cryptocurrencyappyt.presentation.ui.theme.CryptocurrencyAppYTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {

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