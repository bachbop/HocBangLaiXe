package com.example.hocbanglaixe.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.hocbanglaixe.R

@Composable
fun ListOfTopicsScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF3F3F3))
            .verticalScroll(scrollState)
    ) {
        TopBarScreen(
            onBackScreen = {navController.popBackStack()},
            onRefresh = {}
        )
        ScoreAfterEachQuestion()
        ListTopics()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBarScreen(
    onBackScreen: ()->Unit,
    onRefresh: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {onBackScreen()},
                modifier = Modifier.background(color = Color.White.copy(0.1f), shape = CircleShape)
            ) {
                Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = null, tint = Color.White)
            }
        },
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Thi thử GPLX", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                )
                Text(
                    text = "Bộ 600 câu theo Tổng cục đường bộ VN", style = TextStyle(
                        fontSize = 11.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                )
            }
        },
        actions = {
            IconButton(
                onClick = {onRefresh()},
                modifier = Modifier.background(color = Color.White.copy(0.1f), shape = CircleShape)
            ) {
                Image(painterResource(R.drawable.ic_refresh), contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE43A37)),
    )
}

@SuppressLint("InvalidColorHexValue")
@Composable
private fun ScoreAfterEachQuestion() {
    var checked by remember { mutableStateOf(false) }
    var showAlert by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row {
                    Text(
                        "Chấm điểm sau mỗi câu hỏi", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            color = Color.Black
                        ), modifier = Modifier.padding(end = 4.dp)
                    )
                    Image(painterResource(R.drawable.ic_question_mark), contentDescription = null)
                }
                Text(
                    "Cho phép bạn kiểm tra đáp án ngay lập tức", style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF868686)
                    )
                )
            }
            Switch(
                checked = checked,
                onCheckedChange = { checked = it
                                  showAlert = true},
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF266EF1),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color(0xFF78788052)
                ),
            )
        }
    }
    if (checked && showAlert) {
        IntroNotice(onAlertClick = {showAlert = false})
    }
}

@Composable
private fun IntroNotice(
    onAlertClick: () -> Unit
) {
    AlertDialog(
        confirmButton = {
            FilledTonalButton(
                onClick = {onAlertClick()},
                colors = ButtonDefaults.buttonColors(Color(0xFFE8E8E8))
            ) {
                Text(
                    "Đã hiểu", style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600)
                    )
                )
            }
        },
        title = {
            Text(
                "Chấm điểm sau mỗi câu hỏi là gì?", style = TextStyle(
                    fontSize = 22.sp, fontWeight = FontWeight(600), color = Color.Black
                )
            )
        },
        text = {
            Text(
                text = "Mặc định bài thi sẽ được chấm sau khi bạn hoàn thành, mô phỏng sát với điều kiện thi thật. Tuy nhiên, nếu bạn muốn ôn tập nhanh, ứng dụng cũng hỗ trợ chấm điểm sau mỗi câu hỏi, cho phép bạn kiểm tra đáp án ngay lập tức.",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF4B4B4B),
                    lineHeight = 20.sp
                )
            )
        },
        onDismissRequest = {},
       containerColor = Color.White
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ListTopics() {
    var topicCode by remember { mutableStateOf("Ngẫu nhiên") }
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        maxItemsInEachRow = 2,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        for (i in 1..10) {
            if (i != 1) topicCode = "Đề số ${i - 1}"
            TopicBox(
                modifier = Modifier.weight(1f),
                topicCode
            )
        }
    }
}

@Composable
private fun TopicBox(modifier: Modifier, topicCode: String) {
    Surface(
        modifier,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .height(120.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                topicCode, style = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontWeight = FontWeight(600)
                )
            )
            FilledTonalButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(Color(0xFFE8E8E8))
            ) {
                Text(
                    "Làm bài thi", style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600)
                    )
                )
            }
        }
    }
}

