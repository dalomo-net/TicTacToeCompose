package net.dalomo.tictactoecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
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
import androidx.compose.runtime.getValue
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
fun GameScreen(tttViewModel: TicTacToeViewModel = viewModel()) {
    val arrOX: Array<Int> by tttViewModel.arrOX.observeAsState(arrayOf())

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
                .size(240.dp)
        ) {
            item { Cell() }
            item { Cell() }
            item { Cell() }
            item { Cell() }
            item { Cell() }
            item { Cell() }
            item { Cell() }
            item { Cell() }
            item { Cell() }
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
fun Turn() {
    Text(
        text = "○" + " Turn !",
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(fontSize = 40.sp, textAlign = TextAlign.Center)
    )
}

@Composable
fun Cell() {
    Box(
        modifier = Modifier
            .size(80.dp)
            .border(border = BorderStroke(width = 1.dp, color = Color.Black))
    ) {
        Text(
            text = "O",
            modifier = Modifier.fillMaxSize(),
            style = TextStyle(fontSize = 56.sp, textAlign = TextAlign.Center)
        )
    }
}

@Preview
@Composable
fun ResetButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp)
            .height(56.dp)
            .clip(shape= Shapes.large )
    ) {
        Text(text = "Reset",style = TextStyle(fontSize = 24.sp))
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
