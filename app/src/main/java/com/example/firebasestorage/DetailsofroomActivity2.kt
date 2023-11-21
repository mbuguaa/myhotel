package com.example.firebasestorage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebasestorage.ui.theme.FirebasestorageTheme

class DetailsofroomActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            doubledetails()


        }
    }
}

@Composable
fun doubledetails(){
    val mContext= LocalContext.current
    var name by remember { mutableStateOf("") }
    var phonenumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        //TopAppBar
        TopAppBar(title = { Text(text = "Double room", color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = { mContext.startActivity(Intent(mContext,RoomtypeActivity::class.java)) }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "arrowback")

                }
            },
            actions = {
                IconButton(onClick = {
                }) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "share")
                }
                IconButton(onClick = {
                }) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "settings")
                }
            }, backgroundColor = Color.Magenta)

        Spacer(modifier = Modifier.height(20.dp))

        //Name
        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)
                .padding(start = 10.dp),
            label = { Text(text = "Name", fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "Enter your name") },
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
//            trailingIcon = { Icon(imageVector = Icons.Default.Check, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        //Phonumber
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = phonenumber,
            onValueChange = { phonenumber = it },
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)
                .padding(start = 10.dp),
            label = { Text(text = "Contact", fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "Enter your phonenumber") },
            leadingIcon = { Icon(imageVector = Icons.Default.Call, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        Spacer(modifier = Modifier.height(10.dp))

        //Email
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)
                .padding(start = 10.dp),
            label = { Text(text = "Email", fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "Enter your email") },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        // Submit button
        Button(
            onClick = { mContext.startActivity(Intent(mContext,paymentdetailsActivity2::class.java))
            },
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    mContext.startActivity(Intent(mContext,paymentdetailsActivity2::class.java))
                },

            ) {
            Text(text = "Submit")
        }





    }


}

@Preview(showBackground = true)
@Composable
fun doubledetailsPreview(){
    doubledetails()

}
