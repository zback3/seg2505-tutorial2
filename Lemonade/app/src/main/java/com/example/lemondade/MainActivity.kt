package com.example.lemondade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemondade.ui.theme.LemondadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemondadeTheme {
                LemonApp()
                }
            }
        }
    }

@Composable
fun LemonApp() {
    var currentStep by remember { mutableIntStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = stringResource(R.string.lemon_select))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.lemon_tree_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 2
                            }
                    )
                }
            }
            2 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(text = stringResource(R.string.lemon_squeeze))
                    Spacer(modifier = Modifier.height(32
                        .dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 3
                            }
                    )
                }
            }
            3 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(text = stringResource(R.string.lemon_drink))
                    Spacer(modifier = Modifier.height(32
                        .dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.lemonade_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 4
                            }
                    )
                }
            }
            4 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(text = stringResource(R.string.lemon_empty_glass))
                    Spacer(modifier = Modifier.height(32
                        .dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.empty_glass_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 1
                            }
                    )
                }
            }
        }
    }
}