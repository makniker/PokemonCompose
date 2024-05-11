package com.example.pokemoncompose.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF006C4C)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFF89F8C7)
val md_theme_light_onPrimaryContainer = Color(0xFF002114)
val md_theme_light_secondary = Color(0xFF4D6357)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFCFE9D9)
val md_theme_light_onSecondaryContainer = Color(0xFF092016)
val md_theme_light_tertiary = Color(0xFF3D6373)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFC1E8FB)
val md_theme_light_onTertiaryContainer = Color(0xFF001F29)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFBFDF9)
val md_theme_light_onBackground = Color(0xFF191C1A)
val md_theme_light_surface = Color(0xFFFBFDF9)
val md_theme_light_onSurface = Color(0xFF191C1A)
val md_theme_light_surfaceVariant = Color(0xFFDBE5DD)
val md_theme_light_onSurfaceVariant = Color(0xFF404943)
val md_theme_light_outline = Color(0xFF707973)
val md_theme_light_inverseOnSurface = Color(0xFFEFF1ED)
val md_theme_light_inverseSurface = Color(0xFF2E312F)
val md_theme_light_inversePrimary = Color(0xFF6CDBAC)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF006C4C)
val md_theme_light_outlineVariant = Color(0xFFBFC9C2)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFF6CDBAC)
val md_theme_dark_onPrimary = Color(0xFF003826)
val md_theme_dark_primaryContainer = Color(0xFF005138)
val md_theme_dark_onPrimaryContainer = Color(0xFF89F8C7)
val md_theme_dark_secondary = Color(0xFFB3CCBE)
val md_theme_dark_onSecondary = Color(0xFF1F352A)
val md_theme_dark_secondaryContainer = Color(0xFF354B40)
val md_theme_dark_onSecondaryContainer = Color(0xFFCFE9D9)
val md_theme_dark_tertiary = Color(0xFFA5CCDF)
val md_theme_dark_onTertiary = Color(0xFF073543)
val md_theme_dark_tertiaryContainer = Color(0xFF244C5B)
val md_theme_dark_onTertiaryContainer = Color(0xFFC1E8FB)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF191C1A)
val md_theme_dark_onBackground = Color(0xFFE1E3DF)
val md_theme_dark_surface = Color(0xFF191C1A)
val md_theme_dark_onSurface = Color(0xFFE1E3DF)
val md_theme_dark_surfaceVariant = Color(0xFF404943)
val md_theme_dark_onSurfaceVariant = Color(0xFFBFC9C2)
val md_theme_dark_outline = Color(0xFF8A938C)
val md_theme_dark_inverseOnSurface = Color(0xFF191C1A)
val md_theme_dark_inverseSurface = Color(0xFFE1E3DF)
val md_theme_dark_inversePrimary = Color(0xFF006C4C)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFF6CDBAC)
val md_theme_dark_outlineVariant = Color(0xFF404943)
val md_theme_dark_scrim = Color(0xFF000000)

class PokemonColors {
    companion object {
        val Bug = Color(0xffaabb22)
        val Dark = Color(0xff775544)
        val Dragon = Color(0xff7766EE)
        val Electric = Color(0xffF0C03E)
        val Fairy = Color(0xffee99ee)
        val Fighting = Color(0xffbb5544)
        val Fire = Color(0xffff4422)
        val Flying = Color(0xff8899ff)
        val Ghost = Color(0xff9F5BBA)
        val Grass = Color(0xff4FC1A6)
        val Ground = Color(0xff775544)
        val Ice = Color(0xff66ccff)
        val Normal = Color(0xffaaaa99)
        val Poison = Color(0xffaa5599)
        val Psychic = Color(0xffff5599)
        val Rock = Color(0xffBBAA66)
        val Water = Color(0xff429BED)
    }
}

@Immutable
data class PokemonTypeColorScheme(
    val primary: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color
)

val LocalPokemonTypeColorScheme = staticCompositionLocalOf {
    PokemonTypeColorScheme(
        primary = Color.Magenta,
        surface = Color.Magenta,
        onSurface = Color.Magenta,
        surfaceVariant = Color.Magenta
    )
}

@Immutable
data class TypeColors(
    val primaryDark: Color,
    val primaryLight: Color,
    val surfaceDark: Color,
    val surfaceLight: Color = Color.Unspecified,
    val onSurfaceDark: Color,
    val onSurfaceLight: Color = Color.Unspecified,
    val surfaceVariantDark: Color,
    val surfaceVariantLight: Color
)

val BugTypeColors = TypeColors(
    primaryDark = Color(0xffBFD039),
    primaryLight = Color(0xff5A6400),
    surfaceDark = Color(0xff434B00),
    surfaceLight = PokemonColors.Bug,
    onSurfaceDark = Color(0xffF8FFB9),
    onSurfaceLight = Color(0xff5A6400),
    surfaceVariantDark = Color(0x661A1E00),
    surfaceVariantLight = Color(0x26002019),
)

val DarkTypeColors = TypeColors(
    primaryDark = Color(0xffFFB691),
    primaryLight = PokemonColors.Dark,
    surfaceDark = Color(0xff793100),
    onSurfaceDark = Color(0xffFFDBCB),
    surfaceVariantDark = Color(0x66341100),
    surfaceVariantLight = Color(0x26341100),
)

val DragonTypeColors = TypeColors(
    primaryDark = Color(0xffC7BFFF),
    primaryLight = PokemonColors.Dragon,
    surfaceDark = Color(0xff422AB7),
    onSurfaceDark = Color(0xffE4DFFF),
    surfaceVariantDark = Color(0x66180065),
    surfaceVariantLight = Color(0x26180065),
)

