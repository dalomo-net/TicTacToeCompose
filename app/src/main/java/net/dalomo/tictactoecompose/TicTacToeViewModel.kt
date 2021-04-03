package net.dalomo.tictactoecompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {

    private val _arrOX = MutableLiveData(arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0))
    val arrOX: LiveData<Array<Int>> = _arrOX

    fun onClicked(index: Int) {
        _arrOX.value?.set(index, 0)
    }
}