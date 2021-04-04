package net.dalomo.tictactoecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.dalomo.tictactoecompose.ui.theme.Shapes
import net.dalomo.tictactoecompose.ui.theme.TicTacToeComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GameScreen()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun GameScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(16.dp))
        Turn()
        Spacer(modifier = Modifier.padding(32.dp))

        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = Modifier
                .size((88 * 3).dp)
        ) {
            item { Cell(0) }
            item { Cell(1) }
            item { Cell(2) }
            item { Cell(3) }
            item { Cell(4) }
            item { Cell(5) }
            item { Cell(6) }
            item { Cell(7) }
            item { Cell(8) }
        }
        ResetButton()
    }

    // Column {
    //     Text(text = "Hello, $name")
    //     TextField(
    //         value = name,
    //         onValueChange = { helloViewModel.onNameChanged() },
    //         label = { Text("Name") }
    //     )
    // }
}

@Composable
fun Turn(tttViewModel: TicTacToeViewModel = viewModel()) {

    val turn = tttViewModel.turn.observeAsState(initial = 1)
    val t = when (turn.value) {
        1 -> {
            "O Turn !"
        }
        -1 -> {
            "X Turn !"
        }
        else -> "Finish !"
    }

    Text(
        text = t,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(fontSize = 40.sp, textAlign = TextAlign.Center)
    )
}

@Composable
fun Cell(index: Int, tttViewModel: TicTacToeViewModel = viewModel()) {
    val OX0 = tttViewModel.OX0.observeAsState(0)
    val OX1 = tttViewModel.OX1.observeAsState(0)
    val OX2 = tttViewModel.OX2.observeAsState(0)
    val OX3 = tttViewModel.OX3.observeAsState(0)
    val OX4 = tttViewModel.OX4.observeAsState(0)
    val OX5 = tttViewModel.OX5.observeAsState(0)
    val OX6 = tttViewModel.OX6.observeAsState(0)
    val OX7 = tttViewModel.OX7.observeAsState(0)
    val OX8 = tttViewModel.OX8.observeAsState(0)

    var str = ""

    when (index) {
        0 -> {
            str = if (OX0.value == 1) "O" else if (OX0.value == -1) "X" else ""
        }
        1 -> {
            str = if (OX1.value == 1) "O" else if (OX1.value == -1) "X" else ""
        }
        2 -> {
            str = if (OX2.value == 1) "O" else if (OX2.value == -1) "X" else ""
        }
        3 -> {
            str = if (OX3.value == 1) "O" else if (OX3.value == -1) "X" else ""
        }
        4 -> {
            str = if (OX4.value == 1) "O" else if (OX4.value == -1) "X" else ""
        }
        5 -> {
            str = if (OX5.value == 1) "O" else if (OX5.value == -1) "X" else ""
        }
        6 -> {
            str = if (OX6.value == 1) "O" else if (OX6.value == -1) "X" else ""
        }
        7 -> {
            str = if (OX7.value == 1) "O" else if (OX7.value == -1) "X" else ""
        }
        8 -> {
            str = if (OX8.value == 1) "O" else if (OX8.value == -1) "X" else ""
        }
    }

    Box(
        modifier = Modifier
            .size(88.dp)
            .border(border = BorderStroke(width = 1.dp, color = Color.Black))
            .clickable { tttViewModel.onClick(index) }
    ) {
        Text(
            text = str,
            modifier = Modifier.fillMaxSize(),
            style = TextStyle(fontSize = 56.sp, textAlign = TextAlign.Center)
        )
    }
}

@Composable
fun ResetButton(tttViewModel: TicTacToeViewModel = viewModel()) {
    Button(
        onClick = { tttViewModel.resetBoard() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp)
            .height(56.dp)
            .clip(shape = Shapes.large)
    ) {
        Text(text = "Reset", style = TextStyle(fontSize = 24.sp))
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TicTacToeComposeTheme {
        GameScreen()
    }
}
