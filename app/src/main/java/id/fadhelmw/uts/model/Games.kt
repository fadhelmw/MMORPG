package id.fadhelmw.uts.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Games(
    @StringRes val title: Int,
    val rank: Int,
    @DrawableRes val imageRes: Int
)