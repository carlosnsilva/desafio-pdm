package com.example.proejto_desafio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import com.example.proejto_desafio.DAO.coresDAO

class formActivity : AppCompatActivity() {
    private lateinit var corVerde: SeekBar
    private lateinit var corAzul: SeekBar
    private lateinit var corVermelho: SeekBar
    private lateinit var corDAO: coresDAO
    private lateinit var nome: EditText
    private lateinit var botaoSalvar: Button
    private lateinit var botaoCancelar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
    }
}