import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TTTViewModel : ViewModel() {
    var gridSize: MutableState<Int> = mutableStateOf(3)
    var gameBoard: MutableState<Array<Array<String>>> = mutableStateOf(Array(gridSize.value) { Array(gridSize.value) { "" } })
    var currentPlayer: MutableState<String> = mutableStateOf("X")
    var gameStatus: MutableState<String> = mutableStateOf("")

    fun changeGridSize(newSize: Int) {
        gridSize.value = newSize
        resetGame()
    }

    fun resetGame() {
        gameBoard.value = Array(gridSize.value) { Array(gridSize.value) { "" } }
        currentPlayer.value = "X"
        gameStatus.value = ""
    }

    fun play(i: Int, j: Int) {
        if (gameBoard.value[i][j] == "" && gameStatus.value == "") {
            gameBoard.value[i][j] = currentPlayer.value
            if (checkForWin()) {
                gameStatus.value = "Player ${currentPlayer.value} won!"
            } else {
                currentPlayer.value = if (currentPlayer.value == "X") "O" else "X"
            }
        }
    }

    private fun checkForWin(): Boolean {
        for (i in 0 until gridSize.value) {
            if (gameBoard.value[i].all { it == currentPlayer.value }) return true
            if (gameBoard.value.map { it[i] }.all { it == currentPlayer.value }) return true
        }
        if (gameBoard.value.indices.all { gameBoard.value[it][it] == currentPlayer.value }) return true
        if (gameBoard.value.indices.all { gameBoard.value[it][gridSize.value - it - 1] == currentPlayer.value }) return true
        return false
    }
}