package com.example.hocbanglaixe.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hocbanglaixe.R
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "DefaultLocale")
@Composable
fun DoExamScreen() {
    val modeScoreAfterQuestion = true
    val numOfQuestion = 25
    var itemIndex by remember { mutableStateOf(0) }
    var showListQuestion by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F3F3)),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        CustomTopBar()
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            TaskNavigation(
                numOfQuestion = numOfQuestion,
                selectedItem = itemIndex,
                onClick = { itemIndex = it })
            Question(
                "Câu ${itemIndex + 1}/25",
                "Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?",
                onQuestionClick = {}
            )
            Answer(isScoreAfterQuesMode = modeScoreAfterQuestion)
        }
        CustomBottomBar(
            onChooseQuestion = { showListQuestion = !showListQuestion },
            onPreQuestion = { if (itemIndex > 0) itemIndex -= 1 },
            onNextQuestion = { if (itemIndex < 24) itemIndex += 1 },
            preColor = if (itemIndex == 0) Color(0xFFBBBBBB) else Color.Black,
            nextColor = if (itemIndex == 24) Color(0xFFBBBBBB) else Color.Black
        )
    }

    if (showListQuestion) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable { showListQuestion = false }
        ) { }
    }

    if (showListQuestion) {
        ListQuestion(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .offset(y = 200.dp),
            onClick = { showListQuestion = false },
            onQuestionClick = {

            },
            questionNo = "Câu 1"
        )
    }
}

@SuppressLint("DefaultLocale")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomTopBar() {
    var timeLeft by remember { mutableStateOf(1200) }
    var minutes = timeLeft / 60
    var seconds = timeLeft % 60

    LaunchedEffect(key1 = timeLeft) {
        if (timeLeft > 0) {
            delay(1000L)
            timeLeft -= 1
        }
    }
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column {
                    Text(
                        "Đề: ", style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            lineHeight = 16.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White.copy(alpha = 0.7f)
                        )
                    )
                    Text(
                        "Số 1", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            lineHeight = 16.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    )
                }
                Column(
                    modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(Color.White.copy(alpha = 0.7f))
                ) {}
                Column {
                    Text(
                        "Thời gian còn lại: ", style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            lineHeight = 16.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White.copy(alpha = 0.7f)
                        )
                    )
                    Text(
                        String.format("%02d:%02d", minutes, seconds), style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            lineHeight = 16.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    )
                }

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE43A37)),
        navigationIcon = {
            IconButton(
                onClick = {},
                modifier = Modifier.background(
                    color = Color.White.copy(0.1f),
                    shape = CircleShape
                )
            ) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        actions = {
            FilledTonalButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(Color.White.copy(alpha = 0.2f))
            ) {
                Text(
                    "Nộp bài", style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600)
                    )
                )
            }
        }
    )
}

@Composable
private fun CustomBottomBar(
    onPreQuestion: () -> Unit,
    onNextQuestion: () -> Unit,
    onChooseQuestion: () -> Unit,
    preColor: Color,
    nextColor: Color
) {
    BottomAppBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.clickable { onPreQuestion() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = null, tint = preColor)
                Text(
                    "Câu trước", style = TextStyle(
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = preColor
                    )
                )
            }
            IconButton(onClick = { onChooseQuestion() }) {
                Icon(painterResource(R.drawable.ic_list), contentDescription = null)
            }

            Row(
                modifier = Modifier.clickable { onNextQuestion() },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "Câu sau", style = TextStyle(
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = nextColor
                    )
                )
                Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null, tint = nextColor)
            }

        }
    }
}

@Composable
private fun ListQuestion(
    modifier: Modifier,
    onClick: () -> Unit,
    onQuestionClick: () -> Unit,
    questionNo: String
) {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp),
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { onClick() },
                    modifier = Modifier.background(color = Color(0xFFE8E8E8), shape = CircleShape)
                ) {
                    Image(Icons.Filled.Close, contentDescription = null)
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        "Chọn câu hỏi", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = Color.Black
                        )
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "Tổng 25 câu", style = TextStyle(
                            fontSize = 11.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF868686)
                        )
                    )
                }
            }
            HorizontalDivider()
            Question(
                questionNo,
                "Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?",
                onQuestionClick = { onQuestionClick() }
            )
            HorizontalDivider()

        }

    }
}

