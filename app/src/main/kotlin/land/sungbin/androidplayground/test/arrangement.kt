@file:OptIn(ExperimentalMaterial3Api::class)
@file:Suppress("unused")

package land.sungbin.androidplayground.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private object RealTopWithFooter : Arrangement.Vertical {
    /**
     * @param totalSize 자식이 차지할 수 있는 사용 가능한 픽셀 공간
     * @param sizes 모든 자식의 픽셀 단위 크기 배열
     * -> Vertical 이니 크기는 높이가 됨
     * @param outPositions 위쪽을 기준으로 계산된 위치를
     * 픽셀 단위로 반환하는 크기의 배열
     */
    override fun Density.arrange(
        totalSize: Int,
        sizes: IntArray,
        outPositions: IntArray,
    ) {
        var y = 0 // 아이템 y 위치
        sizes.forEachIndexed { index, size ->
            outPositions[index] = y // 아이템 배치
            y += size // y 늘리기 (기존 y 에 배치된 아이템 높이 만큼 추가)
            if (index != sizes.lastIndex) { // 마지막 항목이 아닐 때
                y += 100 // 100 만큼 패딩 추가
            }
        }
        if (y < totalSize) {
            // 만약 배치 가능한 공간이 남았다면
            // 전체 공간에서 마지막 아이템의 높이 만큼 빼서
            // 마지막 아이템을 배치 + 100 만큼 패딩 추가
            outPositions[outPositions.lastIndex] = totalSize - sizes.last() - 100
        }
    }
}

@Composable
fun CustomArrangementTest() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = RealTopWithFooter,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(count = 5) { index ->
            Text(text = "${index}번째 항목")
        }
        item {
            Text(
                text = "© 성빈랜드",
            )
        }
    }
}

@Composable
fun BasicArrangementTest() {
    Card(
        modifier = Modifier.size(width = 300.dp, height = 200.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProvideTextStyle(LocalTextStyle.current.copy(fontSize = 20.sp)) {
                Text(text = "가운데 배치되는 텍스트 - 1")
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "가운데 배치되는 텍스트 - 2")
            }
        }
    }
}

@Composable
private fun DummyBasicArrangement() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "가운데 배치되는 텍스트 - 1")
        Text(text = "가운데 배치되는 텍스트 - 2")
    }
}

@Composable
private fun DummyCustomArrangementTest() {
    LazyColumn(verticalArrangement = RealTopWithFooter) {
        items(count = 5) { index ->
            Text(text = "${index}번째 항목")
        }
        item {
            Text(text = "© 성빈랜드")
        }
    }
}

object TopWithFooter : Arrangement.Vertical {
    override fun Density.arrange(
        totalSize: Int, // 배치 가능한 공간
        sizes: IntArray, // 아이템들의 높이 배열
        outPositions: IntArray, // 배치될 위치가 담길 배열
    ) {
        var y = 0 // 아이템 y 위치
        sizes.forEachIndexed { index, size ->
            outPositions[index] = y // 아이템 배치
            y += size // y 에 배치된 아이템 높이 만큼 추가
        }
        if (y < totalSize) { // 만약 배치 가능한 공간이 남았다면
            // 전체 공간에서 마지막 아이템의 높이 만큼 빼서
            // 마지막 아이템을 배치
            outPositions[outPositions.lastIndex] = totalSize - sizes.last()
        }
    }
}
