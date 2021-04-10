package com.example.proejto_desafio

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import com.example.proejto_desafio.DAO.coresDAO
import com.example.proejto_desafio.modelo.Cor

class formActivity : AppCompatActivity() {
    private lateinit var corVerde: SeekBar
    private lateinit var corAzul: SeekBar
    private lateinit var corVermelho: SeekBar
    private lateinit var corDAO: coresDAO
    private lateinit var nome: EditText
    private lateinit var botaoSalvar: Button
    private lateinit var botaoCancelar: Button
    private var corResultado: Int = 0
    private lateinit var botaoResultado: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.corVerde = findViewById(R.id.barraVerde)
        this.corVermelho = findViewById(R.id.barraVermelho)
        this.corAzul = findViewById(R.id.barraAzul)
        this.botaoSalvar = findViewById(R.id.botaoSalvar)
        this.botaoCancelar = findViewById(R.id.botaoCancelar)
        this.nome = findViewById(R.id.campoNome)
        this.corDAO = coresDAO(this)
        this.botaoResultado = findViewById(R.id.resultCor)

        if(intent.hasExtra("cor")){
            val cor1 = intent.getSerializableExtra("cor") as Cor

            this.nome.setText(cor1.nome)
            this.corAzul.progress = Color.blue(cor1.codigo)
            this.corVermelho.progress = Color.red(cor1.codigo)
            this.corVerde.progress = Color.green(cor1.codigo)
            this.corResultado = cor1.codigo


        }


    }
}