@Composable
private fun TaskNavigation(
    numOfQuestion: Int,
    selectedItem: Int,
    onClick: (Int) -> Unit,
) {
    LazyRow(
        modifier = Modifier.padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(start = 8.dp)
    ) {
        items(numOfQuestion) { item ->
            var isSelected = selectedItem == item
            Box(
                modifier = Modifier
                    .height(28.dp)
                    .width(44.dp)
                    .clickable { onClick(item) }
                    .background(
                        Color.White, shape = RoundedCornerShape(100.dp)
                    )
                    .border(
                        width = 2.dp,
                        color = if (isSelected) Color.Black else Color.White,
                        shape = RoundedCornerShape(100.dp)
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    "${item + 1}", style = TextStyle(
                        fontWeight = FontWeight(600),
                        fontSize = 14.sp,
                        color = if (isSelected) Color.Black else Color(0xFF868686)
                    )
                )
            }
        }
    }
}

@Composable
private fun Question(
    questionNo: String,
    question: String,
    onQuestionClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clickable { onQuestionClick() }
    ) {
        Text(
            questionNo, style = TextStyle(
                fontSize = 12.sp, fontWeight = FontWeight(500), color = Color(0xFF868686)
            )
        )
        Text(
            question, style = TextStyle(
                fontWeight = FontWeight(600),
                fontSize = 16.sp,
                color = Color.Black
            )
        )
    }
}

