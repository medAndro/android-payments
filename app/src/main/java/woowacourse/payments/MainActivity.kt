package woowacourse.payments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.payments.ui.theme.AndroidpaymentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidpaymentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingPreview()
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding),
//                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Jetpack Compose Text 실습",
        fontSize = 22.sp,
        color = Color.Blue,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
    )
}

@Composable
fun TechCourseImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.img_techcourse),
        contentDescription = "우아한테크코스 로고 이미지",
    )
}

@Composable
fun FavoriteIcon(modifier: Modifier = Modifier) {
    Image(
        imageVector = Icons.Filled.Favorite,
        contentDescription = "좋아요 아이콘",
    )
}

@Composable
fun ButtonSave() {
    Button(onClick = {
        println("저장 버튼 클릭!")
    }) {
        Text(text = "저장")
    }
}

@Composable
fun ButtonHeart() {
    Button(onClick = {
        println("하트 버튼 클릭!")
    }) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "좋아요 아이콘",
            tint = Color.Black,
        )
    }
}

@Composable
fun ButtonHeartText() {
    Button(onClick = {
        println("하트 좋아요 텍스트 버튼 클릭!")
    }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "좋아요 아이콘",
                tint = Color.Black,
            )
            Text(text = "좋아요")
        }
    }
}

@Composable
fun GreetingBox() {
    Box(
        modifier = Modifier.size(200.dp),
    ) {
        // 빨간 사각형, 왼쪽 위에 배치
        Box(
            modifier =
                Modifier
                    .size(50.dp)
                    .background(Color.Red)
                    .align(Alignment.TopStart),
        )

        // 노란 사각형, 중앙 배치
        Box(
            modifier =
                Modifier
                    .size(50.dp)
                    .background(Color.Yellow)
                    .align(Alignment.Center),
        )

        // 초록색 사각형, 오른쪽 아래에 배치
        Box(
            modifier =
                Modifier
                    .size(50.dp)
                    .background(Color.Green)
                    .align(Alignment.BottomEnd),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidpaymentsTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Greeting("Android")
            TechCourseImage()
            FavoriteIcon()
            ButtonSave()
            ButtonHeart()
            ButtonHeartText()
            GreetingBox()
        }
    }
}
