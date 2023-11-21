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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebasestorage.navigation.ROUT_HOME
import com.example.firebasestorage.ui.theme.FirebasestorageTheme
import kotlin.coroutines.CoroutineContext

class BookingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Booking()

        }
    }
}

@Composable
fun Booking(){
    val mContext= LocalContext.current
    val context: CoroutineContext

    Column(modifier = Modifier.fillMaxSize()) {
        //Topappbar
        TopAppBar(title = { Text(text = "Booking Calendar", color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = { mContext.startActivity(Intent(mContext, ROUT_HOME::class.java)) }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Arrowback")

                }
            },
            actions = {
                IconButton(onClick = {
                }) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = "share")
                }
                IconButton(onClick = {
                     }) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "settings")
                }
            })

        Spacer(modifier = Modifier.height(200.dp))

        Text(text = "You have not created a room yet.", fontSize = 20.sp, textAlign = TextAlign.Center )
        Text(text = "You can create rooms on the system management page", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {  mContext.startActivity(Intent(mContext,SystemManagementActivity::class.java)) },
            shape = CutCornerShape(5.dp),
            modifier = Modifier
                .padding(start = 100.dp)
                .clickable {
                           mContext.startActivity(Intent(mContext,SystemManagementActivity::class.java))
                },

            colors = ButtonDefaults.buttonColors(Color.Magenta)) {
            Text(text = "System Management")

        }

       






    }

}






@Preview(showBackground = true)
@Composable
fun BookingPreview(){
    Booking()
}