@Composable
private fun Answer(
    isScoreAfterQuesMode: Boolean
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        var clickStatus by remember { mutableStateOf("Option") }
        val correctAnswer = "Option 2"
        var showCorrectAnswer by remember { mutableStateOf(false) }
        val explainQuestion = "Theo luật giao thông đường bộ, phần GIẢI THÍCH THUẬT NGỮ, phần đường xe chạy là phần của đường bộ được sử dụng cho phương tiện giao thông qua lại. Lề đường không được sử dụng cho các phương tiện giao thông qua lại."
        Column(
            modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                "Chọn đáp án", style = TextStyle(
                    color = Color(0xFF868686),
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp
                )
            )
            Option(
                "1.",
                " Phần mặt đường và lề đường",
                explain = explainQuestion,
                onClick = {
                    clickStatus = "Option 1"
                    showCorrectAnswer = true
                },
                borderColor = when {
                    showCorrectAnswer && "Option 1" == correctAnswer && isScoreAfterQuesMode -> Color(0xFF009A51)
                    showCorrectAnswer && clickStatus == "Option 1" && isScoreAfterQuesMode-> Color(0xFFE65300)
                    else -> Color(0xFFDDDDDD)
                },
                backgroundOptionColor = when {
                    showCorrectAnswer && "Option 1" == correctAnswer && isScoreAfterQuesMode -> Color(0xFFEAF6ED)
                    showCorrectAnswer && clickStatus == "Option 1" && isScoreAfterQuesMode -> Color(0xFFFFF0EE)
                    else -> Color.White
                },
                textColor = when {
                    showCorrectAnswer && "Option 1" == correctAnswer && isScoreAfterQuesMode -> Color(0xFF009A51)
                    showCorrectAnswer && clickStatus == "Option 1" && isScoreAfterQuesMode -> Color(0xFFE65300)
                    else -> Color.Black
                },
                radioIcon = when {
                    showCorrectAnswer && "Option 1" == correctAnswer && isScoreAfterQuesMode -> R.drawable.ic_cau_dung
                    showCorrectAnswer && clickStatus == "Option 1" && isScoreAfterQuesMode -> R.drawable.ic_dap_an_sai
                    else -> if (clickStatus == "Option 1") R.drawable.ic_selected_radio else R.drawable.ic_radio
                },
                showExplain = isScoreAfterQuesMode && showCorrectAnswer && correctAnswer == "Option 1"
            )
            Option(
                "2.",
                " Phần đường xe chạy",
                explain = explainQuestion,
                onClick = {
                    clickStatus = "Option 2"
                    showCorrectAnswer = true
                },
                borderColor = when {
                    showCorrectAnswer && "Option 2" == correctAnswer&& isScoreAfterQuesMode -> Color(0xFF009A51)
                    showCorrectAnswer && clickStatus == "Option 2" && isScoreAfterQuesMode-> Color(0xFFE65300)
                    else -> Color(0xFFDDDDDD)
                },
                backgroundOptionColor = when {
                    showCorrectAnswer && "Option 2" == correctAnswer&& isScoreAfterQuesMode -> Color(0xFFEAF6ED)
                    showCorrectAnswer && clickStatus == "Option 2"&& isScoreAfterQuesMode -> Color(0xFFFFF0EE)
                    else -> Color.White
                },
                textColor = when {
                    showCorrectAnswer && "Option 2" == correctAnswer && isScoreAfterQuesMode-> Color(0xFF009A51)
                    showCorrectAnswer && clickStatus == "Option 2"&& isScoreAfterQuesMode-> Color(0xFFE65300)
                    else -> Color.Black
                },
                radioIcon = when {
                    showCorrectAnswer && "Option 2" == correctAnswer && isScoreAfterQuesMode-> R.drawable.ic_cau_dung
                    showCorrectAnswer && clickStatus == "Option 2" && isScoreAfterQuesMode-> R.drawable.ic_dap_an_sai
                    else -> if (clickStatus == "Option 2") R.drawable.ic_selected_radio else R.drawable.ic_radio
                },
                showExplain = isScoreAfterQuesMode && showCorrectAnswer && correctAnswer == "Option 2"
            )
            Option(
                "3.",
                " Phần đường xe cơ giới",
                explain = explainQuestion,
                onClick = { clickStatus = "Option 3"
                          showCorrectAnswer = true},
                borderColor = when {
                    showCorrectAnswer && "Option 3" == correctAnswer && isScoreAfterQuesMode -> Color(0xFF009A51)
                    showCorrectAnswer && clickStatus == "Option 3" && isScoreAfterQuesMode-> Color(0xFFE65300)
                    else -> Color(0xFFDDDDDD)
                },
                backgroundOptionColor = when {
                    showCorrectAnswer && "Option 3" == correctAnswer&& isScoreAfterQuesMode -> Color(0xFFEAF6ED)
                    showCorrectAnswer && clickStatus == "Option 3"&& isScoreAfterQuesMode -> Color(0xFFFFF0EE)
                    else -> Color.White
                },
                textColor = when {
                    showCorrectAnswer && "Option 3" == correctAnswer&& isScoreAfterQuesMode -> Color(0xFF009A51)
                    showCorrectAnswer && clickStatus == "Option 3"&& isScoreAfterQuesMode -> Color(0xFFE65300)
                    else -> Color.Black
                },
                radioIcon = when {
                    showCorrectAnswer && "Option 3" == correctAnswer && isScoreAfterQuesMode-> R.drawable.ic_cau_dung
                    showCorrectAnswer && clickStatus == "Option 3"&& isScoreAfterQuesMode -> R.drawable.ic_dap_an_sai
                    else -> if (clickStatus == "Option 3") R.drawable.ic_selected_radio else R.drawable.ic_radio
                },
                showExplain = isScoreAfterQuesMode && showCorrectAnswer && correctAnswer == "Option 3"
            )
        }
    }
}

@Composable
private fun Option(
    numAnswer: String,
    answer: String,
    onClick: () -> Unit,
    borderColor: Color,
    backgroundOptionColor: Color,
    textColor: Color,
    radioIcon: Int,
    showExplain: Boolean = false,
    explain: String? = null
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(8.dp)
            )
            .background(backgroundOptionColor)
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Text(
                    numAnswer, style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(400),
                        color = textColor
                    )
                )
                Text(
                    answer, style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(400),
                        color = textColor
                    )
                )
            }
            Image(
                painterResource(radioIcon), contentDescription = null
            )
        }

        if (showExplain && explain != null) {
            Surface(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                shape = RoundedCornerShape(16.dp),
                color = Color.White

            ){
                Column(
                    modifier = Modifier.padding(8.dp).background(Color.White)
                ) {
                    Text("Giải thích:", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600), color = Color(0xFF868686)
                    )
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(explain, style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400), color = Color(0xFF4B4B4B)))
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewDoExamScreen() {
    DoExamScreen()
}