val ElectricTypeColors = TypeColors(
    primaryDark = Color(0xffF0C03E),
    primaryLight = PokemonColors.Electric,
    surfaceDark = Color(0xFFB48B00),
    onSurfaceDark = Color(0xffFFF8F1),
    onSurfaceLight = Color(0xff4C3900),
    surfaceVariantDark = Color(0xA8251A00),
    surfaceVariantLight = Color(0x26251A00),
)


val FairyTypeColors = TypeColors(
    primaryDark = Color(0xffC473C5),
    primaryLight = Color(0xffE18EE2),
    surfaceDark = Color(0xff702875),
    onSurfaceDark = Color(0xffFFD6FA),
    onSurfaceLight = Color(0xff631B69),
    surfaceVariantDark = Color(0x6636003C),
    surfaceVariantLight = Color(0x4036003C),
)

val FightingTypeColors = TypeColors(
    primaryDark = Color(0xffFFB4A7),
    primaryLight = PokemonColors.Fighting,
    surfaceDark = Color(0xff80291C),
    onSurfaceDark = Color(0xffFFDAD4),
    surfaceVariantDark = Color(0x662B1B1A),
    surfaceVariantLight = Color(0x402B1B1A),
)

val FireTypeColors = TypeColors(
    primaryDark = Color(0xffE3300E),
    primaryLight = PokemonColors.Fire,
    surfaceDark = Color(0xff8E1400),
    onSurfaceDark = Color(0xffFFDAD3),
    surfaceVariantDark = Color(0x663E0400),
    surfaceVariantLight = Color(0x263E0400),
)

val FlyingTypeColors = TypeColors(
    primaryDark = Color(0xffBAC3FF),
    primaryLight = PokemonColors.Flying,
    surfaceDark = Color(0xff2A3C9E),
    onSurfaceDark = Color(0xffDEE0FF),
    surfaceVariantDark = Color(0x6600105C),
    surfaceVariantLight = Color(0x2600105C),
)

val GhostTypeColors = TypeColors(
    primaryDark = Color(0xffECB2FF),
    primaryLight = PokemonColors.Ghost,
    surfaceDark = Color(0xff6A2885),
    onSurfaceDark = Color(0xffF8D8FF),
    surfaceVariantDark = Color(0x66320046),
    surfaceVariantLight = Color(0x26320046),
)

val GrassTypeColors = TypeColors(
    primaryDark = Color(0xff00876F),
    primaryLight = PokemonColors.Grass,
    surfaceDark = Color(0xff005141),
    onSurfaceDark = Color(0xffE6FFF5),
    surfaceVariantDark = Color(0x66002019),
    surfaceVariantLight = Color(0x26002019),
)

val GroundTypeColors = TypeColors(
    primaryDark = Color(0xffEAC248),
    primaryLight = PokemonColors.Ground,
    surfaceDark = Color(0xff574500),
    onSurfaceDark = Color(0xffFFEFCC),
    surfaceVariantDark = Color(0x66241A00),
    surfaceVariantLight = Color(0x40241A00),
)

val IceTypeColors = TypeColors(
    primaryDark = Color(0xff79D1FF),
    primaryLight = Color(0xff4AB6E8),
    surfaceDark = Color(0xff004C68),
    onSurfaceDark = Color(0xffC3E8FF),
    onSurfaceLight = Color(0xff004C68),
    surfaceVariantDark = Color(0x66001E2C),
    surfaceVariantLight = Color(0x40001E2C),
)

val NormalTypeColors = TypeColors(
    primaryDark = Color(0xffC7C9A7),
    primaryLight = Color(0xff2F321A),
    surfaceDark = Color(0xff47483B),
    surfaceLight = PokemonColors.Normal,
    onSurfaceDark = Color(0xffC8C7B7),
    onSurfaceLight = Color(0xFF39400A),
    surfaceVariantDark = Color(0x66181B03),
    surfaceVariantLight = Color(0x40191C03),
)

val PoisonTypeColors = TypeColors(
    primaryDark = Color(0xffFFACE9),
    primaryLight = PokemonColors.Poison,
    surfaceDark = Color(0xff752769),
    onSurfaceDark = Color(0xffFFD7F1),
    surfaceVariantDark = Color(0x66390033),
    surfaceVariantLight = Color(0x26390033),
)

val PsychicTypeColors = TypeColors(
    primaryDark = Color(0xffF95095),
    primaryLight = PokemonColors.Psychic,
    surfaceDark = Color(0xff8E0049),
    onSurfaceDark = Color(0xffFFD9E2),
    surfaceVariantDark = Color(0x663E001D),
    surfaceVariantLight = Color(0x403E001D),
)

val RockTypeColors = TypeColors(
    primaryDark = Color(0xffE1C64B),
    primaryLight = PokemonColors.Rock,
    surfaceDark = Color(0xff534600),
    onSurfaceDark = Color(0xffFFF0BF),
    onSurfaceLight = Color(0xff463B00),
    surfaceVariantDark = Color(0x66221B00),
    surfaceVariantLight = Color(0x26221B00),
)

val WaterTypeColors = TypeColors(
    primaryDark = Color(0xff037BCB),
    primaryLight = PokemonColors.Water,
    surfaceDark = Color(0xff00497C),
    onSurfaceDark = Color(0xffE9F1FF),
    surfaceVariantDark = Color(0x66001D36),
    surfaceVariantLight = Color(0x33001D36),
)
