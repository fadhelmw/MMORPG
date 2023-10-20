package id.fadhelmw.uts.data

import id.fadhelmw.uts.R
import id.fadhelmw.uts.model.Games

object DataSource {
    val games = listOf(
        Games(R.string.sealonline, 1, R.drawable.sealonline),
        Games(R.string.rfonline, 2, R.drawable.rfonline),
        Games(R.string.lunaonline, 3, R.drawable.lunaonline),
        Games(R.string.codmw, 4, R.drawable.codmw),
        Games(R.string.ml, 5, R.drawable.ml),
        Games(R.string.apex, 6, R.drawable.apex),
        Games(R.string.fortnite, 7, R.drawable.fortnite),
        Games(R.string.warzone, 8, R.drawable.warzone),
        Games(R.string.atlantica, 9, R.drawable.atlantica),
        Games(R.string.easport, 10, R.drawable.easport)
    )
}