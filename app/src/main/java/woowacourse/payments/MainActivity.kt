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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
                    GreetingPreview(
                        modifier = Modifier.padding(innerPadding),
                    )
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
    var isFavorite: Boolean by remember { mutableStateOf(false) }
    Button(onClick = {
        isFavorite = !isFavorite
    }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            when (isFavorite) {
                true -> {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "좋아요 icon 아이콘1",
                        tint = Color.Red,
                    )
                }

                false -> {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "좋지않아요 icon 아이콘1",
                        tint = Color.Black,
                    )
                }
            }

            when (isFavorite) {
                true -> {
                    Image(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "좋아요 image 아이콘2",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Color.Red),
                    )
                }
                false -> {
                    Image(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "좋지않아요 image 아이콘2",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Color.Black),
                    )
                }
            }


            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = if (isFavorite) "좋아요 아이콘3" else "좋지않아요 아이콘3",
                tint = if (isFavorite) Color.Red else Color.Black,
            )

            Text(text = if (isFavorite) "좋아요" else "좋지않아요")
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
fun GreetingPreview(modifier: Modifier = Modifier) {
    AndroidpaymentsTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Greeting("Android")
            TechCourseImage(modifier)
            FavoriteIcon(modifier)
            ButtonSave()
            ButtonHeart()
            ButtonHeartText()
            GreetingBox()
        }
    }
}
