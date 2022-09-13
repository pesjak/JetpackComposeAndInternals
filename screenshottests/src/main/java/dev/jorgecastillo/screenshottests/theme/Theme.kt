@file:Suppress("TestFunctionName")

package dev.jorgecastillo.compose.app.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import dev.jorgecastillo.screenshottests.theme.Pink200
import dev.jorgecastillo.screenshottests.theme.Pink500
import dev.jorgecastillo.screenshottests.theme.Pink700
import dev.jorgecastillo.screenshottests.theme.Purple200
import dev.jorgecastillo.screenshottests.theme.Purple500
import dev.jorgecastillo.screenshottests.theme.Purple700
import dev.jorgecastillo.screenshottests.theme.Teal200

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val DarkPinkColorPalette = darkColors(
    primary = Pink200,
    primaryVariant = Pink700,
    secondary = Teal200,
    surface = Pink200
)

private val LightPinkColorPalette = lightColors(
    primary = Pink500,
    primaryVariant = Pink700,
    secondary = Teal200,
    surface = Pink700
)

@Composable
fun ComposeAndInternalsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun PinkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkPinkColorPalette
    } else {
        LightPinkColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}