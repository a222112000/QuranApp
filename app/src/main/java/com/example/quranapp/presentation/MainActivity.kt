package com.example.quranapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quranapp.data.remote.dto.TranslatedName
import com.example.quranapp.presentation.ChapterDetails.ChapterDetailScreen
import com.example.quranapp.presentation.ChapterDetails.ChapterDetailViewModel
import com.example.quranapp.presentation.Chapters.ChapterListViewModel
import com.example.quranapp.presentation.Chapters.ChapterScreen
import com.example.quranapp.presentation.theme.QuranAppTheme
import com.google.gson.annotations.SerializedName
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuranAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()
                    val  viewModel: ChapterDetailViewModel = hiltViewModel()
                    val state = viewModel.state.value
                    NavHost(navController = navController, startDestination = Screen.ChapterListScreen.route ){
                        composable(
                            route = Screen.ChapterListScreen.route
                        ){
                            ChapterScreen(navController)
                        }
                        composable(
                            route = Screen.ChapterDetailScreen.route + "/{id}/{bismillahPre}/{name_arabic}/{name_complex}/{verses_count}/{translated_name}/{revelation_place}",
                        arguments = listOf(navArgument("id"){
                            type = NavType.StringType
                        },
                        navArgument("bismillahPre"){
                            type = NavType.StringType
                        },
                            navArgument("name_arabic"){
                                type = NavType.StringType
                            },
                            navArgument("name_complex"){
                                type = NavType.StringType
                            },
                            navArgument("verses_count"){
                                type = NavType.IntType
                            },
                            navArgument("translated_name"){
                                type = NavType.StringType
                            },
                            navArgument("revelation_place"){
                                type = NavType.StringType
                            })){
                            val id = it.arguments?.getString("id")!!
                            val bismillahPre = it.arguments?.getString("bismillahPre")!!
                            val name_arabic = it.arguments?.getString("name_arabic")!!
                            val name_complex = it.arguments?.getString("name_complex")!!
                            val verses_count = it.arguments?.getInt("verses_count")!!
                            val translated_name = it.arguments?.getString("translated_name")!!
                            val revelation_place = it.arguments?.getString("revelation_place")!!
                            ChapterDetailScreen(navController,id,bismillahPre,name_arabic,name_complex,verses_count,translated_name,revelation_place)
                        }
                    }
                }
            }
        }
    }
}