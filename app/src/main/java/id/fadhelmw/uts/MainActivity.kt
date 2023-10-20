package id.fadhelmw.uts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import id.fadhelmw.uts.data.DataSource
import id.fadhelmw.uts.model.Games


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MMORPGGamesApp()
        }
    }
}

@Composable
fun MMORPGGamesApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp)
        ) {
            Text("Top-Up MMORPG Games", style = MaterialTheme.typography.bodyLarge, color = Color.White)
        }

        GameList()
    }
}

//menampilkan daftar game
@Composable
fun GameList() {
    //mengambil data game dari data layer (data/DataSource)
    val games = DataSource.games
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(games.size) { index ->
            GameItem(DataSource.games[index])
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

//menampilkan detail dari nama game, gambar, teks
@Composable
    fun GameItem(game: Games) {
    Card( //latar belakang c
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(id = game.title),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
            Image(
                painter = painterResource(id = game.imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp)) //memberikan jarak vertikal

            //box untuk function topup
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFE4B5))
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween //mengatur jarak kanan-kiri agar seimbang
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically, //mengatur jarak disusun secara vertikal
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ShoppingCart, //package icon diambil dari composable
                            contentDescription = null, //karena akses pembayaran belum dibuat maka diset null
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Text("Topup")
                }
            }
        }
    }
}
@Preview
@Composable
fun MMORPGGamesPreview(){
    MMORPGGamesApp()
}