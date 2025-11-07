package com.example.questnavigasitugas_122.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PurpleDark,
    secondary = Purple,
    tertiary = PurpleLight
)

private val LightColorScheme = lightColorScheme(
    primary = Purple,
    onPrimary = Color.White,
    secondary = PurpleDark,
    onSecondary = Color.White,
    surface = Color(0xFFF7F5FF),
    surfaceVariant = PurpleLight
)

@Composable
fun QuestNavTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
