package com.example.firebasestorage

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.firebasestorage.navigation.ROUT_HOME
import com.example.firebasestorage.ui.theme.FirebasestorageTheme

class lottieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Welcome()


        }
    }
}

@Composable
fun Welcome(){
    val mContext= LocalContext.current
    Column (modifier = Modifier.fillMaxSize()){
        //TopAppBar
        TopAppBar(title = { androidx.compose.material.Text(text = "Welcome") },
            navigationIcon = {
                IconButton(onClick = { mContext.startActivity(Intent(mContext, ROUT_HOME::class.java))}) {
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
        //Lottie Animation
        val composition by rememberLottieComposition(spec =LottieCompositionSpec.RawRes(R.raw.welcome))
        val progress by animateLottieCompositionAsState(composition)

        LottieAnimation(composition, progress,
            modifier = Modifier.size(500.dp))

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {  mContext.startActivity(Intent(mContext,BookingActivity::class.java)) },
            shape = CutCornerShape(5.dp),
            modifier = Modifier
                .padding(start = 100.dp)
                .clickable {
                    mContext.startActivity(Intent(mContext,BookingActivity::class.java))
                },

            colors = ButtonDefaults.buttonColors(Color.Magenta)) {
            Text(text = "Book now")

        }




    }

}


@Preview(showBackground = true)
@Composable
fun WelcomePreview(){

}
