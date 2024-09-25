package com.example.hocbanglaixe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hocbanglaixe.screen.ChooseLicenseScreen
import com.example.hocbanglaixe.screen.HomeScreen
import com.example.hocbanglaixe.screen.ListOfTopicsScreen
import com.example.hocbanglaixe.ui.theme.HocBangLaiXeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController= navController, startDestination = "home_screen") {
                composable("home_screen") {
                    HomeScreen(navController)
                }
                composable("choose_license_screen") {
                    ChooseLicenseScreen(navController)
                }
                composable("list_of_topic_screen") {
                    ListOfTopicsScreen(navController)
                }
            }
        }
    }
}
