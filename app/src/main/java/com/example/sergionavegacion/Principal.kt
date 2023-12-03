package com.example.sergionavegacion

import androidx.annotation.StringRes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sergionavegacion.ui.Pantalla1
import com.example.sergionavegacion.ui.Pantalla2
import com.example.sergionavegacion.ui.Pantalla3
import com.example.sergionavegacion.ui.Pantalla4

enum class PrincipalScreen(@StringRes val title: Int) {
    Pantalla1(title = R.string.p1),
    Pantalla2(title = R.string.p2),
    Pantalla3(title = R.string.p3),
    Pantalla4(title = R.string.p4)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperiorTopAppBar(
    currentScreen: PrincipalScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "atras"
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Principal(navController: NavHostController = rememberNavController()) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = PrincipalScreen.valueOf(
        backStackEntry?.destination?.route ?: PrincipalScreen.Pantalla1.name
    )
    Scaffold(
        topBar = {
            BarraSuperiorTopAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PrincipalScreen.Pantalla1.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PrincipalScreen.Pantalla1.name) {
                Pantalla1(
                    modifier = Modifier.fillMaxWidth(),
                    buttonPantalla2 = { navController.navigate(PrincipalScreen.Pantalla2.name) },
                    buttonPantalla3 = { navController.navigate(PrincipalScreen.Pantalla3.name) },
                )
            }
            composable(route = PrincipalScreen.Pantalla2.name) {
                Pantalla2(Modifier.fillMaxWidth())
            }
            composable(route = PrincipalScreen.Pantalla3.name) {
                Pantalla3(
                    Modifier.fillMaxWidth(),
                    buttonPantalla4 = { navController.navigate(PrincipalScreen.Pantalla4.name) },
                )
            }
            composable(route = PrincipalScreen.Pantalla4.name) {
                Pantalla4(Modifier.fillMaxWidth())
            }

        }
    }
}