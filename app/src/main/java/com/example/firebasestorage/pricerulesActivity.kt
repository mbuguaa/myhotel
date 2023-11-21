package com.example.firebasestorage

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firebasestorage.navigation.ROUT_HOME
import com.example.firebasestorage.ui.theme.FirebasestorageTheme
import java.time.LocalTime

class pricerulesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            pricerules()

        }
    }
}


@Composable
fun pricerules(){
    val mContext= LocalContext.current
    var name by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize()){
        //TopAppBar
        TopAppBar(title = { androidx.compose.material.Text(text = "Price Rules") },
            navigationIcon = {
                IconButton(onClick = {mContext.startActivity(Intent(mContext, SystemManagementActivity::class.java)) }) {
                    Icon(imageVector = Icons.Filled.ArrowBack , contentDescription = "arrowback")
                }
            },
            actions = {
                IconButton(onClick = {
                    val shareIntent= Intent(Intent.ACTION_SEND)
                    shareIntent.type="text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                    mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                }) {
                    Icon(imageVector = Icons.Filled.Share , contentDescription = "share")
                }
                IconButton(onClick = {
                    val settingsIntent= Intent(Settings.ACTION_SETTINGS)
                    mContext.startActivity(settingsIntent)
                }) {
                    Icon(imageVector = Icons.Filled.Settings , contentDescription = "settings")
                }
            },
            backgroundColor = Color.Magenta)
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)
                .padding(start = 10.dp),
            label = { Text(text = "Single Room  12.00-12.00", fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "20,000ksh") },)

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)
                .padding(start = 10.dp),
            label = { Text(text = "Double Room  12.00-12.00", fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "50,000ksh") },)





    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun pricerulesPreview(){
    pricerules()
}
