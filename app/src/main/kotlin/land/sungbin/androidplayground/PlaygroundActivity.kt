@file:NoLiveLiterals
@file:Suppress("ReplaceWithOperatorAssignment", "SetTextI18n", "UnusedReceiverParameter")
@file:OptIn(ExperimentalMaterial3Api::class)

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val MashupGray = Color(red = 248, green = 247, blue = 252)

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUiController(window).run {
            setStatusBarColor(color = MashupGray.toArgb(), darkIcons = true)
            setNavigationBarColor(color = Color.White.toArgb(), darkIcons = true)
        }

        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = MashupGray,
                topBar = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp)
                            .padding(horizontal = 30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "일정 준비 중이에요.\n조금만 기다려 주세요!",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(8.dp))
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(8.dp),
                                )
                                .background(color = Color.White)
                                .padding(all = 8.dp),
                            text = "일정 새로고침",
                        )
                    }
                },
                content = { padding ->
                    Column(
                        modifier = Modifier
                            .padding(padding)
                            .padding(all = 30.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(20.dp),
                            )
                            .background(color = Color.White)
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        Text(
                            modifier = Modifier
                                .clip(RoundedCornerShape(30.dp))
                                .background(color = MashupGray)
                                .padding(vertical = 4.dp, horizontal = 8.dp),
                            text = "D-?",
                            color = Color.DarkGray,
                            fontSize = 13.sp,
                        )
                        Text(
                            text = "등록된 일정이 없어요",
                            color = Color.Gray,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(shape = RoundedCornerShape(20.dp))
                                .background(color = MashupGray, shape = RoundedCornerShape(20.dp)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Image(
                                modifier = Modifier.size(150.dp),
                                painter = painterResource(R.drawable.img_mashup_sleeping),
                                contentDescription = null,
                            )
                            Text(
                                modifier = Modifier.padding(top = 4.dp),
                                text = "열심히 일정을 준비하고 있어요\n조금만 기다려 주세요!",
                                fontSize = 15.sp,
                                color = Color.Gray,
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                },
                bottomBar = {
                    Row(
                        modifier = Modifier
                            .shadow(elevation = 10.dp)
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(color = Color.White),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            modifier = Modifier.weight(1f),
                            painter = painterResource(R.drawable.round_tv_24),
                            contentDescription = null,
                        )
                        Icon(
                            modifier = Modifier.weight(1f),
                            painter = painterResource(R.drawable.round_qr_code_scanner_24),
                            contentDescription = null,
                        )
                        Icon(
                            modifier = Modifier.weight(1f),
                            painter = painterResource(R.drawable.round_emoji_people_24),
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    }
}
