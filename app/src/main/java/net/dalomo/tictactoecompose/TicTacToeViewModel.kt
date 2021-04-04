package net.dalomo.tictactoecompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {

    private val _OX0 = MutableLiveData(0)
    var OX0: LiveData<Int> = _OX0
    private val _OX1 = MutableLiveData(0)
    var OX1: LiveData<Int> = _OX1
    private val _OX2 = MutableLiveData(0)
    var OX2: LiveData<Int> = _OX2
    private val _OX3 = MutableLiveData(0)
    var OX3: LiveData<Int> = _OX3
    private val _OX4 = MutableLiveData(0)
    var OX4: LiveData<Int> = _OX4
    private val _OX5 = MutableLiveData(0)
    var OX5: LiveData<Int> = _OX5
    private val _OX6 = MutableLiveData(0)
    var OX6: LiveData<Int> = _OX6
    private val _OX7 = MutableLiveData(0)
    var OX7: LiveData<Int> = _OX7
    private val _OX8 = MutableLiveData(0)
    var OX8: LiveData<Int> = _OX8

    private val _turn = MutableLiveData(1)
    var turn: LiveData<Int> = _turn

    fun onClick(index: Int) {
        when (index) {
            0 -> {
                if (_OX0.value == 0)
                    _OX0.value = turn.value
            }
            1 -> {
                if (_OX1.value == 0)
                    _OX1.value = turn.value
            }
            2 -> {
                if (_OX2.value == 0)
                    _OX2.value = turn.value
            }
            3 -> {
                if (_OX3.value == 0)
                    _OX3.value = turn.value
            }
            4 -> {
                if (_OX4.value == 0)
                    _OX4.value = turn.value
            }
            5 -> {
                if (_OX5.value == 0)
                    _OX5.value = turn.value
            }
            6 -> {
                if (_OX6.value == 0)
                    _OX6.value = turn.value
            }
            7 -> {
                if (_OX7.value == 0)
                    _OX7.value = turn.value
            }
            8 -> {
                if (_OX8.value == 0)
                    _OX8.value = turn.value
            }
        }
        _turn.value = _turn.value!! * (-1)

        if (_OX0.value != 0 && _OX1.value!! != 0 && _OX2.value!! != 0 && _OX3.value!! != 0 && _OX4.value!! != 0 && _OX5.value!! != 0 && _OX6.value!! != 0 && _OX7.value!! != 0 && _OX8.value!! != 0) {
            _turn.value = 0
        }
    }

    fun resetBoard() {
        _OX0.value = 0
        _OX1.value = 0
        _OX2.value = 0
        _OX3.value = 0
        _OX4.value = 0
        _OX5.value = 0
        _OX6.value = 0
        _OX7.value = 0
        _OX8.value = 0

        _turn.value = 1
    }
}