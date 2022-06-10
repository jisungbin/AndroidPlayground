@file:Suppress("unused")

package land.sungbin.androidplayground.test

// 컴포저블 트리를 횡단하며 모든 노드를 해석하고 실제 UI 로 그림
interface Applier<N> {
    // 현재의 작업이 적용될 노드, down 또는 up 호출로 변경됨
    val current: N

    // 트리를 "아래로" 순회함
    fun down(node: N)

    // 트리를 "위로" 순회함
    fun up()

    // 노드를 하향식으로 삽입함
    fun insertTopDown(index: Int, instance: N)

    // 노드를 상향식으로 삽입함
    fun insertBottomUp(index: Int, instance: N)

    // ...
}
