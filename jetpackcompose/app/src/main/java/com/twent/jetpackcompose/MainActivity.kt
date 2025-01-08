package com.twent.jetpackcompose

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.twent.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ButtonExample()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 스탭 1: 색상을 지정하기 위해 color 파라미터에 Color.Red를 전달
        Text(
            color = Color.Red,
            text = "Hello $name!",
            modifier = modifier
        )
        // 스탭 2: Color 객체를 이용해서 해쉬값으로 색상을 전달.
        Text(
            color = Color(0xffff9944),
            text = "Hello $name!"
        )
        // 스탭 3: fontSize 파라미터에 30.sp를 전달.
        Text(
            color = Color.Red,
            text = "Hello $name!",
            fontSize = 30.sp
        )
        // 스탭 4: fontWeight에 FontWeight.Bold를 전달.
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp,
            fontWeight= FontWeight.Bold
        )
        // 스탭 5: fontFamily에 FontFamily.Cursive를 전달
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp,
            fontWeight= FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        // 스탭 6: letterSpacing 2.sp 지정
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp,
            fontWeight= FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            letterSpacing = 2.sp
        )
        // 스탭 6: maxLines를 2로 지정하고 문자열 더 추가
        Text(
            color = Color.Red,
            text = "Hello $name\nHello $name\nHello $name",
            fontSize = 30.sp,
            fontWeight= FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            maxLines = 2
        )
        // 스탭 7: textDecoration에 TextDecoration.Underline을 추가
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp,
            fontWeight= FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline
        )
        // 스탭 8: textAlign을 textAlign.Center로 지정
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp,
            fontWeight= FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center
        )
    }


}

@Composable
fun ButtonExample() {
    val context = LocalContext.current

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    ButtonTheme() {
//        ButtonExample()
//    }

}