package com.example.firebasestorage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebasestorage.navigation.ROUT_HOME
import com.example.firebasestorage.ui.theme.FirebasestorageTheme

class SystemManagementActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            System()

        }
    }
}

@Composable
fun System(){
    val mContext= LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        //TopAppBar
        TopAppBar(title = { Text(text = "System Management", color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = { mContext.startActivity(Intent(mContext, ROUT_HOME::class.java)) }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Arrowback")

                }
            })
        //Row 1
       Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
           Card(modifier = Modifier
               .size(200.dp)
               .padding(10.dp)
               .clickable { mContext.startActivity(Intent(mContext,RoomtypeActivity::class.java)) }) {
               Column(modifier = Modifier.padding(10.dp)) {
                   Image(painter = painterResource(id =R.drawable.img_1), contentDescription ="" , modifier = Modifier.size(100.dp))
                   Text(text = "Room types",
                       fontSize = 20.sp,
                       color = Color.Black,
                       fontWeight = FontWeight.Bold)

               }

           }
           Spacer(modifier = Modifier.width(10.dp))
           Card(modifier = Modifier
               .size(200.dp)
               .padding(10.dp)
               .clickable { mContext.startActivity(Intent(mContext,pricerulesActivity::class.java)) }) {
               Column(modifier = Modifier.padding(10.dp)) {
                   Image(painter = painterResource(id =R.drawable.img_2 ), contentDescription ="" , modifier = Modifier.size(100.dp))
                   Text(text = "Price rules",
                       fontSize = 20.sp,
                       color = Color.Black,
                       fontWeight = FontWeight.Bold)

               }

           }





       }
        //row2
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            Card(modifier = Modifier
                .size(200.dp)
                .padding(10.dp)
                .clickable { mContext.startActivity(Intent(mContext,MenuActivity::class.java)) }) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Image(painter = painterResource(id =R.drawable.img_3 ), contentDescription ="" , modifier = Modifier.size(100.dp))
                    Text(text = "Services",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold)

                }

            }
            Spacer(modifier = Modifier.width(10.dp))
            Card(modifier = Modifier
                .size(200.dp)
                .padding(10.dp)
                .clickable { mContext.startActivity(Intent(mContext,HistoryActivity::class.java))}) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Image(painter = painterResource(id =R.drawable.img_4 ), contentDescription ="" , modifier = Modifier.size(100.dp))
                    Text(text = "History",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold)

                }

            }





        }


    }

}


@Preview(showBackground = true)
@Composable
fun SystemPreview(){
    System()
}
