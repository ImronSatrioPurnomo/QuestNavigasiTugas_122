package com.example.questnavigasitugas_122

package com.example.questnavigasitugas_122.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_122.view.FormulirScreen
import com.example.questnavigasitugas_122.view.ListPesertaScreen
import com.example.questnavigasitugas_122.view.WelcomeScreen
import com.example.questnavigasitugas_122.viewmodel.PesertaViewModel

sealed class Screen(val route: String) {
    data object Welcome : Screen("welcome")
    data object List : Screen("list")
    data object Form : Screen("form")
}

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    val pesertaVM: PesertaViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onSubmit = { navController.navigate(Screen.List.route) }
            )
        }
        composable(Screen.List.route) {
            ListPesertaScreen(
                state = pesertaVM,
                onBeranda = { navController.navigate(Screen.Welcome.route) },
                onForm = { navController.navigate(Screen.Form.route) }
            )
        }
        composable(Screen.Form.route) {
            FormulirScreen(
                state = pesertaVM,
                onSubmit = {
                    navController.popBackStack(Screen.List.route, inclusive = false)
                }
            )
        }
    }
}
