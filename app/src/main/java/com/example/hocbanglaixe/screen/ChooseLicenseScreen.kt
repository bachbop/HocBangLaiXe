package com.example.hocbanglaixe.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hocbanglaixe.R

@Composable
fun ChooseLicenseScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState).fillMaxSize()
            .background(
                color = Color(0xFFF3F3F3)
            )
    ) {
        TopScreenBar(onChooseLicence = {navController.popBackStack()})
        MotoTypeLicense()
        OtoTypeLicense()
        OtherTypeLicense()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopScreenBar(
    onChooseLicence: () -> Unit
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {onChooseLicence()},
                modifier = Modifier.background(color = Color.White.copy(0.1f), shape = CircleShape)
            ) {
                Image(painterResource(R.drawable.ic_close), contentDescription = null)
            }
        },
        title = {
            Text(
                "Loại GPLX (Bằng lái)", style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600)
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE43A37)),
    )
}

@Composable
private fun MotoTypeLicense() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                "Mô tô", style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp
                )
            )
            LicenseDescription("A1", "Mô tô 2 bánh dung tích xilanh từ 50 -> 175 cm3")
            LicenseDescription("A2", "Mô tô 2 bánh dung tích xilanh trên 175 cm3")
            LicenseDescription("A3", "Mô tô 3 bánh, xe lam, xích lô máy")
            LicenseDescription("A4", "Máy kéo có trọng tải đến 1.000kg")
        }
    }
}

@Composable
private fun OtoTypeLicense() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                "Ô tô", style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp
                )
            )
            LicenseDescription("B1", "Ô tô chở người đến 9 chỗ ngồi, ô tô tải trọng dưới 3.500kg")
            LicenseDescription("B2", "Tương tự như bằng lái B1, dành cho người hành nghề lái xe")
        }
    }
}

@Composable
private fun OtherTypeLicense() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                "Khác", style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp
                )
            )
            LicenseDescription("C", "Ô tô tải, đầu kéo rơ moóc trọng tải từ 3.500kg trở lên")
            LicenseDescription("D", "Ô tô chở người từ 10 -> 30 chỗ")
            LicenseDescription("E", "Ô tô chở người trên 30 chỗ")
            LicenseDescription("F", "Các loại xe cho bằng lái B1, B2, C, D, E có rơ moóc")
        }
    }
}

@Composable
private fun LicenseDescription(license: String, description: String) {
    Row(
        modifier = Modifier
            .border(width = 2.dp, color = Color(0xFFDDDDDD), shape = RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                license, style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black
                )
            )
            Text(
                description, style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF868686)
                )
            )
        }

        Image(painterResource(R.drawable.ic_radio), contentDescription = null)
    }
}
