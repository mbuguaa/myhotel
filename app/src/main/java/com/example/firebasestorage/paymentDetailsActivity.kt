package com.example.firebasestorage

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebasestorage.navigation.ROUT_HOME
import com.example.firebasestorage.ui.theme.FirebasestorageTheme

class paymentDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            payment()

        }
    }
}

@Composable
fun payment(){
    val mContext= LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
        //TopAppBar
        TopAppBar(title = { androidx.compose.material.Text(text = "Payment") },
            navigationIcon = {
                IconButton(onClick = {mContext.startActivity(Intent(mContext, DetailsofroomActivity::class.java)) }) {
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

        Text(text = "Single room", fontSize = 30.sp, fontFamily = FontFamily.Serif)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Price : 20,000KSH", fontSize = 20.sp)

        //STK
        OutlinedButton(onClick = {
            val simToolKitLaunchIntent =
                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { mContext.startActivity(it) }

        },
            modifier = Modifier
                .size(width = 380.dp, height = 70.dp)
                .padding(start = 20.dp, end = 20.dp, top = 20.dp),
            shape = CutCornerShape(5.dp), border = BorderStroke(3.dp, Color.Magenta)
        ) {
            Text(text = "PAY VIA M-PESA",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
        }
        Button(
            onClick = {mContext.startActivity(Intent(mContext,Successful::class.java))

            },
            modifier = Modifier.padding(16.dp)
                .clickable {  mContext.startActivity(Intent(mContext,Successful::class.java)) },
            shape = androidx.compose.foundation.shape.CircleShape
        ) {
            Text(text = "Next", color = Color.White)
        }




    }

}


@Preview(showBackground = true)
@Composable
fun paymentPreview(){
    payment()
}
