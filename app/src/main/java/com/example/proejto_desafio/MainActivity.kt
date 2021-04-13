package com.example.proejto_desafio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.proejto_desafio.DAO.coresDAO
import com.example.proejto_desafio.adapter.corAdapter
import com.example.proejto_desafio.adapter.corCadastro
import com.example.proejto_desafio.modelo.Cor
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var listaCores: ListView
    private lateinit var botaoAdicionar: FloatingActionButton
    private lateinit var cadastroCor: corCadastro
    private lateinit var coresDAO: coresDAO
    private lateinit var cores: ArrayList<Cor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.coresDAO = coresDAO(this)
        this.cadastroCor = corCadastro()
        this.listaCores = findViewById(R.id.listaCores)
        this.botaoAdicionar = findViewById(R.id.addButton)
        this.listaCores.adapter = corAdapter(cadastroCor, this)
        this.listaCores.onItemClickListener = click()
        this.listaCores.onItemLongClickListener = clickLongo()
        this.botaoAdicionar.setOnClickListener(clickBotaoAdicionar())
        this.cores = this.coresDAO.select()
        (this.listaCores.adapter as corAdapter).setListaCor(cores)
    }

    inner class clickBotaoAdicionar: View.OnClickListener{
        override fun onClick(v: View?) {
            val intent = Intent(this@MainActivity, )
        }
    }

}