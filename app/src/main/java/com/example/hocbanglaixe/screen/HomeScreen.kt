package com.example.hocbanglaixe.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hocbanglaixe.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color(0xFFF3F3F3))

    ) {
        MainTopAppBar(
            "Bằng B1",
            onClick = {
                navController.navigate("choose_license_screen")
            }
        )
        ChooseTopic(onChooseClick = {
            navController.navigate("list_of_topic_screen")
        })
        Text(
            "Ôn tập theo chủ đề khác nhau", style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                color = Color.Black
            ),
            modifier = Modifier.padding(start = 16.dp)
        )
        ReviewTopic()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(typeLicense: String, onClick: ()-> Unit) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth().padding(end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
                , verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "Ôn thi GPLX", style = TextStyle(
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight(600)
                        )
                    )
                    Text(
                        text = "Các câu hỏi lý thuyết",
                        style = TextStyle(
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500)
                        )
                    )
                }
                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(Color.White.copy(0.3f))
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            typeLicense, style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Column {
                            Icon(painterResource(R.drawable.ic_vector), contentDescription = null)
                        }
                    }
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE43A37))
    )
}

@Composable
private fun ChooseTopic(
    onChooseClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "Thi thử GPLX", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black
                    )
                )
                Text(
                    text = "18 bộ đề khác nhau", style = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                )
            }

            IconButton(
                onClick = {onChooseClick()},
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.Gray
                )
            ) {
                Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ReviewTopic() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color.White
    ) {
        FlowRow(
            maxItemsInEachRow = 4,
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Topic(
                icon = R.drawable.ic_60_cau_diem_liet,
                titleTopic = "Câu hỏi điểm liệt",
            )
            Topic(
                icon = R.drawable.ic_cau_sai, titleTopic = "Câu bạn trả lời sai"
            )
            Topic(
                icon = R.drawable.ic_top_50_cau_sai, titleTopic = "Top 50 câu sai"
            )
            Topic(
                icon = R.drawable.ic_khai_niem, titleTopic = "Khái niệm và quy tắc"
            )
            Topic(
                icon = R.drawable.ic_nghiep_vu, titleTopic = "Nghiệp vụ vận tải"
            )
            Topic(
                icon = R.drawable.ic_van_hoa, titleTopic = "Văn hoá và đạo đức"

            )
            Topic(
                icon = R.drawable.ic_ki_thuat_o_to, titleTopic = "Kĩ thuật lái xe ô tô",
            )
            Topic(
                icon = R.drawable.ic_cau_tao, titleTopic = "Cấu tạo và sửa chữa",
            )
            Topic(
                icon = R.drawable.ic_bien_bao, titleTopic = "Biển báo đường bộ",
            )
            Topic(
                icon = R.drawable.ic_sa_hinh, titleTopic = "Sa hình",
            )
            Topic(
                icon = R.drawable.ic_top_50_cau_sai_1, titleTopic = "Mẹo ghi nhớ",
            )
            Topic(
                icon = R.drawable.ic_type_15, titleTopic = "Tra cứu biển báo",
            )
        }
    }
}

@Composable
private fun Topic(
    titleTopic: String,
    icon: Int,
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(60.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painterResource(icon), contentDescription = null)
            Text(
                titleTopic,
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 8.sp,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Center
                ),

                )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController)
}


