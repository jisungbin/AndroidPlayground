@file:OptIn(ExperimentalMaterial3Api::class)

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HomeScreen()
    }
  }

  @Composable
  fun HomeScreen() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Home", "Favorites", "Profile")

    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text("App Title") }
        )
      },
      bottomBar = {
        BottomNavigationBar(selectedItem = selectedItem, onItemSelected = { selectedItem = it }, items = items)
      }
    ) { innerPadding ->
      MainContent(innerPadding, "Content goes here")
    }
  }

  @Composable
  fun TopAppBar(title: @Composable () -> Unit) {
    CenterAlignedTopAppBar(title = title)
  }

  @Composable
  fun BottomNavigationBar(selectedItem: Int, onItemSelected: (Int) -> Unit, items: List<String>) {
    NavigationBar {
      items.forEachIndexed { index, item ->
        NavigationBarItem(
          icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
          label = { Text(item) },
          selected = selectedItem == index,
          onClick = { onItemSelected(index) }
        )
      }
    }
  }

  @Composable
  fun MainContent(paddingValues: PaddingValues, content: String) {
    Text(text = content, modifier = Modifier.padding(paddingValues))
  }
}
