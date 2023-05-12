package com.example.tictactoe
import TTTViewModel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle

class MainActivity : ComponentActivity() {
    private val viewModel: TTTViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Grid Size: ${viewModel.gridSize.value}")
                Row {
                    Button(onClick = { viewModel.changeGridSize(viewModel.gridSize.value - 1) }) {
                        Text(text = "-")
                    }
                    Button(onClick = { viewModel.changeGridSize(viewModel.gridSize.value + 1) }) {
                        Text(text = "+")
                    }
                }
                Button(onClick = { viewModel.resetGame() }) {
                    Text(text = "Reset")
                }
                if (viewModel.gameStatus.value.isNotEmpty()) {
                    Text(text = viewModel.gameStatus.value, style = TextStyle(color = Color.DarkGray))
                } else {
                    val currentPlayerColor = when(viewModel.currentPlayer.value) {
                        "O" -> Color.Green
                        "X" -> Color.Red
                        else -> Color.Gray
                    }
                    Text(text = "Player ${viewModel.currentPlayer.value}'s turn", style = TextStyle(color = currentPlayerColor))
                }

                // Board container
                Box(modifier = Modifier.padding(8.dp)) {
                    val buttonSize = 320.dp / viewModel.gridSize.value.coerceAtLeast(1)
                    LazyColumn {
                        itemsIndexed(viewModel.gameBoard.value) { rowIndex, rowData ->
                            Row {
                                rowData.forEachIndexed { columnIndex, cell ->
                                    val cellColor = when(cell) {
                                        "O" -> Color.Green
                                        "X" -> Color.Red
                                        else -> Color.Gray
                                    }
                                    Button(
                                        onClick = {
                                            viewModel.play(rowIndex, columnIndex)
                                        },
                                        colors = ButtonDefaults.buttonColors(backgroundColor = cellColor),
                                        modifier = Modifier
                                            .padding(1.dp)
                                            .size(buttonSize)
                                    ) {
                                        Text(text = cell)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}