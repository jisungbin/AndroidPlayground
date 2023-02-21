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
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                            .padding(30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "일정 준비 중이에요.\n조금만 기다려주세요!",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            modifier = Modifier
                                .padding(all = 8.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(8.dp),
                                ),
                            text = "일정 새로고침",
                        )
                    }
                },
                content = { padding ->
                    Column(
                        modifier = Modifier
                            .padding(padding)
                            .padding(top = 8.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .border(width = 1.dp, color = Color.LightGray)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(4.dp)
                                .clip(RoundedCornerShape(30.dp))
                                .background(color = Color.LightGray),
                            text = "D-?",
                            color = Color.Gray,
                            fontSize = 13.sp,
                        )
                        Text(
                            text = "등록된 일정이 없어요",
                            fontSize = 20.sp,
                        )
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center,
                        ) {
                            Image(
                                modifier = Modifier.size(150.dp),
                                painter = painterResource(R.drawable.img_mashup_sleeping),
                                contentDescription = null,
                            )
                        }
                    }
                },
                bottomBar = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(color = Color.White),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.round_tv_24),
                            contentDescription = null,
                        )
                        Icon(
                            painter = painterResource(R.drawable.round_qr_code_scanner_24),
                            contentDescription = null,
                        )
                        Icon(
                            painter = painterResource(R.drawable.round_emoji_people_24),
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    }
}
