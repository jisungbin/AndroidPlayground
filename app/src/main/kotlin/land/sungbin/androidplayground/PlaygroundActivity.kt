@file:OptIn(ExperimentalComposeUiApi::class)

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cell.component.CellBadgeColor
import cell.component.CellLargeBadge
import cell.component.CellMediumBadge
import cell.style.cellIcon

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      var iconPainter by remember { mutableStateOf<Painter?>(null) }

      Column(modifier = Modifier.fillMaxSize()) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
          CellLargeBadge(
            "LargeBadge",
            CellBadgeColor.Orange,
            modifier = Modifier.run {
              val icon = iconPainter
              if (icon != null) cellIcon(icon, iconDescription = null) else this
            },
          )

          CellMediumBadge(
            "MediumBadge",
            CellBadgeColor.Orange,
            modifier = Modifier.run {
              val icon = iconPainter
              if (icon != null) cellIcon(icon, iconDescription = null) else this
            },
          )
        }
        Column(
          modifier = Modifier
            .weight(2f)
            .fillMaxSize(),
          verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          val heartPainter = painterResource(R.drawable.ic_round_favorite_24)
          val robotPainter = painterResource(R.drawable.ic_round_android_24)

          Button(onClick = { iconPainter = null }) {
            Text("Remove icon")
          }
          Button(onClick = { iconPainter = heartPainter }) {
            Text("Show Heart icon")
          }
          Button(onClick = { iconPainter = robotPainter }) {
            Text("Show Robot icon")
          }
        }
      }
    }
  }
}
